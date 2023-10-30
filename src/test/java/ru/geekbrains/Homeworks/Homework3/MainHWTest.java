package ru.geekbrains.Homeworks.Homework3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import ru.geekbrains.Homeworks.Homework3.hw.MainHW;


import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainHWTest {

    MainHW mainHW;

    @BeforeEach
    void setUp() {
        mainHW = new MainHW();
    }

    @ParameterizedTest
    @ValueSource(ints = {-4, 0, 2})
    void evenOddNumberPositiveTest(int input) {
        assertTrue(mainHW.evenOddNumber(input));
    }

    @ParameterizedTest
    @ValueSource(ints = {-5, 1, 3})
    void evenOddNumberNegativeTest(int input) {
        assertFalse(mainHW.evenOddNumber(input));
    }

    @ParameterizedTest
    @ValueSource(ints = {26, 50, 99})
    void numberInIntervalTest(int input) {
        assertTrue(mainHW.numberInInterval(input));
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 5, 25, 100, 150})
    void numberNotInIntervalTest(int input) {
        assertFalse(mainHW.numberInInterval(input));
    }

}
