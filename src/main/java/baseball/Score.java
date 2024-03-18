package baseball;

public class Score {

    private int strike;
    private int ball;

    public Score() {
        this.strike = 0;
        this.ball = 0;
    }

    public void increaseStrike() {
        strike += 1;
    }

    public void increaseBall() {
        ball += 1;
    }

    public int strikes() {
        return strike;
    }

    public int balls() {
        return ball;
    }
}
