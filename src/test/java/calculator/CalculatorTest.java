package calculator;

import calculator.util.StringParser;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    private static Stream<Arguments> setUp() {
        return Stream.of(
                Arguments.of("2 + 3 * 4 / 2", 10),
                Arguments.of("10 + 6 * 2 / 1 * 10 / 1 - 1", 319),
                Arguments.of("5 * 2 - 10 / 2", 0),
                Arguments.of("10 / 2 + 5 * 3", 30),
                Arguments.of("8 - 2 * 3 + 10 / 2", 14),
                Arguments.of("3 * 4 + 2 - 8 / 2", 3)
        );
    }

    @ParameterizedTest
    @MethodSource("setUp")
    void calculate(String input, int expect) {
        // given
        String[] expression = StringParser.split(input, " ");
        Calculator calculator = Calculator.from(expression);

        // when
        int result = calculator.calculate();

        // then
        assertThat(result).isEqualTo(expect);
    }
}
