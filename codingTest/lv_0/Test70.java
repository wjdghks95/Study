package lv_0;

/*
    이진수 더하기
        이진수를 의미하는 두 개의 문자열 bin1과 bin2가 매개변수로 주어질 때,
        두 이진수의 합을 return하도록 solution 함수를 완성해주세요.

    제한사항
    return 값은 이진수를 의미하는 문자열입니다.
    1 ≤ bin1, bin2의 길이 ≤ 10
    bin1과 bin2는 0과 1로만 이루어져 있습니다.
    bin1과 bin2는 "0"을 제외하고 0으로 시작하지 않습니다.
 */
public class Test70 {
    public static void main(String[] args) {
        String bin1 = "10";
        String bin2 = "11";
        String solution = new Solution().solution(bin1, bin2);
        System.out.println("solution = " + solution);
    }

    static class Solution {
        public String solution(String bin1, String bin2) {
            String answer = "";
            int i = Integer.parseInt(bin1, 2);
            int j = Integer.parseInt(bin2, 2);

            int result = i + j;
            answer = Integer.toBinaryString(result);
            return answer;
        }

        /** [모범답안] */
        /*
            public String solution(String bin1, String bin2) {
                String answer = "";
                answer = Integer.toString(Integer.parseInt(bin1, 2) + Integer.parseInt(bin2, 2), 2);
                return answer;
            }
         */
    }
}
