package chap16;

import java.util.function.Function;
import java.util.function.UnaryOperator;

public class Sample21 {
    public static void main(String[] args) {
        // Function은 매개변수와 반환 자룧형을 각각 정의
        Function<String, String> sourceFile = p -> p + ".java";

        // UnaryOperator는 맥개변수와 반환 자료형을 하나로 정의
        UnaryOperator<String> classFile = p -> p + ".class";

        System.out.println(sourceFile.apply("Sample21"));
        System.out.println(classFile.apply("Sample21"));

        Function<String, String> a = Function.identity();
        UnaryOperator<String> b = UnaryOperator.identity();

        System.out.println(a.apply("python"));
        System.out.println(b.apply("python"));

        UnaryOperator<String> uo = s -> s.toLowerCase();
        System.out.println(uo.apply("UnaryOperator"));
    }
}
