package baseballv2;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class NumberGeneratorTest {

    @Test
    void 난수_생성시_3개의_숫자여야_한다() {
        // given
        NumberGenerator generator = new NumberGenerator();

        // when
        List<Integer> answers = generator.createAnswers();

        // then
        assertThat(answers).hasSize(3);
    }

    @Test
    void 서로_다른_숫자_3개여야한다() {
        NumberGenerator generator = new NumberGenerator();

        // when
        List<Integer> answers = generator.createAnswers();

        // then
        assertThat(answers.get(0)).isNotEqualTo(answers.get(1));
        assertThat(answers.get(0)).isNotEqualTo(answers.get(2));
        assertThat(answers.get(1)).isNotEqualTo(answers.get(2));
    }
    
}
