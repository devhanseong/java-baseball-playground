package stringcalculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringCalculatorTest {

    private StringCalculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new StringCalculator();
    }

    @Test
    void add() {
        assertThat(calculator.add(10, 30)).isEqualTo(40);
    }

    @Test
    void subtract() {
        assertThat(calculator.subtract(20, 2)).isEqualTo(18);
    }

    @Test
    void multiply() {
        assertThat(calculator.multiply(3, 8)).isEqualTo(24);
    }

    @Test
    void divide() {
        assertThat(calculator.divide(6, 3)).isEqualTo(2);
    }

    @Test
    void failDivide() {
        assertThatThrownBy(() -> {
            calculator.divide(1, 0);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void failCalculate() {
        assertThatThrownBy(() -> {
            calculator.calculate(10, "**",10);
        }).isInstanceOf(IllegalArgumentException.class);
    }

}
