package chap17;

import java.util.OptionalInt;
import java.util.stream.IntStream;

public class Sample16 {
    public static void main(String[] args) {
        int sum1 = 0;
        OptionalInt sum2;

        sum1 = IntStream.rangeClosed(7, 10)
                .reduce(6, Integer::sum);

        sum2 = IntStream.rangeClosed(1, 10)
                .reduce(Integer::sum);

        OptionalInt sum3 = OptionalInt.empty();
        if (sum3.isEmpty()) {
            System.out.println("sum3은 값이 비었어요");
        }
        sum3 = OptionalInt.of(6);
        System.out.println(sum3);
        System.out.println(sum3.getAsInt());
    }
}
