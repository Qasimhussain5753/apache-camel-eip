package com.app.eip.controller;

import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private ProducerTemplate producerTemplate;

    @PostMapping
    public ResponseEntity<String> sendOrder(@RequestBody String order) {
        producerTemplate.sendBody("direct:incomingOrders", order);
        return ResponseEntity.ok("Order received");

    }
}
