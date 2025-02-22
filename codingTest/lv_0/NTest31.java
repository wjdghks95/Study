package lv_0;

import java.util.Arrays;

/**
 * 원소들의 곱과 합
 * 문제 설명
 * 정수가 담긴 리스트 num_list가 주어질 때, 모든 원소들의 곱이 모든 원소들의 합의 제곱보다 작으면 1을 크면 0을 return하도록 solution 함수를 완성해주세요.
 *
 * 제한사항
 * 2 ≤ num_list의 길이 ≤ 10
 * 1 ≤ num_list의 원소 ≤ 9
 */
public class NTest31 {
	public static void main(String[] args) {
		int[] num_list = {3, 4, 5, 2, 1};
		// result 1
		int solution = new Solution().solution(num_list);
		System.out.println("solution = " + solution);
	}

	static class Solution {
		public int solution(int[] num_list) {
			int answer = 0;
			answer = Arrays.stream(num_list).reduce((a, b) -> a *= b).getAsInt() < Math.pow(Arrays.stream(num_list).sum(), 2) ? 1 : 0;
			return answer;
		}
	}
}
