package baseball;

import java.util.Random;

public class NumberCreator {

    private final int MIN_NUMBER = 1;
    private final int MAX_NUMBER = 9;

    public String createRandomNumbers() {
        Random random = new Random();
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < 3; i++) {
            final int randomNumber = random.nextInt(MAX_NUMBER) + MIN_NUMBER;
            validateNumber(randomNumber);
            sb.append(randomNumber);
        }

        return sb.toString();
    }

    private void validateNumber(int randomNumber) {
        if (MIN_NUMBER > randomNumber || randomNumber > MAX_NUMBER) {
            throw new IllegalStateException("생성된 숫자가 제한 범위를 초과합니다.");
        }
    }
}
