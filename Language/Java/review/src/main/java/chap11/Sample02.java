package chap11;

import java.util.ArrayList;

public class Sample02 {
    public static void main(String[] args) {
        var arr = new ArrayList<String>();
        arr.add("하나");
        arr.add("둘");
        arr.add("셋");
        arr.add("넷");
        arr.add("다섯");

        arr.add(2, "둘 쩜 오");
        arr.set(2, "이 쩜 오");

        for (String s : arr) {
            System.out.println("s = " + s);
        }
    }
}
