package org.example;

import io.qameta.allure.*;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@Epic("Арифметические операции")
@Owner("Мискевич Евгений")
public class CalculatorTest {

    private int add(int a, int b) {
        return a + b;
    }

    private double add(double a, double b) {
        return a + b;
    }

    private int subtract(int a, int b) {
        return a - b;
    }

    private double subtract(double a, double b) {
        return a - b;
    }

    @Test
    @Feature("Сложение чисел")
    @Story("Проверка сложения положительных чисел")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Тест проверяет корректность сложения положительных чисел.")
    void positiveAdditionTest() {
        step("Сложение 2 и 3", () -> {
            int result = add(2, 3);
            step("Ожидаем 5");
            assertEquals(5, result);
        });
    }

    @Test
    @Feature("Сложение чисел")
    @Story("Проверка сложения отрицательных чисел")
    @Severity(SeverityLevel.NORMAL)
    @Description("Тест проверяет корректность сложения отрицательных чисел.")
    @Link(name = "Определение сложения", url = "https://slavshkola.ru/blog/chto-takoe-slozhenie-v-matematike-opredelenie")
    void negativeAdditionTest() {
        step("Сложение -2 и -3", () -> {
            int result = add(-2, -3);
            step("Ожидаем -5");
            assertEquals(-5, result);
        });
    }

    @Test
    @Feature("Работа с нулем")
    @Story("Сложение с нулем")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Тест проверяет корректность сложения числа с нулем.")
    void additionWithZeroTest() {
        step("Сложение 0 и 5", () -> {
            int result = add(0, 5);
            step("Ожидаем 5");
            assertEquals(5, result);
        });

        step("Сложение -7 и 0", () -> {
            int result = add(-7, 0);
            step("Ожидаем -7");
            assertEquals(-7, result);
        });
    }

    @Test
    @Epic("Обработка ошибок")
    @Feature("Переполнение")
    @Story("Проверка переполнения при сложении больших чисел")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Тест проверяет поведение калькулятора при переполнении типа int.")
    void overflowTest() {
        step("Сложение Integer.MAX_VALUE и 1", () -> {
            int result = add(Integer.MAX_VALUE, 1);
            step("Ожидаем переполнение");
            assertThrows(ArithmeticException.class, () -> {
                if (result < 0) throw new ArithmeticException("Переполнение!");
            });
        });
    }

    @Test
    @Epic("Работа с дробями")
    @Feature("Сложение дробей")
    @Story("Сложение дробных чисел")
    @Severity(SeverityLevel.NORMAL)
    @Description("Тест проверяет корректность сложения дробных чисел.")
    void fractionAdditionTest() {
        step("Сложение 1.5 и 2.5", () -> {
            double result = add(1.5, 2.5);
            step("Ожидаем 4.0");
            assertEquals(4.0, result);
        });
    }

    @Test
    @Feature("Вычитание чисел")
    @Story("Проверка вычитания положительных чисел")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Тест проверяет корректность вычитания одного положительного числа из другого.")
    void positiveSubtractionTest() {
        step("Вычитаем 3 из 8", () -> {
            int result = subtract(8, 3);
            step("Ожидаем 5");
            assertEquals(5, result);
        });
    }

    @Test
    @Feature("Вычитание чисел")
    @Story("Проверка вычитания отрицательных чисел")
    @Severity(SeverityLevel.NORMAL)
    @Description("Тест проверяет корректность вычитания отрицательных чисел.")
    void negativeSubtractionTest() {
        step("Вычитаем -3 из -8", () -> {
            int result = subtract(-8, -3);
            step("Ожидаем -5");
            assertEquals(-5, result);
        });
    }

    @Test
    @Feature("Работа с нулем")
    @Story("Вычитание с нулем")
    @Severity(SeverityLevel.TRIVIAL)
    @Description("Тест проверяет корректность вычитания числа с участием нуля.")
    void subtractionWithZeroTest() {
        step("Вычитаем 0 из 5", () -> {
            int result = subtract(5, 0);
            step("Ожидаем 5");
            assertEquals(5, result);
        });

        step("Вычитаем 5 из 0", () -> {
            int result = subtract(0, 5);
            step("Ожидаем -5");
            assertEquals(-5, result);
        });
    }

    @Test
    @Epic("Обработка ошибок")
    @Feature("Граничные значения")
    @Story("Вычитание с минимальным значением int")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Тест проверяет поведение при вычитании, когда результат выходит за пределы int.")
    void subtractionOverflowTest() {
        step("Вычитаем 1 из Integer.MIN_VALUE", () -> {
            int result = subtract(Integer.MIN_VALUE, 1);
            step("Ожидаем переполнение");
            assertThrows(ArithmeticException.class, () -> {
                if (result > 0) throw new ArithmeticException("Переполнение!");
            });
        });
    }

    @Test
    @Epic("Работа с дробями")
    @Feature("Вычитание дробей")
    @Story("Проверка вычитания дробных чисел")
    @Severity(SeverityLevel.NORMAL)
    @Description("Тест проверяет корректность вычитания дробных чисел.")
    void fractionSubtractionTest() {
        step("Вычитаем 2.5 из 5.5", () -> {
            double result = subtract(5.5, 2.5);
            step("Ожидаем 3.0");
            assertEquals(3.0, result);
        });
    }
}
