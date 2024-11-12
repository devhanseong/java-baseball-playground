package study;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class StringTest {

    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    void split() {
        //given
        String input = "1,2";

        //when
        String[] items = input.split(",");

        //then
        assertThat(items).hasSize(2)
                .containsExactly("1", "2");
    }

    @Test
    void split2() {
        //given
        String input = "1";

        //when
        String[] items = input.split(",");

        //then
        assertThat(items).hasSize(1)
                .containsExactly("1");
    }

    @Test
    void subString() {
        //given
        String input = "(1,2)";
        int firstIndex = input.indexOf("(") + 1;
        int lastIndex = input.indexOf(")");

        //when
        String expect = input.substring(firstIndex, lastIndex);

        //then
        assertThat(expect).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt()을 활용하여 특정 위치의 문자를 가져온다.")
    void charAt() {
        //given
        String input = "abc";

        //when
        char expect = input.charAt(0);

        //then
        assertThat('a').isEqualTo(expect);
    }

    @Test
    @DisplayName("charAt()을 사용할 때 위치값을 벗어나면 예외가 발생한다.")
    void charAtException() {
        //given
        String input = "abc";

        //when
        //then
        assertThatThrownBy(() -> input.charAt(input.length()))
                .isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
