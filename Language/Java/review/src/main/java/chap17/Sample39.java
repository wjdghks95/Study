package chap17;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Sample39 {
    public static void main(String[] args) {
        List<Integer> list = IntStream.rangeClosed(1, 10)
                .map(x -> x * 2)
                .boxed()
                .collect(Collectors.toList());

        System.out.println(list);

        List<String> list2 = Arrays.asList("A", "B", "C", "D");
        list2.stream().filter(name -> name.contains("A")).forEach(System.out::println);
        list2.stream().map(s -> s.toLowerCase()).forEach(System.out::println);
    }
}
