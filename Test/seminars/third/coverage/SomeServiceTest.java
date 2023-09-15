package seminars.third.coverage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class SomeServiceTest {
    private SomeService someService;

    @BeforeEach
    void setUp() {
        someService = new SomeService();
    }


    @Test
    void testReturnFizz() {
        assertThat(someService.fizzBuzz(3)).isEqualTo("Fizz");
    }

    @Test
    void testReturnBuzz() {
        assertThat(someService.fizzBuzz(5)).isEqualTo("Buzz");
    }

    @Test
    void testReturnFizzBuzz() {
        assertThat(someService.fizzBuzz(15)).isEqualTo("FizzBuzz");
    }

    @Test
    void testReturnEcho() {
        assertThat(someService.fizzBuzz(14)).isEqualTo("" + 14);
    }


    @Test
    void testFirstSixElement() {
        assertTrue(someService.firstLast6(new int[]{6, 1, 2, 3}));
    }

    @Test
    void testLastSixElement() {
        assertTrue(someService.firstLast6(new int[]{1, 2, 3, 6}));
    }

    @Test
    void testFirstLastNoSixElement() {
        assertFalse(someService.firstLast6(new int[]{1, 2, 3}));
    }


    /**
     * HW 3_1 <br>
     * Разбить большой метод под номером 3 и проверить покрытие(должно быть 100%)
     */

    @Test
    void testCorrectCalculationDiscount() {
        assertThat(someService.calculatingDiscount(100.0, 10)).isEqualTo(90.0);
    }

    @Test
    void testCorrectCalculationZeroDiscount() {
        assertThat(someService.calculatingDiscount(100.0, 0)).isEqualTo(100.0);
    }

    @Test
    void testCorrectCalculationFreeSale() {
        assertThat(someService.calculatingDiscount(100.0, 100)).isEqualTo(0);
    }

    @ParameterizedTest
    @ValueSource(ints = {101, -1})
    void testIsValidDiscountAmount(int i) {
        ArithmeticException exception = assertThrows(ArithmeticException.class, () ->
                someService.calculatingDiscount(100, i));
        String expectedMessage = "Скидка должна быть в диапазоне от 0 до 100%";
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void testIsValidPurchaseAmount() {
        ArithmeticException exception = assertThrows(ArithmeticException.class, () ->
                someService.calculatingDiscount(-1.0, 0));
        String expectedMessage = "Сумма покупки не может быть отрицательной";
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }


    @Test
    void testLuckySumA() {
        assertThat(someService.luckySum(13, 2, 5)).isEqualTo(2 + 5);
    }

    @Test
    void testLuckySumB() {
        assertThat(someService.luckySum(2, 13, 5)).isEqualTo(2 + 5);
    }

    @Test
    void testLuckySumC() {
        assertThat(someService.luckySum(5, 2, 13)).isEqualTo(2 + 5);
    }

    @Test
    void testLuckySumNot13() {
        assertThat(someService.luckySum(1, 2, 5)).isEqualTo(1 + 2 + 5);
    }


    /**
     * HW 3_2 <br>
     * Нужно покрыть тестами метод на 100%.
     * Метод проверяет, является ли целое число записанное в переменную n, чётным (true) либо нечётным (false)
     */

    @Test
    void testIsEven() {
        assertTrue(someService.evenOddNumber(2));
    }

    @Test
    void testIsOdd() {
        assertFalse(someService.evenOddNumber(1));
    }

}