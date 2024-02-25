package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ValidatorTest {

    @Test
    void validate() {
        //given
        String random = "123";
        String input = "123";
        final Validator validator = new Validator(random, input);

        //then
        final boolean isTrue = validator.validate();

        //then
        assertThat(isTrue).isTrue();
    }

    @Test
    void failValidate() {
        //given
        String random = "123";
        String input = "234";
        final Validator validator = new Validator(random, input);

        //then
        final boolean isTrue = validator.validate();

        //then
        assertThat(isTrue).isFalse();
    }
}
