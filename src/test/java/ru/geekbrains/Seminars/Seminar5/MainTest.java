package ru.geekbrains.Seminars.Seminar5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.geekbrains.Seminars.Seminar5.number.MaxNumberModule;
import ru.geekbrains.Seminars.Seminar5.number.RandomNumberModule;
import ru.geekbrains.Seminars.Seminar5.order.OrderService;
import ru.geekbrains.Seminars.Seminar5.order.PaymentService;
import ru.geekbrains.Seminars.Seminar5.user.UserRepository;
import ru.geekbrains.Seminars.Seminar5.user.UserService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MainTest {
    /**
     * 5.1
     * Создайте два модуля. Первый модуль генерирует список случайных чисел. Второй модуль находит
     * максимальное число в этом списке.
     * Вам нужно сначала написать юнит-тесты для каждого модуля, затем написать интеграционный
     * тест, который проверяет, что оба модуля работают вместе правильно
     */
    List<Integer> randomList;

    @BeforeEach
    void setUp() {
        randomList = Arrays.asList(2, 5, 9, 7, 6, 1);
    }

    @Test
    void maxNumberModuleTest() {
        MaxNumberModule maxNumberModule = new MaxNumberModule();

        int maxValue = maxNumberModule.getMaxValue(randomList);

        assertThat(maxValue).isEqualTo(9);
    }

    @Test
    void randomNumberModuleTest() {
        RandomNumberModule randomNumbers = new RandomNumberModule();

        randomList = randomNumbers.getList(6);

        assertThat(randomList.size()).isEqualTo(6);
    }

    @Test
    void maxRandomTest() {
        RandomNumberModule randomNumbers = new RandomNumberModule();
        MaxNumberModule maxNumberModule = new MaxNumberModule();

        randomList = randomNumbers.getList(6);
        int maxValue = maxNumberModule.getMaxValue(randomList);

        assertThat(Collections.max(randomList)).isEqualTo(maxValue);
    }

    /**
     * 5.2
     * У вас есть два класса - UserService и UserRepository. UserService использует UserRepository для
     * получения информации о пользователе. Ваша задача - написать интеграционный тест, который
     * проверяет, что UserService и UserRepository работают вместе должным образом.
     */
    @Test
    void userServiceTest() {
        UserRepository userRepository = new UserRepository();
        UserService userService = new UserService(userRepository);

        String userName = userService.getUserName(5);

        assertThat(userName).isEqualTo("User 5");
    }

    /**
     * 5.3
     * У вас есть сервис по обработке заказов, состоящий из двух классов: OrderService и
     * PaymentService. Класс OrderService обрабатывает заказы и делает вызовы к
     * PaymentService для обработки платежей. Ваша задача - написать интеграционный тест,
     * который проверяет, что OrderService и PaymentService взаимодействуют корректно
     */

    @Test
    void orderServiceTest() {
        PaymentService paymentService = new PaymentService();
        OrderService orderService = new OrderService(paymentService);

        boolean result = orderService.placeOrder("ord_15", 15000);

        assertTrue(result);
    }


}