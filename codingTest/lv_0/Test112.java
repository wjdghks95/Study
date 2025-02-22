package lv_0;

/**
 * 간단한 논리 연산
 * 문제 설명
 * boolean 변수 x1, x2, x3, x4가 매개변수로 주어질 때, 다음의 식의 true/false를 return 하는 solution 함수를 작성해 주세요.
 *
 * (x1 ∨ x2) ∧ (x3 ∨ x4)
 * 입출력 예
 * x1	x2	x3	x4	result
 * false	true	true	true	true
 * true	false	false	false	false
 */
public class Test112 {
    public static void main(String[] args) {
        boolean x1 = false;
        boolean x2 = true;
        boolean x3 = true;
        boolean x4 = true;
        // result true
        boolean solution = new Solution().solution(x1, x2, x3, x4);
        System.out.println("solution = " + solution);
    }

    static class Solution {
        public boolean solution(boolean x1, boolean x2, boolean x3, boolean x4) {
            boolean answer = true;
            answer = (x1 || x2) && (x3 || x4) ? true : false;
            return answer;
        }
    }
}

