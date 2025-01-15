package com.skypro.greeter050125;

import com.skypro.greeter050125.service.ServiceHello;
import com.skypro.greeter050125.service.GreeterServise;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Random;

import static org.mockito.Mockito.mock;

public class GreeterServiceTest {
    private ServiceHello serviceHello;
    private Random randomMock;
    private final GreeterServise greeterServise = new GreeterServise(new ServiceHello());//Кажется чтобы заработал тест нужно передать сюда параметр какой то ?

   /* public GreeterServiceTest(GreeterServise greeterServise) {
        this.greeterServise = new GreeterServise(serviceHello);
    }*/


    @Test
    @DisplayName("Позитивный- когда значение Name - пришло валидное")
    public void WithName() {
        String result = greeterServise.greet("Johan");
        Assertions.assertEquals("Hello, Johan", result);
    }

    @Test
    @DisplayName("Позитивный- когда значение Name - пришло валидное")
    public void WithNameIsEmpty() {
        String result = greeterServise.greet("");
        Assertions.assertEquals("Hello, Anonimus", result);
    }

    @Test
    @DisplayName("Негативный- когда значение NameNull")
    public void WithNameNull() {
        String result = greeterServise.greet(null);
        Assertions.assertEquals("Hello, Anonimus", result);
    }

    @Test
    @DisplayName("Негативный- когда значение NameIsBlank")
    public void WithNameIsBlank() {
        String result = greeterServise.greet("");
        Assertions.assertEquals("Hello, Anonimus", result);
    }
}
