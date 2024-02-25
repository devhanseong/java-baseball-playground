package baseball;

public class Validator {

    private final String random;
    private final String input;

    public Validator(final String random, final String input) {
        this.random = random;
        this.input = input;
    }

    public boolean validate() {
        return random.equals(input);
    }
}
