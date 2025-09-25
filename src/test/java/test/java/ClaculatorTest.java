package test.java;

import org.app.Calculator;
import org.junit.jupiter.api.*;
import static org.assertj.core.api.Assertions.*;

class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void init() {
        calculator = new Calculator();
    }

    @Test
    @DisplayName("Addition volontairement faux")
    void add_shouldFail() {
        assertThat(calculator.add(6, 6)).isEqualTo(13);
    }

    @Test
    @DisplayName("Soustraction volontairement faux")
    void sub_shouldFail() {
        assertThat(calculator.sub(5, 3)).isEqualTo(3);
    }

    @Test
    @DisplayName("Multiplication volontairement faux")
    void mul_shouldFail() {
        assertThat(calculator.mul(8, 8))
                .isEqualTo(54)
                .isBetween(45, 55);
    }

    @Test
    @DisplayName("Division volontairement faux")
    void div_shouldFail() {
        assertThat(calculator.div(8, 2));
    }
}