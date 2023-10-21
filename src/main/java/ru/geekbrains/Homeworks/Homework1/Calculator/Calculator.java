package ru.geekbrains.Homeworks.Homework1.Calculator;

public class Calculator {
    public static int calculation(int firstOperand, int secondOperand, char operator) {
        int result;
        switch (operator) {
            case '+' -> result = firstOperand + secondOperand;
            case '-' -> result = firstOperand - secondOperand;
            case '*' -> result = firstOperand * secondOperand;
            case '/' -> {
                if (secondOperand != 0) {
                    result = firstOperand / secondOperand;
                } else {
                    throw new ArithmeticException("Division by zero is not possible");
                }
            }
            default -> throw new IllegalStateException("Unexpected value operator: " + operator);
        }
        return result;
    }

    // HW1.1: Придумайте и опишите (можно в псевдокоде) функцию извлечения корня и
    // необходимые проверки для него используя граничные случаи
    public static double squareRootExtraction(double num) {
        //  0
        //  Отрицательные числа
        //  Дробные значения корней
        //  Целые
        if (num < 0) {
            throw new IllegalArgumentException("Cannot calculate square root of a negative number");
        }
        return Math.sqrt(num);
    }

    /**
     * Нужно написать в калькуляторе метод вычисления суммы покупки со скидкой и проверить его, используя AssertJ
     * Примерная сигнатура и тело метода:
     *
     * @param purchaseAmount - сумма покупки
     * @param discountAmount - размер скидки
     * @return - Метод должен возвращать сумму покупки со скидкой
     */
    public static double calculatingDiscount(double purchaseAmount, int discountAmount) {
        double result;
        if (purchaseAmount < 0 || discountAmount < 0) {
            throw new ArithmeticException("На вход были поданы отрицательные аргументы");
        } else {
            result = purchaseAmount - purchaseAmount / 100 * discountAmount;
        }
        return result;
    }
}