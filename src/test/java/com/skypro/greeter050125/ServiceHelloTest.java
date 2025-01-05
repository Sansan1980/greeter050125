package com.skypro.greeter050125;

import com.skypro.greeter050125.service.ServiceHello;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ServiceHelloTest {
    private ServiceHello serviceHello;
    private Random randomMock;

    @BeforeEach
    public void setUp() {
        randomMock = mock(Random.class);// Создаем мок объект Random
        // Передаем его в ServiceHello serviceHello инициализируя  serviceHello через new ServiceHello() (показываем, что при тестировании из этого класса мы не учитываем бизнесс - логику
        // тестируемого класса ServiseHello. Ставим "заглушку " на класс Random- делаем вместо этого класса фальшивку
        // где прописываем и случайность цифр и необходимый ответ-возврат значений, по сути просто указываем  , что и в какой момент возвращать!(?)(кому возвращать?)
        serviceHello = new ServiceHello(randomMock);// передаем мок объект Random в сервис public class ServiceHello
    }

    @Test
    @DisplayName("Мок  метод randomHello когда пришла еденица и case  1-> Hello ")
    public void whenRandomIsOne_ThenReturnHello() {
        //программируем мок возвращать еденицу
        when(randomMock.nextInt(1, 5)).thenReturn(1);
        String result = serviceHello.randomHello();
        //Проверяем результат метода randomHello с заданным в этом методе  значением по case ( 1-> "Hello")
        assertEquals("Hello", result);
    }
    @Test
    @DisplayName("Мок  метод randomHello когда пришла 2 и case  2-> Privet ")
    public void whenRandomIsTwo_ThenReturnPrivet() {
        //программируем мок возвращать еденицу
        when(randomMock.nextInt(1, 5)).thenReturn(2);
        String result = serviceHello.randomHello();
        //Проверяем результат метода randomHello с заданным в этом методе  значением по case ( 2-> "Hello")
        assertEquals("Privet", result);

    }
    @Test
    @DisplayName("Мок  метод randomHello когда пришла 3 и case  3-> Salyt ")
    public void whenRandomIsThree_ThenReturnSalyt() {
        //программируем мок возвращать еденицу
        when(randomMock.nextInt(1, 5)).thenReturn(3);
        String result = serviceHello.randomHello();
        //Проверяем результат метода randomHello с заданным в этом методе  значением по case ( 3-> "Hello")
        assertEquals("Salyt", result);
    }
    @Test
    @DisplayName("Мок  метод randomHello когда пришла 4 и case  4-> Salyt ")
    public void whenRandomIsFourOrMore_ThenReturnSalyt() {
        //программируем мок возвращать еденицу
        when(randomMock.nextInt(1, 5)).thenReturn(4);
        String result = serviceHello.randomHello();
        //Проверяем результат метода randomHello с заданным в этом методе  значением по case ( 4-> "Hay")
        assertEquals("Hay", result);

    }
}
