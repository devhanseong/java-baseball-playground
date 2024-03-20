package baseballv2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NumberGenerator {

    private final int NEED_SIZE = 3;
    private final int MIN_NUM = 1;
    private final int MAX_NUM = 9;

    public List<Integer> createAnswers() {
        List<Integer> answers = new ArrayList<>();
        while (answers.size() < NEED_SIZE) {
            addNumber(answers, createAnswer());
        }
        return answers;
    }

    private int createAnswer() {
        Random random = new Random();
        return random.nextInt(MAX_NUM) + MIN_NUM;
    }

    private void addNumber(List<Integer> answers, int randomNumber) {
        if(!answers.contains(randomNumber)) {
            answers.add(randomNumber);
        }
    }

}
