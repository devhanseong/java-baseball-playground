package stringcalculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class OperatorTest {

    @ParameterizedTest
    @MethodSource("provideArguments")
    void ofTest(String expression, Operator expected) {
        //given
        //when
        Operator operator = OperatorFactory.of(expression);

        //then
        assertThat(operator).isEqualTo(expected);
    }

    private static Stream<Arguments> provideArguments() {
        return Stream.of(
                Arguments.of("+", Operator.PLUS),
                Arguments.of("-", Operator.SUBTRACT),
                Arguments.of("*", Operator.MULTIPLY),
                Arguments.of("/", Operator.DIVIDE)
        );
    }

    @Test
    void failOfTest() {
        //given
        String expression = "//";

        //when
        //then
        assertThatThrownBy(() ->
                OperatorFactory.of(expression)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @MethodSource("provideCalculateTest")
    void calculateTest(String expression, int x, int y, int expected) {
        //given
        Operator operator = OperatorFactory.of(expression);

        //when
        int result = operator.calculate(x, y);

        //then
        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> provideCalculateTest() {
        return Stream.of(
                Arguments.of("+", 2, 3, 5),
                Arguments.of("-", 4, 3, 1),
                Arguments.of("*", 6, 3, 18),
                Arguments.of("/", 4, 4, 1)
        );
    }
}
