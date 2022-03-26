package com.microservice.microservicedemo.repository;

import com.microservice.microservicedemo.repository.entity.Greeting;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

@Slf4j
@Repository
public class GreetingRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    private final static String GET_GREETINGS_BY_NAME = "select * from microservicedemo.greetings where name = ?";
    private final static String GET_ALL_GREETINGS = "select * from microservicedemo.greetings";
    private final static String SAVE_GREETINGS = "INSERT INTO microservicedemo.greetings (name, greeting, insertdatetime) VALUES(?, ?, ?)";
    private final static String DELETE_GREETINGS = "delete from microservicedemo.greetings where name = ?";

    public String saveGreetings(Greeting greeting) {
        log.info("Saving greeting {} - {}", greeting.getName(), greeting.getGreeting());
        Object[] params = {greeting.getName(), greeting.getGreeting(), Timestamp.from(Instant.now())};

        deleteGreeting(greeting.getName());

        jdbcTemplate.update(SAVE_GREETINGS, params);
        log.info("Saved greeting!!");

        return greeting.getName();
    }

    public List<Greeting> getGreetings(String name) {
        log.info("Fetching greeting for {}", name);
        Object[] params = {name};

        List<Greeting> greetings =  jdbcTemplate.query(GET_GREETINGS_BY_NAME, new GreetingMapper(), params);
        return greetings;
    }

    public void deleteGreeting(String name) {
        log.info("Deleting the greeting for name {} if exist", name);
        Object[] params = {name};
        jdbcTemplate.update(DELETE_GREETINGS, params);
    }

    public List<Greeting> getGreetings() {
        log.info("Fetching all greeting ");


        List<Greeting> greetings =  jdbcTemplate.query(GET_ALL_GREETINGS, new GreetingMapper());
        return greetings;
    }
}
