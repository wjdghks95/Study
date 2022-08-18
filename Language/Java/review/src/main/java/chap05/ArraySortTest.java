package chap05;

import java.util.Arrays;

public class ArraySortTest {
    public static void main(String[] args) {

        String[] han1 = new String[]
                {"라면", "미역국", "떡볶이", "수제비", "갈비탕", "순대국"};

        System.out.println("정렬 전: " + Arrays.toString(han1));

        String[] han2 = Arrays.copyOf(han1, han1.length); // 전체 정렬
        String[] han3 = Arrays.copyOf(han1, han1.length); // 범위 정렬

        Arrays.sort(han2);
        Arrays.sort(han3, 2, 5);

        System.out.println("전체 정렬 후 : " + Arrays.toString(han2));
        System.out.println("범위 정렬 후 : " + Arrays.toString(han3));
    }
}
