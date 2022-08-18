package chap02;

import java.util.Random;

public class RandomNumberTest {
    public static void main(String[] args) {
        Random random = new Random();
        int num = random.nextInt(3) + 1; // 0 ~ 2 -> 1 ~ 3
        System.out.printf("난수 : %d", num);

        System.out.println();

        int num2 = (int) (Math.random() * 3 + 1);
        System.out.printf("난수 : %d", num2);
    }
}
