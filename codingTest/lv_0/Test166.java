package lv_0;

import java.util.Arrays;

/**
 * 분수의 덧셈
 * 문제 설명
 * 첫 번째 분수의 분자와 분모를 뜻하는 numer1, denom1,
 * 두 번째 분수의 분자와 분모를 뜻하는 numer2, denom2가 매개변수로 주어집니다.
 * 두 분수를 더한 값을 기약 분수로 나타냈을 때 분자와 분모를 순서대로 담은 배열을 return 하도록 solution 함수를 완성해보세요.
 *
 * 제한사항
 * 0 <numer1, denom1, numer2, denom2 < 1,000
 *
 * 입출력 예
 * numer1	denom1	numer2	denom2	result
 * 1	    2	    3	    4	    [5, 4]
 * 9	    2	    1	    3	    [29, 6]
 */
public class Test166 {
    public static void main(String[] args) {
        int numer1 = 1;
        int denom1 = 2;
        int numer2 = 3;
        int denom2 = 4;
        int[] solution = new Solution().solution(numer1, denom1, numer2, denom2);
        System.out.println("solution = " + Arrays.toString(solution));
    }

    static class Solution {
        public int[] solution(int numer1, int denom1, int numer2, int denom2) {
            int[] answer = {};
            int numer = numer1 * denom2 + numer2 * denom1;
            int denom = denom1 * denom2;

            int i = 2;
            while (i <= Math.max(numer, denom)) {
                if (numer % i == 0 && denom % i == 0) {
                    numer /= i;
                    denom /= i;
                } else {
                    i++;
                }
            }

            answer = new int[]{numer, denom};
            return answer;
        }
    }
}