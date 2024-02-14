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

    StringCalculator stringCalculator;

    @BeforeEach
    void setUp() {
        stringCalculator = new StringCalculator();
    }

    @ParameterizedTest
    @MethodSource("provideArguments")
    void calculate(String str, int expected) {
        //given
        //when
        int result = stringCalculator.calculateString(str);

        //then
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("provideFailArguments")
    void failCalculate(String str) {
        //given
        //when
        //then
        assertThatThrownBy(() ->
                stringCalculator.calculateString(str)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void numberFormatException() {
        //given
        //when
        //then
        assertThatThrownBy(() ->
                stringCalculator.calculateString("+ + 3 * 4 / 2")
        ).isInstanceOf(NumberFormatException.class);
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

    private static Stream<Arguments> provideFailArguments() {
        return Stream.of(
                Arguments.of("2 + 3 ** 4 / 2"),
                Arguments.of("10 ++ 6 * 2 / 1 * 10 / 1 - 1"),
                Arguments.of("5 * 2 - 10 // 2")
        );
    }

}
