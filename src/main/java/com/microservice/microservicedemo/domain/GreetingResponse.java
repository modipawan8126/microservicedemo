package com.microservice.microservicedemo.domain;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class GreetingResponse {
    private String name;
    private String greeting;
    private Timestamp insertedTime;
}
