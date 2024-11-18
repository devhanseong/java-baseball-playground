package calculator;


public class Calculator {

    private final String[] expression;
    private final int initValue;

    private Calculator(final String[] expression) {
        this.expression = expression;
        this.initValue = Integer.valueOf(expression[0]);
    }

    public static Calculator from(final String[] expression) {
        return new Calculator(expression);
    }

    public int calculate() {
        int result = initValue;
        int len = expression.length;

        for (int i = 1; i < len; i += 2) {
            OperatorType operatorType = OperatorType.from(expression[i]);
            result = operatorType.operate(result, Integer.valueOf(expression[i + 1]));
        }

        return result;
    }
}
