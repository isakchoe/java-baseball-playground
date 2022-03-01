package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    void split(){
        String[] splitedArr = "1,2".split(",");
        assertThat(splitedArr).contains("1", "2");
        String[] splitedArrByOne = "1".split(",");
        assertThat(splitedArrByOne).containsExactly("1");
    }

    @Test
    void removeBrace(){
        String result = "(1,2)".substring(1,4);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("특정위치 문자 가져오기")
    void charat(){
        String testString = "testString";
        assertThat(testString.charAt(1)).isEqualTo('e');

        assertThatThrownBy(()->{
            testString.charAt(100);
        }).isInstanceOf(Exception.class)
                .hasMessageContaining("index out of range");

        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(()->{
                    testString.charAt(100);
                }).withMessageContaining("String index out of range:");
    }

}
