package lv_0;

/**
 * 공배수
 * 문제 설명
 * 정수 number와 n, m이 주어집니다.
 * number가 n의 배수이면서 m의 배수이면 1을 아니라면 0을 return하도록 solution 함수를 완성해주세요.
 *
 * 제한사항
 * 10 ≤ number ≤ 100
 * 2 ≤ n, m < 10
 */
public class NTest10 {
	public static void main(String[] args) {
		int number = 60;
		int n = 2;
		int m = 3;
		int solution = new Solution().solution(number, n, m);
		System.out.println("solution = " + solution);
	}

	static class Solution {
		public int solution(int number, int n, int m) {
			int answer = 0;
			if (number % n == 0 && number % m == 0) {
				answer = 1;
			}
			return answer;
		}
	}
}
