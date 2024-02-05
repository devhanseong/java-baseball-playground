package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    void split() {
        String actual = "1,2";
        String[] strings = actual.split(",");
        assertThat(strings.length).isEqualTo(2);
        assertThat(strings).contains("1", "2");
    }

    @DisplayName("문자열에 ()괄호가 주어진 경우 괄호 사이에 존재하는 문자열만 가지고온다.")
    @Test
    void substring() {
        String actual = "(1,2)";
        int leftIndex = actual.indexOf("(");
        int rightIndex = actual.indexOf(")");
        String substring = actual.substring(leftIndex + 1, rightIndex);
        assertThat(substring).isEqualTo("1,2");
    }

    @DisplayName("String 클래스의 charAt() 메소드를 통해 해당 인덱스의 문자를 가져온다.")
    @ParameterizedTest
    @MethodSource("provideArguments")
    void charAt(int index, char expected) {
        String actual = "abc";
        assertThat(actual.charAt(index)).isEqualTo(expected);
    }

    private static Stream<Arguments> provideArguments() {
        return Stream.of(
          Arguments.of(0, 'a'),
          Arguments.of(1, 'b'),
          Arguments.of(2, 'c')
        );
    }

    @DisplayName("주어진 문자열이 가진 인덱스의 크기보다 큰 인덱스를 찾고자 하는 경우 StringIndexOutOfBoundsException 예외가 발생한다.")
    @Test
    void failCharAt() {
        String actual = "abc";
        assertThatThrownBy(() -> {
            actual.charAt(3);
        }).isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
