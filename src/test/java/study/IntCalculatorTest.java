package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class IntCalculatorTest {

    @Test
    void add() {
        //given
        int leftValue = 10;
        int rightValue = 30;

        //when
        int result = IntCalculator.add(leftValue, rightValue);

        //then
        assertThat(result).isEqualTo(40);
    }

    @Test
    void subtract() {
        //given
        int leftValue = 20;
        int rightValue = 2;

        //when
        int result = IntCalculator.subtract(leftValue, rightValue);

        //then
        assertThat(result).isEqualTo(18);
    }

    @Test
    void multiply() {
        //given
        int leftValue = 3;
        int rightValue = 8;

        //when
        int result = IntCalculator.multiply(leftValue, rightValue);

        //then
        assertThat(result).isEqualTo(24);
    }

    @Test
    void divide() {
        //given
        int leftValue = 6;
        int rightValue = 3;

        //when
        int result = IntCalculator.divide(leftValue, rightValue);

        //then
        assertThat(result).isEqualTo(2);
    }

    @Test
    void failDivide() {
        //given
        int leftValue = 1;
        int rightValue = 0;

        //when
        //then
        assertThatThrownBy(() -> {
            IntCalculator.divide(leftValue, rightValue);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void failCalculate() {
        //given
        int leftValue = 10;
        String operator = "**";
        int rightValue = 2;

        //when
        //then
        assertThatThrownBy(() -> {
            IntCalculator.calculate(leftValue, operator, rightValue);
        }).isInstanceOf(IllegalArgumentException.class);
    }

}
