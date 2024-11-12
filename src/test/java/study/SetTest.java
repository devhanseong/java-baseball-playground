package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class SetTest {

    private Set<Integer> numbers;

    @BeforeEach
    public void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @DisplayName("Set은 중복을 허용하지 않는다.")
    @Test
    void size() {
        //given
        int expect = 3;

        //when
        int size = numbers.size();

        //then
        assertThat(size).isEqualTo(expect);
    }

    @DisplayName("Set에 1이 저장되어있는지 확인한다.")
    @Test
    void IsOneContains() {
        //given
        int target = 1;

        //when
        boolean isContains = numbers.contains(target);

        //then
        assertThat(isContains).isTrue();
    }

    @DisplayName("Set에 2이 저장되어있는지 확인한다.")
    @Test
    void IsTwoContains() {
        //given
        int target = 2;

        //when
        boolean isContains = numbers.contains(target);

        //then
        assertThat(isContains).isTrue();
    }

    @DisplayName("Set에 3이 저장되어있는지 확인한다.")
    @Test
    void IsThreeContains() {
        //given
        int target = 3;

        //when
        boolean isContains = numbers.contains(target);

        //then
        assertThat(isContains).isTrue();
    }

    @DisplayName("contains() 메서드 중복을 제거해보자")
    @ParameterizedTest
    @CsvSource({"1,true", "2,true", "3,true", "4,false", "5,false"})
    void containsParameterizedTest(int target, boolean expect) {
        //given
        //when
        boolean isContains = numbers.contains(target);

        //then
        assertThat(isContains).isEqualTo(expect);
    }
}
