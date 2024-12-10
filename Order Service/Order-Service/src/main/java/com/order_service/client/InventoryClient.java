package com.order_service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "inventory-service", url = "http://localhost:8081/api/inventory")
public interface InventoryClient {

    @GetMapping("/{productId}")
    String checkProductAvailability(@PathVariable("productId") String productId);
}
