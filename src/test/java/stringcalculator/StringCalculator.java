package stringcalculator;


public class StringCalculator {

    static int calculateString(String str) {
        String[] input = str.split(" ");
        int length = input.length;
        int result = Integer.parseInt(input[0]);

        for (int  i = 1; i < length ; i += 2) {
            result = IntCalculator.calculate(
                    result, input[i], Integer.parseInt(input[i+1])
            );
        }

        return result;
    }

}
