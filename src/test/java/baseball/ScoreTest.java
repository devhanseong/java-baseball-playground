package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ScoreTest {

    private Score score;

    @DisplayName("increaseStrike 메서드 호출 시 스트라이크 갯수가 1씩 증가한다.")
    @Test
    void increaseStrike() {
        //given
        score = new Score();

        //when
        score.increaseStrike();

        //then
        assertThat(score.strikes()).isEqualTo(1);
    }

    @DisplayName("increaseBall 메서드 호출 시 볼 갯수가 1씩 증가한다.")
    @Test
    void increaseBall() {
        //given
        score = new Score();

        //when
        score.increaseBall();

        //then
        assertThat(score.balls()).isEqualTo(1);
    }
}
