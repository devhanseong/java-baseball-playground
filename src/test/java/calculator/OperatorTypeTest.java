package calculator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static calculator.OperatorType.*;
import static org.assertj.core.api.Assertions.assertThat;

public class OperatorTypeTest {

    private static Stream<Arguments> setUp() {
        return Stream.of(
                Arguments.of(2, ADD, 3, 5),
                Arguments.of(10, SUBTRACT, 6, 4),
                Arguments.of(6, MULTIPLY, 6, 36),
                Arguments.of(1024, DIVIDE, 2, 512)
        );
    }

    @ParameterizedTest
    @MethodSource("setUp")
    void operate(int firsNumber, OperatorType operatorType, int secondNumber, int expect) {
        //given
        //when
        int result = operatorType.operate(firsNumber, secondNumber);

        //then
        assertThat(result).isEqualTo(expect);
    }

}
