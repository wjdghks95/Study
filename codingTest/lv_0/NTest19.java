package lv_0;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * 배열 만들기 1
 * 문제 설명
 * 정수 n과 k가 주어졌을 때, 1 이상 n이하의 정수 중에서 k의 배수를 오름차순으로 저장한 배열을 return 하는 solution 함수를 완성해 주세요.
 *
 * 제한사항
 * 1 ≤ n ≤ 1,000,000
 * 1 ≤ k ≤ min(1,000, n)
 */
public class NTest19 {
	public static void main(String[] args) {
		int n = 10;
		int k = 3;
		int[] solution = new Solution().solution(n, k);
		System.out.println("solution = " + Arrays.toString(solution));
	}

	static class Solution {
		public int[] solution(int n, int k) {
			int[] answer = {};
			answer = IntStream.rangeClosed(1, n).filter(i -> i % k == 0).toArray();
			return answer;
		}
	}
}
