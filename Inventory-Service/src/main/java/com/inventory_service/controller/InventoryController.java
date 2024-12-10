package com.inventory_service.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {

    @GetMapping("/{productId}")
    public ResponseEntity<String> checkAvailability(@PathVariable String productId) {
        if (Math.random() < 0.5) {
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body("Service currently not available");
        }
        return ResponseEntity.ok("Product " + productId + " is available");
    }

}
