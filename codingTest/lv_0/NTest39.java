package lv_0;

import java.util.Arrays;

/**
 * 마지막 두 원소
 * 문제 설명
 * 정수 리스트 num_list가 주어질 때,
 * 마지막 원소가 그전 원소보다 크면 마지막 원소에서 그전 원소를 뺀 값을
 * 마지막 원소가 그전 원소보다 크지 않다면 마지막 원소를 두 배한 값을 추가하여 return하도록 solution 함수를 완성해주세요.
 *
 * 제한사항
 * 2 ≤ num_list의 길이 ≤ 10
 * 1 ≤ num_list의 원소 ≤ 9
 * 입출력 예
 * num_list	result
 * [2, 1, 6]	[2, 1, 6, 5]
 */
public class NTest39 {
	public static void main(String[] args) {
		int[] num_list = {2, 1, 6};
		// result [2, 1, 6, 5]
		int[] solution = new Solution().solution(num_list);
		System.out.println("solution = " + Arrays.toString(solution));
	}

	static class Solution {
		public int[] solution(int[] num_list) {
			int[] answer = {};
			int a = num_list[num_list.length - 1];
			int b = num_list[num_list.length - 2];
			int result = a > b ? a - b : a * 2;
			answer = Arrays.copyOf(num_list, num_list.length + 1);
			answer[answer.length-1] = result;
			return answer;
		}
	}
}
