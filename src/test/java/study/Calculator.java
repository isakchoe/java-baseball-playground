package study;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class Calculator {

    public long plus(long a, long b) {
        return a + b;
    }

    public long minus(long a, long b) {
        return a - b;
    }

    public long multiple(long a, long b) {
        return a * b;
    }

    public long divide(long a, long b) {
        return a / b;
    }

    public class Parameter{

        private long now;
        private long next;

        Parameter(long now, long next){
            this.now = now;
            this.next = next;
        }
        public long getNow() {
            return now;
        }
        public long getNext() {
            return next;
        }
    }

    public long calculate(String operator, Parameter parameter){

        long now = parameter.getNow();
        long next = parameter.getNext();

        long result;

        if (operator.equals("+")) {
            result = plus(now, next);
            return result;
        }
        if (operator.equals("-")) {
            result = minus(now, next);
            return result;
        }
        if (operator.equals("*")) {
            result = multiple(now, next);
            return result;
        }
        if (operator.equals("/")) {
            result = divide(now, next);
            return result;
        }
        return 0;
    }

    public long calculator(String input) {
        String[] values = input.split(" ");

        long now = Long.parseLong(values[0]);
        System.out.println(now);
        for (int i = 1; i < values.length; i += 2) {
            long next = Long.parseLong(values[i+1]);
            Parameter parameter = new Parameter(now, next);
            now = calculate(values[i], parameter);
        }
        return now;
    }


        @Test
        void Calculate(){
            //  given
            //             long --> 정수!!
            String input = "8 - 4 / 2";
            // when
            long output = calculator(input);
            //  then
            assertThat(output).isEqualTo(2);
        }

    }

