package com.skypro.greeter050125.service;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class ServiceHello {
    private final Random random;//почему здесь немогу поставить new Random

    public  ServiceHello(){
        this.random = new Random();//это для GreeterServiceTest для инициализации инжекции поля greeterServise
    }
    public ServiceHello(Random randomMock){//(randomMock - показал что и откуда приходит) //это для теста ServiseHelloTest для
        // инициализации инжекции поля  serviceHello //public class ServiceHelloTest
        this.random = randomMock;
    }
    public String randomHello() {
        return switch (random.nextInt(1, 5)) {
            case 1-> "Hello";
            case 2-> "Privet";
            case 3-> "Salyt";
            default -> "Hay";
        };
    }

}
