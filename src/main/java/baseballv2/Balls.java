package baseballv2;

import java.util.ArrayList;
import java.util.List;

public class Balls {

    private final List<Ball> answers;

    public Balls(List<Integer> numbers) {
        this.answers = mapToBall(numbers);
    }

    public GameScore play(List<Integer> userNumbers) {
        Balls userBalls = new Balls(userNumbers);
        GameScore score = new GameScore();
        for (Ball answer : answers) {
            BallStatus status = userBalls.play(answer);
            score.report(status);
        }
        return score;
    }

    private BallStatus play(Ball userBall) {
        return answers.stream()
                .map(answer -> answer.play(userBall))
                .filter(BallStatus::isNotNothing)
                .findFirst()
                .orElse(BallStatus.NOTHING);
    }

    private List<Ball> mapToBall(List<Integer> numbers) {
        List<Ball> balls = new ArrayList<>();
        for (int index = 0; index < numbers.size() ; index++) {
            balls.add(new Ball(index, numbers.get(index)));
        }
        return balls;
    }

}
