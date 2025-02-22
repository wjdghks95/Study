package lv_0;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * 대소문자 바꿔서 출력하기
 * 문제 설명
 * 영어 알파벳으로 이루어진 문자열 str이 주어집니다. 각 알파벳을 대문자는 소문자로 소문자는 대문자로 변환해서 출력하는 코드를 작성해 보세요.
 *
 * 제한사항
 * 1 ≤ str의 길이 ≤ 20
 * str은 알파벳으로 이루어진 문자열입니다.
 * 입출력 예
 * 입력 #1
 * aBcDeFg
 * 출력 #1
 * AbCdEfG
 */
public class Test152 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String str = Arrays.stream(a.chars().toArray()).mapToObj(c -> c >= 97 ? String.valueOf((char) c).toUpperCase() : String.valueOf((char) c).toLowerCase()).collect(Collectors.joining());
        System.out.println("str = " + str);
    }
}

/*
    public class Solution {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            String a = sc.next();
            String answer = "";

            //Stack <Character> stack = new Stack <> ();

            for(Character c : a.toCharArray()){
                if(Character.isUpperCase(c)){
                    //stack.push(Character.toLowerCase(c));
                    answer += Character.toLowerCase(c);
                }
                else if(Character.isLowerCase(c)){
                    //stack.push(Character.toUpperCase(c));
                    answer += Character.toUpperCase(c);
                }
            }
            System.out.println(answer);
        }
    }
 */