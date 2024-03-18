package baseball;

import java.util.List;

public class Validator {

    private final List<Integer> random;

    public Validator(final List<Integer> random) {
        this.random = random;
    }

    public Score validate(final String input) {
        Score score = new Score();
        for (int i = 0; i < 3; i++) {
            count(score, this.random, input, i);
        }
        printScore(score);
        return score;
    }

    private void count(Score score, List<Integer> random, String input, int index) {
        final Integer randomNumber = random.get(index);
        final Integer inputNumber = input.charAt(index) - '0';

        if (randomNumber.equals(inputNumber)) {
            score.increaseStrike();
        }

        if (!randomNumber.equals(inputNumber) && random.contains(inputNumber)) {
            score.increaseBall();
        }
    }

    private void printScore(final Score score) {
        System.out.println(score.strikes() + "스트라이크 " + score.balls() + "볼");
    }
}
