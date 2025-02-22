package lv_0;

/**
 * 문자열로 변환
 * 문제 설명
 * 정수 n이 주어질 때, n을 문자열로 변환하여 return하도록 solution 함수를 완성해주세요.
 *
 * 제한사항
 * 1 ≤ n ≤ 10000
 */
public class NTest2 {
	public static void main(String[] args) {
		int n = 123;
		String solution = new Solution().solution(n);
		System.out.println("solution = " + solution);
	}

	static class Solution {
		public String solution(int n) {
			String answer = "";
			answer = String.valueOf(n);
			return answer;
		}
	}
}
