package com.order_service.service;

import com.order_service.client.InventoryClient;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final InventoryClient inventoryClient;

    public OrderService(InventoryClient inventoryClient) {
        this.inventoryClient = inventoryClient;
    }

    @CircuitBreaker(name = "inventoryService", fallbackMethod = "fallbackForCheckAvailability")
    public String checkAvailability(String productId) {
        return inventoryClient.checkProductAvailability(productId);
    }

    public String fallbackForCheckAvailability(String productId, Throwable throwable) {
        return "Product " + productId + " is unavailable at the moment. Please try later.";
    }
}
