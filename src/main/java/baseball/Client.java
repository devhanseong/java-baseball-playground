package baseball;

import java.util.List;

public class Client {

    private static final int SUCCESS_COUNT = 3;

    public static void main(String[] args) {
        final List<Integer> randomNumbers = new NumberCreator().createRandomNumbers();
        final Validator validator = new Validator(randomNumbers);

        Score score = new Score();
        while (score.strikes() != SUCCESS_COUNT) {
            final String input = new Reader().read();
            score = validator.validate(input);
        }
        System.out.println("3 스트라이크 게임을 종료합니다.");
    }

}
