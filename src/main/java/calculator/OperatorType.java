package calculator;

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

}
