package lv_0;

/**
 * 이어 붙인 수
 * 문제 설명
 * 정수가 담긴 리스트 num_list가 주어집니다.
 * num_list의 홀수만 순서대로 이어 붙인 수와 짝수만 순서대로 이어 붙인 수의 합을 return하도록 solution 함수를 완성해주세요.
 *
 * 제한사항
 * 2 ≤ num_list의 길이 ≤ 10
 * 1 ≤ num_list의 원소 ≤ 9
 * num_list에는 적어도 한 개씩의 짝수와 홀수가 있습니다.
 * 입출력 예
 * num_list	result
 * [3, 4, 5, 2, 1]	393
 */
public class NTest42 {
	public static void main(String[] args) {
		int[] num_list = {3, 4, 5, 2, 1};
		// result 393
		int solution = new Solution().solution(num_list);
		System.out.println("solution = " + solution);
	}

	static class Solution {
		public int solution(int[] num_list) {
			int answer = 0;
			String odd = "";
			String even = "";
			for (int i : num_list) {
				if (i % 2 != 0) {
					odd += String.valueOf(i);
				} else {
				    even += String.valueOf(i);
				}
			}
			answer = Integer.parseInt(odd) + Integer.parseInt(even);
			return answer;
		}
	}

	/*
	class Solution {
	    public int solution(int[] numList) {
	        return Integer.parseInt(Arrays.stream(numList).filter(value -> value % 2 != 0).mapToObj(String::valueOf).collect(Collectors.joining())) +
	            Integer.parseInt(Arrays.stream(numList).filter(value -> value % 2 == 0).mapToObj(String::valueOf).collect(Collectors.joining()));
	    }
	}
	 */
}
