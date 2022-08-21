package chap11;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Sample10 {
    public static void main(String[] args) {
        var list = new ArrayList<String>();
        list.add("dog");
        list.add("dog");
        list.add("cat");
        list.add("cat");
        list.add("lion");
        list.add("lion");

        System.out.println(list);

        var hs = new HashSet<String>();
        hs.addAll(list);

        System.out.println(hs);
        hs.add("lion");
        System.out.println(hs);
        hs.add("tiger");
        System.out.println(hs);

        hs.forEach(x -> System.out.println(x));
        System.out.println("=====");
        hs.forEach(System.out::println);
        System.out.println("=====");
        hs.iterator().forEachRemaining(x -> System.out.println(x));

        System.out.println("\n'cat'이 존재하나요? " + hs.contains("cat"));
        System.out.println("\n'bird'가 존재하나요? " + hs.contains("bird"));
    }
}
