package lv_0;

/**
 * 정수 부분
 * 문제 설명
 * 실수 flo가 매개 변수로 주어질 때, flo의 정수 부분을 return하도록 solution 함수를 완성해주세요.
 *
 * 제한사항
 * 0 ≤ flo ≤ 100
 */
public class NTest3 {
	public static void main(String[] args) {
		double flo = 69.32;
		int solution = new Solution().solution(flo);
		System.out.println("solution = " + solution);
	}

	static class Solution {
		public int solution(double flo) {
			int answer = 0;
			answer = (int) flo;
			return answer;
		}
	}
}
