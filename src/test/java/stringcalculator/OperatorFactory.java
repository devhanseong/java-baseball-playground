package stringcalculator;

import java.util.stream.Stream;

public class OperatorFactory {

    static Operator of(String inputExpression) {
        return Stream.of(Operator.values())
                .filter(value -> value.equalExpression(inputExpression))
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }

}
