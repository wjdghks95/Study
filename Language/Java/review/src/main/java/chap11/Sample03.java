package chap11;

import java.util.ArrayList;

public class Sample03 {
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

        arr.remove(2);
        for (String s : arr) {
            System.out.println("s = " + s);
        }

        var delArr = new ArrayList<String>();
        delArr.add("둘");
        delArr.add("셋");
        arr.removeAll(delArr);
        System.out.println("========");
        for (String s : arr) {
            System.out.println("s = " + s);
        }

        arr.removeAll(arr);
        System.out.println("========");
        for (String s : arr) {
            System.out.println("s = " + s);
        }
    }
}
