package baseballv2;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BallTest {

    @Test
    void 숫자_위치가_같으면_스트라이크() {
        // given
        Ball ball = new Ball(0, 1);

        // when
        BallStatus status = ball.play(new Ball(0, 1));

        // then
        assertThat(status).isEqualTo(BallStatus.STRIKE);
    }

    @Test
    void 위치가_다르고_숫자만_같으면_볼() {
        // given
        Ball ball = new Ball(0, 1);

        // when
        BallStatus status = ball.play(new Ball(1, 1));

        // then
        assertThat(status).isEqualTo(BallStatus.BALL);
    }

    @Test
    void 위치_숫자_모두_다르면_낫씽() {
        // given
        Ball ball = new Ball(0, 1);

        // when
        BallStatus status = ball.play(new Ball(0, 3));

        // then
        assertThat(status).isEqualTo(BallStatus.NOTHING);
    }
}
