package test.java;

import org.app.Calculator;
import org.junit.jupiter.api.*;
import static org.assertj.core.api.Assertions.*;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    @DisplayName("Addition")
    @Order(1)
    void add_shouldReturnSum() {
        assertThat(calculator.add(6, 6)).isEqualTo(12);
    }

    @Test
    @DisplayName("Soustraction")
    @Order(2)
    void sub_shouldReturnDifference() {
        assertThat(calculator.sub(5, 3)).isEqualTo(2)
                .isPositive();
    }

    @Test
    @DisplayName("Multiplication")
    @Order(3)
    void mul_shouldReturnProduct() {
        assertThat(calculator.mul(2, 2)).isEqualTo(4)
                .isBetween(1.0, 5.0);
    }

    @Test
    @DisplayName("Division")
    @Order(4)
    void div_shouldReturnQuotient() {
        assertThat(calculator.div(8, 2)).isEqualTo(4)
                .isNotZero();
    }

    @Test
    @DisplayName("Division par zéro")
    @Order(5)
    void div_byZero_shouldThrow() {
        assertThatThrownBy(() -> calculator.div(4, 0))
                .isInstanceOf(ArithmeticException.class)
                .hasMessageContaining("/ by zero");
    }
}
