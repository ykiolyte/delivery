package com.example.del.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.lang.NonNull;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(@NonNull CorsRegistry registry) {
        registry.addMapping("/**") // разрешаем CORS для всех путей
                .allowedOrigins("*") // разрешаем запросы от всех источников
                .allowedMethods("GET", "POST", "PUT", "DELETE") // разрешаем определенные методы запросов
                .allowedHeaders("*") // разрешаем все заголовки
                .allowCredentials(true); // разрешаем передачу учетных данных (например, куки, аутентификацию) между источниками
    }
}
