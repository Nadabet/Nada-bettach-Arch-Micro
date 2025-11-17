package com.example.billing.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "inventory-service")
public interface ProductFeignClient {

    @GetMapping("/products/{id}")
    Object getProduct(@PathVariable Long id);
}

