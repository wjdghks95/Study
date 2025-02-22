package lv_0;

import java.util.Arrays;

/**
 * 9로 나눈 나머지
 * 문제 설명
 * 음이 아닌 정수를 9로 나눈 나머지는 그 정수의 각 자리 숫자의 합을 9로 나눈 나머지와 같은 것이 알려져 있습니다.
 * 이 사실을 이용하여 음이 아닌 정수가 문자열 number로 주어질 때, 이 정수를 9로 나눈 나머지를 return 하는 solution 함수를 작성해주세요.
 *
 * 제한사항
 * 1 ≤ number의 길이 ≤ 100,000
 * number의 원소는 숫자로만 이루어져 있습니다.
 * number는 정수 0이 아니라면 숫자 '0'으로 시작하지 않습니다.
 * 입출력 예
 * number	result
 * "123"	6
 * "78720646226947352489"	2
 */
public class Test99 {
    public static void main(String[] args) {
        String number = "123";
        // result 6
        int solution = new Solution().solution(number);
        System.out.println("solution = " + solution);
    }

    static class Solution {
        public int solution(String number) {
            int answer = 0;
            answer = Arrays.stream(number.split("")).mapToInt(Integer::parseInt).sum() % 9;
            return answer;
        }
    }
}

