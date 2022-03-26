package com.microservice.microservicedemo.repository;

import com.microservice.microservicedemo.repository.entity.Greeting;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GreetingMapper implements RowMapper<Greeting> {


    @Override
    public Greeting mapRow(ResultSet rs, int rowNum) throws SQLException {
        Greeting greeting = new Greeting();
        greeting.setGreeting(rs.getString("greeting"));
        greeting.setName(rs.getString("name"));
        greeting.setInsertdatetime(rs.getTimestamp("insertdatetime"));


        return greeting;
    }
}
