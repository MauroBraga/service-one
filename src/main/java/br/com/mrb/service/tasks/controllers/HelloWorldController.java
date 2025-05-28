package br.com.mrb.service.tasks.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @Value("${message:Default Hello}")
    private String message;

    @GetMapping("/hello")
    public String hello() {
        return message;
    }
}
