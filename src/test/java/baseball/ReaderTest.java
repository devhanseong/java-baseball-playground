package baseball;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.assertThat;

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

    private void setIn(String input) {
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }
}
