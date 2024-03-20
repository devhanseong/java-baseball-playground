package stringcalculator;


public class StringCalculator {

    private final String SEPERATOR = " ";
    private String[] formula;
    private int result;

    public StringCalculator (String input) {
        this.formula = input.split(SEPERATOR);
        this.result = Integer.parseInt(formula[0]);
    }

    int calculateString() {
        int length = formula.length;

        for (int  i = 1; i < length ; i += 2) {
            Operator operator = OperatorFactory.from(formula[i]);
            result = operator.calculate(result, Integer.parseInt(formula[i+1]));
        }

        return result;
    }

}
