package org.app;

import org.junit.jupiter.api.*;
import static org.assertj.core.api.Assertions.*;

class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    @DisplayName("Addition")
    void add_shouldReturnSum() {
        assertThat(calculator.add(1, 3)).isEqualTo(4);
    }

    @Test
    @DisplayName("Soustraction")
    void sub_shouldReturnDifference() {
        assertThat(calculator.sub(5, 3)).isEqualTo(2)
                .isPositive();
    }

    @Test
    @DisplayName("Multiplication")
    void mul_shouldReturnProduct() {
        assertThat(calculator.mul(7, 6)).isEqualTo(42)
                .isBetween(40, 50);
    }

    @Test
    @DisplayName("Division")
    void div_shouldReturnQuotient() {
        assertThat(calculator.div(8, 2)).isEqualTo(4)
                .isNotZero();
    }

    @Test
    @DisplayName("Division par zéro — lève ArithmeticException")
    void div_byZero_shouldThrow() {
        assertThatThrownBy(() -> calculator.div(1, 0))
                .isInstanceOf(ArithmeticException.class)
                .hasMessageContaining("/ by zero");
    }
}
