package lv_0;

/**
 * 첫 번째로 나오는 음수
 * 문제 설명
 * 정수 리스트 num_list가 주어질 때, 첫 번째로 나오는 음수의 인덱스를 return하도록 solution 함수를 완성해주세요.
 * 음수가 없다면 -1을 return합니다.
 *
 * 제한사항
 * 5 ≤ num_list의 길이 ≤ 100
 * -10 ≤ num_list의 원소 ≤ 100
 */
public class NTest17 {
	public static void main(String[] args) {
		int[] num_list = {12, 4, 15, 46, 38, -2, 15};
		int solution = new Solution().solution(num_list);
		System.out.println("solution = " + solution);
	}

	static class Solution {
		public int solution(int[] num_list) {
			int answer = -1;
			for (int i = 0; i < num_list.length; i++) {
				if (num_list[i] < 0) {
					answer = i;
					break;
				}
			}
			return answer;
		}
	}

	/*
	class Solution {
	    public int solution(int[] num_list) {
	        final int LENGTH = num_list.length;

	        return IntStream.range(0, LENGTH).filter(i -> num_list[i] < 0).findFirst().orElse(-1);
	    }
	}
	 */
}
