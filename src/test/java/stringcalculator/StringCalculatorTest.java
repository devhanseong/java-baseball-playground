package stringcalculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

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
        //given
        int leftValue = 10;
        int rightValue = 30;

        //when
        int result = calculator.add(leftValue, rightValue);

        //then
        assertThat(result).isEqualTo(40);
    }

    @Test
    void subtract() {
        //given
        int leftValue = 20;
        int rightValue = 2;

        //when
        int result = calculator.subtract(leftValue, rightValue);

        //then
        assertThat(result).isEqualTo(18);
    }

    @Test
    void multiply() {
        //given
        int leftValue = 3;
        int rightValue = 8;

        //when
        int result = calculator.multiply(leftValue, rightValue);

        //then
        assertThat(result).isEqualTo(24);
    }

    @Test
    void divide() {
        //given
        int leftValue = 6;
        int rightValue = 3;

        //when
        int result = calculator.divide(leftValue, rightValue);

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
            calculator.divide(leftValue, rightValue);
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
            calculator.calculate(leftValue, operator,rightValue);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @MethodSource("provideArguments")
    void calculate(String str, int expected) {
        //given
        String[] input = str.split(" ");
        int length = input.length;
        int result = Integer.parseInt(input[0]);

        //when
        for (int  i = 1; i < length ; i += 2) {
            result = calculator.calculate(
                    result, input[i], Integer.parseInt(input[i+1])
            );
        }

        //then
        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> provideArguments() {
        return Stream.of(
          Arguments.of("2 + 3 * 4 / 2", 10),
          Arguments.of("10 + 6 * 2 / 1 * 10 / 1 - 1", 319),
          Arguments.of("5 * 2 - 10 / 2", 0),
          Arguments.of("10 / 2 + 5 * 3", 30),
          Arguments.of("8 - 2 * 3 + 10 / 2", 14),
          Arguments.of("3 * 4 + 2 - 8 / 2", 3)
        );
    }

}
