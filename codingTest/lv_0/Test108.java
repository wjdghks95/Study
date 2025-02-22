package lv_0;

/**
 * 문자열 뒤집기
 * 문제 설명
 * 문자열 my_string과 정수 s, e가 매개변수로 주어질 때, my_string에서 인덱스 s부터 인덱스 e까지를 뒤집은 문자열을 return 하는 solution 함수를 작성해 주세요.
 *
 * 제한사항
 * my_string은 숫자와 알파벳으로만 이루어져 있습니다.
 * 1 ≤ my_string의 길이 ≤ 1,000
 * 0 ≤ s ≤ e < my_string의 길이
 * 입출력 예
 * my_string	s	e	result
 * "Progra21Sremm3"	6	12	"ProgrammerS123"
 * "Stanley1yelnatS"	4	10	"Stanley1yelnatS"
 */
public class Test108 {
    public static void main(String[] args) {
        String my_string = "Progra21Sremm3";
        int s = 6;
        int e = 12;
        // result "ProgrammerS123"
        String solution = new Solution().solution(my_string, s, e);
        System.out.println("solution = " + solution);
    }

    static class Solution {
        public String solution(String my_string, int s, int e) {
            String answer = "";
            StringBuilder reverse = new StringBuilder(my_string.substring(s, e + 1)).reverse();
            answer = my_string.replace(my_string.substring(s, e + 1), reverse);
            return answer;
        }
    }
}

