package chap16;

import java.util.Arrays;
import java.util.List;

public class Sample22 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        list.forEach(System.out::println);
    }
}

class Writer {
    public static void doWrite(Object msg) {
        System.out.println(msg);
    }
}
