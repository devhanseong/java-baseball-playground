package calculator;

import calculator.io.InputHandler;
import calculator.io.OutputHandler;
import calculator.util.StringParser;

public class CalculatorMain {

    private static final InputHandler inputHandler = new InputHandler();
    private static final OutputHandler outputHandler = new OutputHandler();

    public static void main(String[] args) {
        String userInput = inputHandler.getUserInput();
        String[] expression = StringParser.split(userInput, " ");
        Calculator calculator = Calculator.from(expression);
        int result = calculator.calculate();
        outputHandler.print(result);
    }

}
