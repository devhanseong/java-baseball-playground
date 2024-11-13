package calculator;

import calculator.io.InputHandler;
import calculator.io.OutputHandler;

public class CalculatorMain {

    private static final InputHandler inputHandler = new InputHandler();
    private static final OutputHandler outputHandler = new OutputHandler();

    public static void main(String[] args) {
        String userInput = inputHandler.getUserInput();
        outputHandler.print(userInput);
    }

}
