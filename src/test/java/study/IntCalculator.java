package study;

public class IntCalculator {

    static int add(final int leftValue, final int rightValue) {
        return leftValue + rightValue;
    }

    static int subtract(final int leftValue, final int rightValue) {
        return leftValue - rightValue;
    }

    static int multiply(final int leftValue, final int rightValue) {
        return leftValue * rightValue;
    }

    static int divide(final int leftValue, final int rightValue) {
        if (rightValue == 0) {
            throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
        }
        return leftValue / rightValue;
    }

    static int calculate(final int leftValue, final String operator, final int rightValue) {
        if (operator.equals("+")) {
            return add(leftValue, rightValue);
        }
        if (operator.equals("-")) {
            return subtract(leftValue, rightValue);
        }
        if (operator.equals("*")) {
            return multiply(leftValue, rightValue);
        }
        if (operator.equals("/")) {
            return divide(leftValue, rightValue);
        }
        throw new IllegalArgumentException("지원하지 않는 연산자입니다.");
    }

}
