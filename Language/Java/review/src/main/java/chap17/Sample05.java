package chap17;

import java.util.ArrayList;
import java.util.stream.Stream;

public class Sample05 {
    public static void main(String[] args) {
        //배열 생성
        var list1 = new ArrayList<String>();
        list1.add("dog");
        list1.add("cat");
        list1.add("dog");
        list1.add("cat");

        var list2 = new ArrayList<Integer>();
        list2.add(1);
        list2.add(1);
        list2.add(5);
        list2.add(5);
        list2.add(6);
        list2.add(6);

        //스트림 생성
        Stream<String> arrStrm1 = list1.stream();
        Stream<Integer> arrStrm2 = list2.stream();

        //스트림 이용한 출력
        System.out.println("== 스트림을 이용한 출력");
        arrStrm1.forEach(System.out::println);
        System.out.println();
        arrStrm2.forEach(System.out::println);
        System.out.println();

        //컬렉션에서 스트림으로 바로 출력
        System.out.println("== 컬렉션에서 스트림으로 바로 출력");
        list1.stream()
                .distinct()
                .forEach(System.out::println);
        System.out.println();
        list2.stream()
                .distinct()
                .forEach(System.out::println);
    }
}
