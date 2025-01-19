package com.skypro.greeter050125;

import com.skypro.greeter050125.service.ServiceHello;
import com.skypro.greeter050125.service.GreeterServise;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Random;

import static com.skypro.greeter050125.TestUtils.randomMock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

//Для того чтобы наш тестовый класс мог использовать возможности Mockito, необходимо расширить его с помощью
//MockitoExtension
//. Это делается при помощи аннотации

//@ExtendWith(MockitoExtension.class)
public class GreeterServiceTest {

   private final ServiceHello serviceHello = spy(new ServiceHello(randomMock));
  //  private Random randomMock;


    private final GreeterServise greeterServise = new GreeterServise(serviceHello);//new ServiceHello( ) приходит
    // от инжекции в классе ServiceHello |||| public  ServiceHello(){   this.random = new Random()}


    @Test
    @DisplayName("Позитивный- когда значение Name - пришло валидное")
    public void WithName() {
     //   when(randomMock.nextInt(1, 5)).thenReturn(1);
        when(serviceHello.randomHello()).thenReturn("Hello");
        String result = greeterServise.greet("Johan");
        Assertions.assertEquals("Hello, Johan", result);
    }
    @Test
    @DisplayName("Негативный- когда значение NameIsBlank ")
    public void WithNameIsBlank() {
        when(serviceHello.randomHello()).thenReturn("Privet");
       // when(randomMock.nextInt(1, 5)).thenReturn(2);
        String result = greeterServise.greet("");
        Assertions.assertEquals("Privet, Anonimus", result);

    }
    @Test
    @DisplayName("Позитивный- когда значение NameIsEmpty")
    public void WithNameIsEmpty() {
      //  when(randomMock.nextInt(1, 5)).thenReturn(3);
       when(serviceHello.randomHello()).thenReturn("Salyt");
        String result = greeterServise.greet(" ");
        Assertions.assertEquals("Salyt, Anonimus", result);
    }
}
