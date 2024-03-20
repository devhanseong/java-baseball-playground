package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class ValidatorTest {

    @ParameterizedTest
    @MethodSource("parameters")
    void validate(List<Integer> random, String input, int strikes, int balls) {
        //given
        final Validator validator = new Validator(random);

        //then
        final Score score = validator.validate(input);

        //then
        assertThat(score.strikes()).isEqualTo(strikes);
        assertThat(score.balls()).isEqualTo(balls);
    }

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(Arrays.asList(new Integer[] {1,2,3}), "123", 3, 0),
                Arguments.of(Arrays.asList(new Integer[] {1,2,3}), "124", 2, 0),
                Arguments.of(Arrays.asList(new Integer[] {1,2,3}), "145", 1, 0),
                Arguments.of(Arrays.asList(new Integer[] {1,2,3}), "456", 0, 0),
                Arguments.of(Arrays.asList(new Integer[] {1,2,3}), "321", 1, 2),
                Arguments.of(Arrays.asList(new Integer[] {1,2,3}), "781", 0, 1),
                Arguments.of(Arrays.asList(new Integer[] {1,2,3}), "312", 0, 3)
        );
    }

}
