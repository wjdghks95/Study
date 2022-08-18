package chap05;

import java.util.Arrays;

public class ArrayClassTest {
    public static void main(String[] args) {
        int[] num1 = {1, 2, 3};

        int[][] num2 = {
                {1, 2, 3}, {4, 5, 6}, {7}, {8, 9, 10}, {11, 12, 13}
        };

        System.out.println(Arrays.toString(num1));
        System.out.println(Arrays.deepToString(num2));

        String[] han1 = new String[]
                {"라면", "미역국", "떡볶이", "수제비", "갈비탕", "순대국"};

        String[] han2 = Arrays.copyOf(han1, han1.length -1);
        String[] han3 = Arrays.copyOf(han1, han1.length -2);
        String[] han4 = Arrays.copyOf(han3, han3.length -1);
        System.out.println(Arrays.toString(han1));
        System.out.println(Arrays.toString(han2));
        System.out.println(Arrays.toString(han3));
        System.out.println(Arrays.toString(han4));
        System.out.println("\n첫 번째와 마지막 요소를 제거하고 복사하여 출력 ==");
        String[] cp = Arrays.copyOfRange(han1, 1, han1.length -1);
        System.out.println(Arrays.toString(cp));
    }
}
