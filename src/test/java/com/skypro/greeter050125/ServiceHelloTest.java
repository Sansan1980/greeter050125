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
    private Random randomMock;//это нужно для того чтобы создать мок класса рандома с этой пееременной

    @BeforeEach
    public void setUp() {
        randomMock = mock(Random.class);// Создаем мок объект Random
        // Передаем его в ServiceHello serviceHello инициализируя  serviceHello через new ServiceHello() (показываем, что при тестировании из этого класса мы не учитываем бизнесс - логику
        // тестируемого класса ServiseHello. Ставим "заглушку " на класс Random- делаем вместо этого класса фальшивку
        // где прописываем и случайность цифр и необходимый ответ-возврат значений, по сути просто указываем  , что и в какой момент возвращать!(?)(кому возвращать?)
        serviceHello = new ServiceHello(randomMock);// передаем мок объект Random в сервис public class ServiceHello
    }

    // вместо сервиса ServiceHello и его бизнесс логики - метода randomHello мы сами прописываем в этом классе все взаимосвязи какое число
// должно быть "Рандом!" и какой ответ значение должен вернуться в класс GreeterServiceTest
    @Test
    @DisplayName(" когда мок возвращает 1 ,то- Hello")
    public void whenRandomIsOne_thenReturnHello() {
        // Программируем мок возвращать 1
        when(randomMock.nextInt(1, 5)).thenReturn(1);
        String result = serviceHello.randomHello();
        assertEquals("Hello", result);
    }
    @Test
    @DisplayName(" когда мок возвращает 2 ,то- Hello")
    public void whenRandomIsTwo_thenReturnPrivet() {
        // Программируем мок возвращать 1
        when(randomMock.nextInt(1, 5)).thenReturn(2);
        String result = serviceHello.randomHello();
        assertEquals("Privet", result);
    }
    @Test
    @DisplayName(" когда мок возвращает 3 ,то- Salyt")
    public void whenRandomIsThree_thenReturnSalyt() {
        // Программируем мок возвращать 1
        when(randomMock.nextInt(1, 5)).thenReturn(3);
        String result = serviceHello.randomHello();
        assertEquals("Salyt", result);
    }
    @Test
    @DisplayName(" когда мок возвращает 4 ,то- Hay")
    public void whenRandomIsFour_thenReturnHay() {
        // Программируем мок возвращать 1
        when(randomMock.nextInt(1, 5)).thenReturn(4);
        String result = serviceHello.randomHello();
        assertEquals("Hay", result);
    }
}