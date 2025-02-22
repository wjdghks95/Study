package lv_0;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * 카운트 업
 * 문제 설명
 * 정수 start와 end가 주어질 때, start부터 end까지의 숫자를 차례로 담은 리스트를 return하도록 solution 함수를 완성해주세요.
 *
 * 제한사항
 * 0 ≤ start ≤ end ≤ 50
 */
public class NTest20 {
	public static void main(String[] args) {
		int start = 3;
		int end = 10;
		int[] solution = new Solution().solution(start, end);
		System.out.println("solution = " + Arrays.toString(solution));
	}

	static class Solution {
		public int[] solution(int start, int end) {
			int[] answer = {};
			answer = IntStream.rangeClosed(start, end).toArray();
			return answer;
		}
	}
}
