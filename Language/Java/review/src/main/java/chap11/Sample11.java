package chap11;

import java.util.ArrayList;
import java.util.TreeSet;

public class Sample11 {
    public static void main(String[] args) {
        var arr = new ArrayList<String>();
        arr.add("사자");
        arr.add("호랑이");
        arr.add("원숭이");
        arr.add("사자");
        arr.add("호랑이");
        arr.add("원숭이");
        System.out.println(arr);

        System.out.println("1 > ArrayList를 TreeSet으로 가져옵니다. [addAll()]");
        var trs = new TreeSet<String>();
        trs.addAll(arr);
        System.out.println(trs);

        trs.add("사자");
        System.out.println(trs);
        trs.add("기린");
        System.out.println(trs);

        System.out.println(trs);
        if (!trs.contains("토끼")) {
            trs.add("토끼");
        }
        System.out.println(trs);

        System.out.println(trs.ceiling("자"));
        System.out.println(trs.floor("자"));
    }
}
