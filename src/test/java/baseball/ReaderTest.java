package baseball;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ReaderTest {

    @Test
    void read() {
        //given
        final Reader reader = new Reader();
        final String input = "123";
        setIn(input);

        //when
        final String result = reader.read();
        final boolean isTrue = result.equals(input);

        //then
        assertThat(isTrue).isTrue();
    }

    @Test
    void failRead() {
        //given
        final Reader reader = new Reader();
        final String input = "123";
        setIn(input);

        //when
        final String result = reader.read();
        final boolean isTrue = "122".equals(input);

        //then
        assertThat(isTrue).isFalse();
    }

    @ParameterizedTest
    @CsvSource({"12", "1234"})
    void readException(String input) {
        //given
        final Reader reader = new Reader();
        setIn(input);

        //when
        assertThatThrownBy(() -> reader.read())
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("숫자 입력은 반드시 3자리여야합니다.");
    }

    private void setIn(String input) {
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }
}
