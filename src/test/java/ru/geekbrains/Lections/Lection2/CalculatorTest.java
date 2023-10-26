package ru.geekbrains.Lections.Lection2;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorTest {
    @Test
    void evaluatesExpression() {
        Calculator calculator = new Calculator();
        assertThat(Calculator.calculation(2, 6, '+')).isEqualTo(8);
    }

    @Test
    void subtractExpression() {
        Calculator calculator = new Calculator();
        assertThat(Calculator.calculation(2, 1, '-')).isEqualTo(1);
    }

    @Test
    void multiplicationExpression() {
        Calculator calculator = new Calculator();
        assertThat(Calculator.calculation(2, 4, '*')).isEqualTo(8);
    }

    @Test
    void divisionExpression() {
        Calculator calculator = new Calculator();
        assertThat(Calculator.calculation(8, 2, '/')).isEqualTo(4);
    }

    @Test
    void exceptedIllegalStateExceptionOnInvalidOperatorSymbol() {
        Calculator calculator = new Calculator();
        assertThatThrownBy(() ->
                Calculator.calculation(8, 4, '_')
        ).isInstanceOf(IllegalStateException.class);
    }

    @Test
    @Disabled
    void getOperandCompletesCorrectlyWithNumbers() {
        String testedValue = "9";
        ByteArrayInputStream in = new ByteArrayInputStream(testedValue.getBytes());
        InputStream inputStream = System.in;
        System.setIn(in);

        Calculator.getOperand();

        System.out.println(testedValue);
        System.setIn(inputStream);
    }

    @Test
    @Disabled
    void getOperandCompletesCorrectlyWithNotNumbers() {
        String testedValue = "k";
        ByteArrayInputStream in = new ByteArrayInputStream(testedValue.getBytes());
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        InputStream inputStream = System.in;
        System.setIn(in);
        System.setOut(new PrintStream(out));

        assertThatThrownBy(Calculator::getOperand).isInstanceOf(IllegalArgumentException.class)
                .describedAs("Ошибка в вводимых данных");

        System.setIn(inputStream);
        System.setOut(null);
    }
}