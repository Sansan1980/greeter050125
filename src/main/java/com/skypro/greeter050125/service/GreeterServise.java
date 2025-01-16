package com.skypro.greeter050125.service;

import org.springframework.stereotype.Service;

@Service
public class GreeterServise {

    private final ServiceHello serviceHello;

    public GreeterServise(ServiceHello serviceHello) {
        this.serviceHello = serviceHello;
    }
    public String greet(String name) {
        if (name == null || name.isBlank() || name.isEmpty()) {
            return serviceHello.randomHello() + ", Anonimus";
        }
        return serviceHello.randomHello() + ", " + name;
    }
}
