package baseball;

public class Client {

    public static void main(String[] args) {
        final String randomNumbers = new NumberCreator().createRandomNumbers();
        final String input = new Reader().read();
        final boolean isTure = new Validator(randomNumbers, input).validate();

        System.out.println(randomNumbers);
        System.out.println(input);
        System.out.println(isTure);
    }
}
