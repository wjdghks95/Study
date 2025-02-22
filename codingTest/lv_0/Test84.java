package lv_0;

/**
 * 0 떼기
 * 문제 설명
 * 정수로 이루어진 문자열 n_str이 주어질 때,
 * n_str의 가장 왼쪽에 처음으로 등장하는 0들을 뗀 문자열을 return하도록 solution 함수를 완성해주세요.
 *
 * 제한사항
 * 2 ≤ n_str ≤ 10
 * n_str이 "0"으로만 이루어진 경우는 없습니다.
 * 입출력 예
 * n_str	result
 * "0010"	"10"
 * "854020"	"854020"
 */
public class Test84 {
    public static void main(String[] args) {
        String n_str = "0010";
        // result 10
        String solution = new Solution().solution(n_str);
        System.out.println("solution = " + solution);
    }

    static class Solution {
        public String solution(String n_str) {
            String answer = "";
            int i = 0;
            while (n_str.substring(i).startsWith("0")) {
                i++;
            }
            answer = n_str.substring(i);
            return answer;
        }
    }

    /*
    class Solution {
        public String solution(String n_str) {
            return ""+Integer.parseInt(n_str);
        }
    }
     */
}
