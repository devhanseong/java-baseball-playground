package calculator.util;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringParserTest {

    @Test
    void split() {
        //given
        String input = "2 + 3 * 4 / 2";
        String delimiter = " ";

        //when
        String[] result = StringParser.split(input, delimiter);

        //then
        assertThat(result).hasSize(7)
                .containsExactly("2", "+", "3", "*", "4", "/", "2");
    }

}
