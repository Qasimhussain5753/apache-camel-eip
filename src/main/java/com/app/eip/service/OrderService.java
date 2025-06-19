package com.app.eip.service;

import org.springframework.stereotype.Service;

@Service
public class OrderService {
    public String enrichOrder(String order) {
        return order + "(validated)";
    }
    
}
