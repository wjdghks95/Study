package lv_0;

import java.util.Arrays;

/**
 * n개 간격의 원소들
 * 문제 설명
 * 정수 리스트 num_list와 정수 n이 주어질 때,
 * num_list의 첫 번째 원소부터 마지막 원소까지 n개 간격으로 저장되어있는 원소들을 차례로 담은 리스트를 return하도록 solution 함수를 완성해주세요.
 * <p>
 * 제한사항
 * 5 ≤ num_list의 길이 ≤ 20
 * 1 ≤ num_list의 원소 ≤ 9
 * 1 ≤ n ≤ 4
 */
public class NTest32 {
	public static void main(String[] args) {
		int[] num_list = {4, 2, 6, 1, 7, 6};
		int n = 4;
		// result [4, 6, 7]
		int[] solution = new Solution().solution(num_list, n);
		System.out.println("solution = " + Arrays.toString(solution));
	}

	static class Solution {
		public int[] solution(int[] num_list, int n) {
			int[] answer = {};
			answer = new int[(int) Math.ceil(num_list.length / (double) n)];
			int k = 0;
			for (int i = 0; i < answer.length; i++) {
				answer[i] = num_list[k];
				k += n;
			}
			return answer;
		}
	}

	/*
	class Solution {
	    public int[] solution(int[] num_list, int n) {
	        return IntStream.iterate(0, i -> i < numList.length, i -> i + n).map(i -> numList[i]).toArray();
	    }
	}
	 */
}
