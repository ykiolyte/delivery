package com.example.del.controller;

import com.example.del.entity.Shipment;
import com.example.del.service.ShipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shipments")
public class ShipmentController {

    @Autowired
    private ShipmentService shipmentService;

    @GetMapping
    public List<Shipment> getAllShipments() {
        return shipmentService.getAllShipments();
    }

    @GetMapping("/{id}")
    public Shipment getShipmentById(@PathVariable Long id) {
        return shipmentService.getShipmentById(id);
    }

    @PostMapping
    public Shipment addShipment(@RequestBody Shipment shipment) {
        return shipmentService.addShipment(shipment);
    }

    @DeleteMapping("/{id}")
    public void deleteShipment(@PathVariable Long id) {
        shipmentService.deleteShipment(id);
    }
}
