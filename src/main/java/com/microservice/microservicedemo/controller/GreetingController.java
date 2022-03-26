package com.microservice.microservicedemo.controller;

import com.microservice.microservicedemo.repository.entity.Greeting;
import com.microservice.microservicedemo.service.MicroservicedemoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class GreetingController {

    @Autowired
    MicroservicedemoService microservicedemoService;

    @GetMapping(value = "/greetings/{name}")
    public List<Greeting> getGreetings(@PathVariable("name") String name) {
        return microservicedemoService.getGreetings(name);
    }

    @GetMapping(value = "/greetings")
    public Iterable<Greeting> getGreetingList() {
        return microservicedemoService.getGreetings();
    }

    @PostMapping(value = "/greetings")
    public String createGreetings(@RequestBody Greeting greeting) {
        return microservicedemoService.saveGreetings(greeting);
    }
}
