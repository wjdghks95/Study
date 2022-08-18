package chap05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayAsListTest {
    public static void main(String[] args) {
        // 배열에서 데이터 추가하는 방법1
        var students1 = new String[7];
        students1[0] = "스노우 화이트";
        students1[1] = "멀린";
        students1[2] = "레지나";
        students1[3] = "애버러지";
        students1[4] = "잭";
        students1[5] = "아더";
        students1[6] = "한스";

        // 배열에서 데이터 추가하는 방법2
        var student2 = new String[] {
            "스노우 화이트", "멀린", "레지나", "애버러지", "잭", "아더", "한스"
        };

        // List 에서 데이터 추가하는 방법1
        List<String> student3 = new ArrayList<>();
        student3.add("스노우 화이트");

        // List 에서 데이터 추가하는 방법2
        List<String> student4 = Arrays.asList("스노우 화이트", "멀린", "레지나", "애버러지", "잭", "아더", "한스");
    }
}
