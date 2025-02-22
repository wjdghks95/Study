package lv_0;

import java.util.Arrays;

/**
 * 길이에 따른 연산
 * 문제 설명
 * 정수가 담긴 리스트 num_list가 주어질 때,
 * 리스트의 길이가 11 이상이면 리스트에 있는 모든 원소의 합을 10 이하이면 모든 원소의 곱을 return하도록 solution 함수를 완성해주세요.
 *
 * 제한사항
 * 2 ≤ num_list의 길이 ≤ 20
 * 1 ≤ num_list의 원소 ≤ 9
 */
public class NTest23 {
	public static void main(String[] args) {
		int[] num_list = {3, 4, 5, 2, 5, 4, 6, 7, 3, 7, 2, 2, 1};	// result 51
		int solution = new Solution().solution(num_list);
		System.out.println("solution = " + (solution));
	}

	static class Solution {
		public int solution(int[] num_list) {
			int answer = 0;
			answer = Arrays.stream(num_list).reduce((i, j) -> {
				if (num_list.length <= 10) {
					i *= j;
				} else {
					i += j;
				}
				return i;
			}).getAsInt();
			return answer;
		}
	}

	/*
	class Solution {
	    public int solution(int[] num_list) {
	        IntStream stream = IntStream.of(num_list);
	        return num_list.length > 10 ? stream.sum() : stream.reduce(1, (a, b) -> a * b);
	    }
	}
	 */
}
