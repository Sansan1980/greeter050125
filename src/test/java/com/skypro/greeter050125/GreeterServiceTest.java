package com.skypro.greeter050125;

import com.skypro.greeter050125.service.ServiceHello;
import com.skypro.greeter050125.service.GreeterServise;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

//Для того чтобы наш тестовый класс мог использовать возможности Mockito, необходимо расширить его с помощью
//MockitoExtension
//. Это делается при помощи аннотации

//@ExtendWith(MockitoExtension.class)
public class GreeterServiceTest {
    private final GreeterServise greeterServise = new GreeterServise(new ServiceHello( ));//new ServiceHello( ) приходит
    // от инжекции в классе ServiceHello |||| public  ServiceHello(){   this.random = new Random()}


    @Test
    @DisplayName("Позитивный- когда значение Name - пришло валидное")
    public void WithName() {
        String result = greeterServise.greet("Johan");
        Assertions.assertEquals("Hello, Johan", result);
    }
}
