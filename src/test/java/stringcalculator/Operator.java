package stringcalculator;

import java.util.stream.Stream;

public enum Operator {

    PLUS("+") {
        @Override
        int calculate(int x, int y) {
            return x + y;
        }
    },
    SUBTRACT("-") {
        @Override
        int calculate(int x, int y) {
            return x - y;
        }
    },
    MULTIPLY("*") {
        @Override
        int calculate(int x, int y) {
            return x * y;
        }
    },
    DIVIDE("/") {
        @Override
        int calculate(int x, int y) {
            return x / y;
        }
    };

    private final String expression;

    Operator(String expression) {
        this.expression = expression;
    }

    boolean equalExpression(String inputExpression) {
        return this.expression.equals(inputExpression);
    }

    static Operator of(String inputExpression) {
        return Stream.of(Operator.values())
                .filter(value -> value.equalExpression(inputExpression))
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }

    abstract int calculate(int x, int y);
}
