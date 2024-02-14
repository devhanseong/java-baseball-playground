package stringcalculator;


public class StringCalculator {

    private int result;

    int calculateString(String str) {
        String[] input = str.split(" ");
        int length = input.length;
        result = Integer.parseInt(input[0]);

        for (int  i = 1; i < length ; i += 2) {
            Operator operator = Operator.of(input[i]);
            result = operator.calculate(result, Integer.parseInt(input[i+1]));
        }

        return result;
    }

}
