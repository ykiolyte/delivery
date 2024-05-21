package com.example.del.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.del.entity.User;
import com.example.del.service.UserService;

@Controller
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:3000")
public class AuthController {

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    @ResponseBody
    public String registerUser(@RequestBody User user) {
        userService.saveUser(user);
        return "User registered successfully!";
    }

    @PostMapping("/login")
    @ResponseBody
    public String loginUser(@RequestBody User user) {
        User authenticatedUser = userService.authenticateUser(user.getUsername(), user.getPassword());
        if (authenticatedUser != null) {
            return "User authenticated successfully!";
        } else {
            return "Invalid username or password!";
        }
    }
}