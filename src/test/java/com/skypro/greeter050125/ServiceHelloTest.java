package com.skypro.greeter050125;

import com.skypro.greeter050125.service.ServiceHello;
import org.junit.jupiter.api.BeforeEach;

import java.util.Random;

import static org.mockito.Mockito.mock;

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

}
