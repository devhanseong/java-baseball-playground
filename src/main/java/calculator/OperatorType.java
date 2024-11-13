package calculator;

import java.util.Arrays;

public enum OperatorType {
    ADD("더하기", "+", (a, b) -> a + b),
    SUBTRACT("빼기", "-", (a, b) -> a - b),
    MULTIPLY("곱하기", "*", (a, b) -> a * b),
    DIVIDE("나누기", "/", (a, b) -> a / b);

    private final String text;
    private final String operation;
    private final Calculable calculable;

    OperatorType(final String text, final String operation, final Calculable calculable) {
        this.text = text;
        this.operation = operation;
        this.calculable = calculable;
    }

    public int operate(final int a, final int b) {
        return calculable.apply(a, b);
    }

    public static OperatorType from(String userOperation) {
        return Arrays.stream(values())
                .filter(each -> each.operation.equals(userOperation))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("지원하지 않는 연산자입니다."));
    }

}
