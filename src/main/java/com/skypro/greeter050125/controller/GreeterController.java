package com.skypro.greeter050125.controller;

import com.skypro.greeter050125.service.GreeterServise;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreeterController {
    private final GreeterServise greeterServise;

    public GreeterController(GreeterServise greeterServise) {
        this.greeterServise = greeterServise;
    }
    @GetMapping("/greet")
    public String greet(@RequestParam(value = "name",required = false)String name) {
       return greeterServise.greet(name);
    }
}
