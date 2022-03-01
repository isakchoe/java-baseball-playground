package study;

import org.assertj.core.internal.Numbers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

// assertThat 를 위한 assertj
import static org.assertj.core.api.Assertions.*;



import java.util.HashSet;
import java.util.Set;

public class SetTest {
    private Set<Integer> numbers;


    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    // Test Case 구현
    @Test
    @DisplayName("set 사이즈")
    void getSize(){
        int setSize = numbers.size();
        assertThat(setSize).isEqualTo(3);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void isNumInSet(int input) {
        assertThat(numbers.contains(input)).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = { "1:true" , "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void toLowerCase_ShouldGenerateTheExpectedLowercaseValue(int input, Boolean expected) {
        boolean result = numbers.contains(input);
        assertThat(result).isEqualTo(expected);
    }




}
