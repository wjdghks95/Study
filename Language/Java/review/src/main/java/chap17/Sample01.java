package chap17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Sample01 {
    public static void main(String[] args) {
        var list = Arrays.asList(1, 2, 3, 2, 1, 5);
        System.out.println(list);

        var list2 = new ArrayList<>(new HashSet<>(list));
        list2.forEach(System.out::println);
        System.out.println("=========");
        list.stream().distinct().forEach(System.out::println);
    }
}
