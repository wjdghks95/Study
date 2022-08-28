package chap16;

import java.util.function.BiFunction;

public class Sample25 {
    public static void main(String[] args) {
        Math math = new Math();

        BiFunction<Integer, Integer, Integer> minus1 = (a, b) -> math.minus(a, b);
        BiFunction<Integer, Integer, Integer> minus2 = math::minus;

        System.out.println("람다식 - " + minus1.apply(10, 2));
        System.out.println("메서드 참조 - " + minus2.apply(5, 2));
    }
}

class Math {
    public int minus(int a, int b) { // 2개의 매개변수가 있고 반환 자료형이 있음
        return a - b;
    }
}
