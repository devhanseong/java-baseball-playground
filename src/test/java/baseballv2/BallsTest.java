package baseballv2;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class BallsTest {

    @Test
    void play_3strike() {
        // given
        Balls balls = new Balls(Arrays.asList(1, 2, 3));

        // when
        GameScore score = balls.play(Arrays.asList(1, 2, 3));

        // then
        assertThat(score.strikes()).isEqualTo(3);
        assertThat(score.balls()).isEqualTo(0);
    }

    @Test
    void play_2strike_0ball() {
        // given
        Balls balls = new Balls(Arrays.asList(1, 2, 3));

        // when
        GameScore score = balls.play(Arrays.asList(1, 4, 3));

        // then
        assertThat(score.strikes()).isEqualTo(2);
        assertThat(score.balls()).isEqualTo(0);
    }

    @Test
    void play_1strike_2ball() {
        // given
        Balls balls = new Balls(Arrays.asList(1, 2, 3));

        // when
        GameScore score = balls.play(Arrays.asList(1, 3, 2));

        // then
        assertThat(score.strikes()).isEqualTo(1);
        assertThat(score.balls()).isEqualTo(2);
    }

    @Test
    void play_0strike_3ball() {
        // given
        Balls balls = new Balls(Arrays.asList(1, 2, 3));

        // when
        GameScore score = balls.play(Arrays.asList(3, 1, 2));

        // then
        assertThat(score.strikes()).isEqualTo(0);
        assertThat(score.balls()).isEqualTo(3);
    }

    @Test
    void play_nothing() {
        // given
        Balls balls = new Balls(Arrays.asList(1, 2, 3));

        // when
        GameScore score = balls.play(Arrays.asList(4, 5, 6));

        // then
        assertThat(score.strikes()).isEqualTo(0);
        assertThat(score.balls()).isEqualTo(0);
    }
}
