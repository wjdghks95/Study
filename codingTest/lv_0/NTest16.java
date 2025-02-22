package lv_0;

import java.util.Arrays;

/**
 * n 번째 원소까지
 * 문제 설명
 * 정수 리스트 num_list와 정수 n이 주어질 때,
 * num_list의 첫 번째 원소부터 n 번째 원소까지의 모든 원소를 담은 리스트를 return하도록 solution 함수를 완성해주세요.
 *
 * 제한사항
 * 2 ≤ num_list의 길이 ≤ 30
 * 1 ≤ num_list의 원소 ≤ 9
 * 1 ≤ n ≤ num_list의 길이 ___
 */
public class NTest16 {
	public static void main(String[] args) {
		int[] num_list = {2, 1, 6};
		int k = 1;
		int[] solution = new Solution().solution(num_list, k);
		System.out.println("solution = " + Arrays.toString(solution));
	}

	static class Solution {
		public int[] solution(int[] num_list, int n) {
			int[] answer = {};
			answer = Arrays.stream(num_list).limit(n).toArray();
			return answer;
		}
	}
}
