package lv_0;

import java.util.Arrays;

/**
 * n보다 커질 때까지 더하기
 * 문제 설명
 * 정수 배열 numbers와 정수 n이 매개변수로 주어집니다.
 * numbers의 원소를 앞에서부터 하나씩 더하다가 그 합이 n보다 커지는 순간 이때까지 더했던 원소들의 합을 return 하는 solution 함수를 작성해 주세요.
 *
 * 제한사항
 * 1 ≤ numbers의 길이 ≤ 100
 * 1 ≤ numbers의 원소 ≤ 100
 * 0 ≤ n < numbers의 모든 원소의 합
 */
public class NTest35 {
	public static void main(String[] args) {
		int[] numbers = {34, 5, 71, 29, 100, 34};
		int n = 123;
		// result 139
		int solution = new Solution().solution(numbers, n);
		System.out.println("solution = " + solution);
	}

	static class Solution {
		public int solution(int[] numbers, int n) {
			int answer = 0;
			answer = Arrays.stream(numbers).reduce((a, b) -> a <= n ? a += b : a).getAsInt();
			return answer;
		}
	}
}
