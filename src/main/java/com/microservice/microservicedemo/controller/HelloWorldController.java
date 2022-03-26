package com.microservice.microservicedemo.controller;

import com.microservice.microservicedemo.service.HelloService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class HelloWorldController {

    @Autowired
    HelloService helloService;

    @GetMapping("/hello/{name}")
    public ResponseEntity<String> getGrettings(@PathVariable String name) throws Exception {
        log.info("Received request to get greetings for name {}", name);
        /*String response = "Hello " + name;
        return ResponseEntity.ok(response);*/

        return ResponseEntity.ok(helloService.getGreeting(name));
    }
}
