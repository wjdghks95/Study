package lv_0;

import java.util.Arrays;

/**
 * 카운트 다운
 * 문제 설명
 * 정수 start와 end가 주어질 때, start에서 end까지 1씩 감소하는 수들을 차례로 담은 리스트를 return하도록 solution 함수를 완성해주세요.
 *
 * 제한사항
 * 0 ≤ end ≤ start ≤ 50
 */
public class NTest18 {
	public static void main(String[] args) {
		int start = 10;
		int end = 3;
		int[] solution = new Solution().solution(start, end);
		System.out.println("solution = " + Arrays.toString(solution));
	}

	static class Solution {
		public int[] solution(int start, int end) {
			int[] answer = {};
			answer = new int[start - end + 1];
			int j = 0;
			for (int i = start; i >= end; i--) {
				answer[j] = i;
				j++;
			}
			return answer;
		}
	}

	/*
	class Solution {
		public int[] solution(int start, int end) {
		    return IntStream.rangeClosed(-start, -end).map(i -> -i).toArray();
		}
	}
	 */
}
