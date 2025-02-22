package lv_0;

import java.util.Arrays;

/**
 * 문자열 정수의 합
 * 문제 설명
 * 한 자리 정수로 이루어진 문자열 num_str이 주어질 때, 각 자리수의 합을 return하도록 solution 함수를 완성해주세요.
 *
 * 제한사항
 * 3 ≤ num_str ≤ 100
 */
public class NTest25 {
	public static void main(String[] args) {
		String num_str = "123456789"; // result 45
		int solution = new Solution().solution(num_str);
		System.out.println("solution = " + solution);
	}

	static class Solution {
		public int solution(String num_str) {
			int answer = 0;
			answer = Arrays.stream(num_str.split("")).mapToInt(s -> Integer.valueOf(s)).sum();
			return answer;
		}
	}
}
