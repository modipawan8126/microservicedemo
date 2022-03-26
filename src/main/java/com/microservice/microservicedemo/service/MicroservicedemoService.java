package com.microservice.microservicedemo.service;

import com.microservice.microservicedemo.repository.GreetingRepository;
import com.microservice.microservicedemo.repository.entity.Greeting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MicroservicedemoService {

    @Autowired
    GreetingRepository greetingRepository;

    public List<Greeting> getGreetings(String name) {
            List<Greeting> greetings = greetingRepository.getGreetings(name);
            return greetings;
    }

    public List<Greeting> getGreetings() {
        return greetingRepository.getGreetings();
    }

    public String saveGreetings(Greeting greeting) {
        return greetingRepository.saveGreetings(greeting);
    }
}
