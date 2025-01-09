package com.skypro.greeter050125;

import com.skypro.greeter050125.service.ServiceHello;
import com.skypro.greeter050125.service.GreeterServise;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;


public class GreeterServiceTest {
    ServiceHello serviceHelloMock = Mockito.mock(ServiceHello.class);
    // Настроим поведение мока
  private final  GreeterServise greeterServise = new GreeterServise(new ServiceHello());


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
