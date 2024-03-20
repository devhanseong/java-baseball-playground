package baseballv2;

public class GameScore {

    private int strike;
    private int ball;

    public GameScore() {
        this.strike = 0;
        this.ball = 0;
    }

    public int strikes() {
        return strike;
    }


    public int balls() {
        return ball;
    }

    public void report(BallStatus status) {
        if (status.isStrike()) {
            strike++;
        }

        if (status.isBall()) {
            ball++;
        }
    }
}
