package chap17;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class Sample17 {
    public static void main(String[] args) {
        String[] animals = {"토끼", "호랑이", "고양이", "강아지", "고양이", "고양이"};

        System.out.println("** 기본 배열 출력");
        System.out.println(Arrays.toString(animals));

        System.out.println("** List로 변환후 출력");
        List<String> ani1 = Arrays.stream(animals)
                .collect(Collectors.toList());
        System.out.println(ani1);

        System.out.println("** Set로 변환후 출력");
        Set<String> ani2 = Arrays.stream(animals)
                .collect(toSet());
        System.out.println(ani2);

        System.out.println("** TreeSet로 변환후 출력");
        TreeSet<String> ani3 = Arrays.stream(animals)
                .collect(toCollection(() -> new TreeSet<>()));
        System.out.println(ani3);

        System.out.println("** HashMap로 변환후 출력");
        Map<String, Integer> ani4 = Arrays.stream(animals)
                        .collect(toMap(Function.identity(), String::length, (x1, x2) -> x1 + x2));
        System.out.println(ani4);
    }
}
