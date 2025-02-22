package lv_0;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * A 강조하기
 * 문제 설명
 * 문자열 myString이 주어집니다.
 * myString에서 알파벳 "a"가 등장하면 전부 "A"로 변환하고,
 * "A"가 아닌 모든 대문자 알파벳은 소문자 알파벳으로 변환하여 return 하는 solution 함수를 완성하세요.
 *
 * 제한사항
 * 1 ≤ myString의 길이 ≤ 20
 * myString은 알파벳으로 이루어진 문자열입니다.
 * 입출력 예
 * myString	result
 * "abstract algebra"	"AbstrAct AlgebrA"
 */
public class Test78 {
    public static void main(String[] args) {
        String str_list = "abstract algebra";
        // result "AbstrAct AlgebrA"
        String solution = new Solution().solution(str_list);
        System.out.println("solution = " + solution);
    }

    static class Solution {
        public String solution(String myString) {
            String answer = "";
            answer = Arrays.stream(myString.split("")).map(str -> str.equals("a") ? str.toUpperCase() : !str.equals("A") ? str.toLowerCase() : str).collect(Collectors.joining());
            return answer;
        }
    }

    /*
    public String solution(String myString) {
        myString = myString.toLowerCase();
        myString = myString.replace('a', 'A');

        return myString;
    }
     */
}
