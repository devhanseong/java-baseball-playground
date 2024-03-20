package baseball;

import java.util.List;

public class Validator {

    private final List<Integer> random;

    public Validator(final List<Integer> random) {
        this.random = random;
    }

    public Score validate(final String input) {
        Score score = new Score();
        for (int i = 0; i < random.size(); i++) {
            count(score, this.random, input, i);
        }
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
}
