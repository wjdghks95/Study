package chap16;

import java.util.function.Predicate;

public class Sample16 {
    public static void main(String[] args) {
        Predicate<Integer> pre = i -> (i % 2) == 0;
        if (pre.test(1)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}
