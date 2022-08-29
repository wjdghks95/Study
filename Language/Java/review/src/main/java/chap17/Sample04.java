package chap17;

import java.util.Arrays;
import java.util.stream.Stream;

public class Sample04 {
    public static void main(String[] args) {
        String[] str1 = {"빵형", "판다", "egs"};
        String[] str2 = {"coder", "광명컴쟁이", "에리온"};

        Stream<String[]> strm1 = Stream.of(str1, str2);
        System.out.println("** Stream.of(str1, str2)");
        Stream.of(str1, str2).forEach(x -> System.out.println(Arrays.deepToString(x)));

        System.out.println("** strm1.flatMap(Arrays::stream)");
        strm1.flatMap(Arrays::stream).forEach(System.out::println);
    }
}
