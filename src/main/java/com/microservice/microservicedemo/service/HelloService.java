package com.microservice.microservicedemo.service;

import org.springframework.stereotype.Service;

@Service
public class HelloService {
    public String getGreeting(String name) throws Exception {
        String response = "Hello " + name;
        //throw new RuntimeException("dummy");
        //throw new Exception("dummy");
        return response;
    }
}
