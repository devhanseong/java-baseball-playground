package calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static calculator.OperatorType.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class OperatorTypeTest {

    private static Stream<Arguments> operateArguments() {
        return Stream.of(
                Arguments.of(2, ADD, 3, 5),
                Arguments.of(10, SUBTRACT, 6, 4),
                Arguments.of(6, MULTIPLY, 6, 36),
                Arguments.of(1024, DIVIDE, 2, 512)
        );
    }

    private static Stream<Arguments> fromArguments() {
        return Stream.of(
                Arguments.of("+", ADD),
                Arguments.of("-", SUBTRACT),
                Arguments.of("*", MULTIPLY),
                Arguments.of("/", DIVIDE)
        );
    }

    @ParameterizedTest
    @MethodSource("operateArguments")
    void operate(int firsNumber, OperatorType operatorType, int secondNumber, int expect) {
        //given
        //when
        int result = operatorType.operate(firsNumber, secondNumber);

        //then
        assertThat(result).isEqualTo(expect);
    }

    @ParameterizedTest
    @MethodSource("fromArguments")
    void from(String operation, OperatorType type) {
        //given
        //when
        OperatorType result = OperatorType.from(operation);

        //then
        assertThat(result).isEqualTo(type);
    }

    @Test
    void unsupportedOperation() {
        //given
        String operation = "%";

        //when
        //then
        assertThatThrownBy(() -> OperatorType.from(operation))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("지원하지 않는 연산자입니다.");

    }
}
