package lv_0;

/**
 * 정수 찾기
 * 문제 설명
 * 정수 리스트 num_list와 찾으려는 정수 n이 주어질 때,
 * num_list안에 n이 있으면 1을 없으면 0을 return하도록 solution 함수를 완성해주세요.
 *
 * 제한사항
 * 3 ≤ num_list의 길이 ≤ 100
 * 1 ≤ num_list의 원소 ≤ 100
 * 1 ≤ n ≤ 100
 */
public class NTest11 {
	public static void main(String[] args) {
		int[] num_list = {1, 2, 3, 4, 5};
		int n = 3;
		int solution = new Solution().solution(num_list, n);
		System.out.println("solution = " + solution);
	}

	static class Solution {
		public int solution(int[] num_list, int n) {
			int answer = 0;
			for (int i : num_list) {
				if (i == n) {
					answer = 1;
				}
			}
			return answer;
		}
	}

	/*
	class Solution {
	    public int solution(int[] numList, int n) {
	        return IntStream.of(numList).anyMatch(num -> num == n) ? 1 : 0;
	    }
	}
	 */
}
