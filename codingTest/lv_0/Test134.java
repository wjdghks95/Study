package lv_0;

import java.math.BigInteger;

/**
 * 두 수의 합
 * 문제 설명
 * 0 이상의 두 정수가 문자열 a, b로 주어질 때, a + b의 값을 문자열로 return 하는 solution 함수를 작성해 주세요.
 *
 * 제한사항
 * 1 ≤ a의 길이 ≤ 100,000
 * 1 ≤ b의 길이 ≤ 100,000
 * a와 b는 숫자로만 이루어져 있습니다.
 * a와 b는 정수 0이 아니라면 0으로 시작하지 않습니다.
 *
 * 입출력 예
 * a	b	result
 * "582"	"734"	"1316"
 * "18446744073709551615"	"287346502836570928366"	"305793246910280479981"
 * "0"	"0"	"0"
 */
public class Test134 {
    public static void main(String[] args) {
        String a = "18446744073709551615";
        String b = "287346502836570928366";
        String solution = new Solution().solution(a, b);
        System.out.println("solution = " + solution);
    }

    static class Solution {
        public String solution(String a, String b) {
            String answer = "";
            BigInteger bigInteger = new BigInteger(a).add(new BigInteger(b));
            answer = bigInteger.toString();
            return answer;
        }
    }
}

