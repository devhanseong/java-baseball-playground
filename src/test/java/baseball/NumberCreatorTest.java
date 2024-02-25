package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NumberCreatorTest {

    @DisplayName("랜덤 숫자 3개를 생성한다.")
    @Test
    void createRandomNumbers() {
        //given
        final NumberCreator numberCreator = new NumberCreator();

        //when
        final String randomNumbers = numberCreator.createRandomNumbers();

        //then
        assertThat(randomNumbers).hasSize(3);
    }
}
