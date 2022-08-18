package chap02;

import java.util.Scanner;

public class ScannerTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("int 자료형을 입력하세요 : ");
        int a = sc.nextInt();

        System.out.println("char 자료형을 입력하세요 : ");
        char b = sc.next().charAt(0);

        System.out.println("long 자료형을 입력하세요 : ");
        long c = sc.nextLong();

        System.out.println("double 자료형을 입력하세요 : ");
        double d = sc.nextDouble();

        System.out.println("String 자료형을 입력하세요 : ");
        String e = sc.next();

        System.out.println();

        System.out.println("int : " + a);
        System.out.println("char : " + b);
        System.out.println("long : " + c);
        System.out.println("double : " + d);
        System.out.println("String : " + e);
    }
}
