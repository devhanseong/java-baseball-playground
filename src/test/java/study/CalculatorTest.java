package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {
    Calculator cal;

    @BeforeEach
    public void setUp() {
        cal = new Calculator();
    }

    @Test
    public void add() {
        int res = cal.add(3, 3);
        assertThat(res).isEqualTo(6);
    }

    @Test
    public void subtract() {
        int res = cal.subtract(3, 3);
        assertThat(res).isEqualTo(0);
    }

    @Test
    public void multiply() {
        int res = cal.multiply(3, 3);
        assertThat(res).isEqualTo(9);
    }

    @Test
    public void divide() {
        int res = cal.divide(3, 3);
        assertThat(res).isEqualTo(1);
    }
}
