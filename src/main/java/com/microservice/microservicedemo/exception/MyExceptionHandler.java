package com.microservice.microservicedemo.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Slf4j
@ControllerAdvice
public class MyExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<Object> handleRunTimeException(RuntimeException runtimeException, HttpServletRequest req,
                                                         WebRequest web, HttpSession session) {
        log.error(runtimeException.getMessage());
        return ResponseEntity.status(500).contentType(MediaType.APPLICATION_JSON).body("dummy RuntimeException message");
    }

    @ExceptionHandler
    public ResponseEntity<Object> handleException(Exception exception) {
        log.error(exception.getMessage());
        return ResponseEntity.status(404).contentType(MediaType.APPLICATION_JSON).body("dummy Exception message");
    }

    /*@ExceptionHandler
    public ResponseEntity<Object> handleException(List<Exception> exceptionList) {
        return ResponseEntity.status(404).contentType(MediaType.APPLICATION_JSON).body("dummy Exception message");
    }*/
}
