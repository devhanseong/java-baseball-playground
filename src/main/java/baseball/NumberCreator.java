package baseball;

import java.util.*;

public class NumberCreator {

    private final int MIN_NUMBER = 1;
    private final int MAX_NUMBER = 9;
    private final int NEED_SIZE = 3;

    public List<Integer> createRandomNumbers() {
        Random random = new Random();
        final List<Integer> numbers = new ArrayList<>();

        while (numbers.size() != NEED_SIZE) {
            final int randomNumber = random.nextInt(MAX_NUMBER) + MIN_NUMBER;
            validateNumber(randomNumber);
            addRandomNumber(numbers, randomNumber);
        }
        return numbers;
    }

    private void validateNumber(int randomNumber) {
        if (MIN_NUMBER > randomNumber || randomNumber > MAX_NUMBER) {
            throw new IllegalStateException("생성된 숫자가 제한 범위를 초과합니다.");
        }
    }

    private void addRandomNumber(final List<Integer> numbers, final int randomNumber) {
        if (!numbers.contains(randomNumber)) {
            numbers.add(randomNumber);
        }
    }
}
