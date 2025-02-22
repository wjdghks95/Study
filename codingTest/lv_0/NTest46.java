package lv_0;

import java.util.stream.IntStream;

/**
 * 홀수 vs 짝수
 * 문제 설명
 * 정수 리스트 num_list가 주어집니다. 가장 첫 번째 원소를 1번 원소라고 할 때,
 * 홀수 번째 원소들의 합과 짝수 번째 원소들의 합 중 큰 값을 return 하도록 solution 함수를 완성해주세요.
 * 두 값이 같을 경우 그 값을 return합니다.
 *
 * 제한사항
 * 5 ≤ num_list의 길이 ≤ 50
 * -9 ≤ num_list의 원소 ≤ 9
 * 입출력 예
 * num_list	result
 * [4, 2, 6, 1, 7, 6]	17
 */
public class NTest46 {
	public static void main(String[] args) {
		int[] num_list = {4, 2, 6, 1, 7, 6};
		// result 17
		int solution = new Solution().solution(num_list);
		System.out.println("solution = " + solution);
	}

	static class Solution {
		public int solution(int[] num_list) {
			int answer = 0;
			int a = IntStream.iterate(0, i -> i < num_list.length, i -> i +=2).map(i -> num_list[i]).sum();
			int b = IntStream.iterate(1, i -> i < num_list.length, i -> i +=2).map(i -> num_list[i]).sum();
			answer = a >= b ? a : b;
			return answer;
		}

		/*
		public int solution(int[] num_list) {
	        return Integer.max(
	            IntStream.iterate(0, i -> i < num_list.length, i -> i + 2).map(i -> num_list[i]).sum(),
                IntStream.iterate(1, i -> i < num_list.length, i -> i + 2).map(i -> num_list[i]).sum());
	    }
		 */
	}
}
