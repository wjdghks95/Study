package chap17;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Sample14 {
    public static void main(String[] args) {
        int sum1 = 0;
        int sum2 = 0;

        for (int i = 6; i <= 10; i++) {
            sum1 += i;
        }
        System.out.println("for문 결과: " + sum1);

        sum2 = IntStream.rangeClosed(7, 10)
                .reduce(6, Integer::sum);
        System.out.println("reduce문 결과: " + sum2);
    }
}
