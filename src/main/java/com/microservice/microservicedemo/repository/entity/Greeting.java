package com.microservice.microservicedemo.repository.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import java.sql.Timestamp;

@Entity
public class Greeting {
    private String name;
    private String greeting;
    private Timestamp insertdatetime;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGreeting() {
        return greeting;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }

    public Timestamp getInsertdatetime() {
        return insertdatetime;
    }

    public void setInsertdatetime(Timestamp insertdatetime) {
        this.insertdatetime = insertdatetime;
    }
}
