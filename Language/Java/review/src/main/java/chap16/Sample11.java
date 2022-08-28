package chap16;

import java.util.function.Function;

public class Sample11 {
    public static void main(String[] args) {
        Function<Integer, String> f = i -> {
            String returnStr = "";

            for (AlphaNum a : AlphaNum.values()) {
                if (i == a.getNum()) {
                    returnStr = a.toString();
                    break;
                }
            }

            return returnStr;
        };

        System.out.println(f.apply(5));

        Function<Integer, String> f2 = i -> {
            if (i == 0) {
                return "Function";
            }
            return null;
        };
        System.out.printf("%s은 1개의 매개변수가 있고 1개의 자료형을 반환합니다.", f2.apply(0));
    }
}

enum AlphaNum {
    one(1), two(2), three(3), four(4), five(5);
    private final int num;

    AlphaNum(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }
}