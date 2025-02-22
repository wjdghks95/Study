package lv_0;

/**
 * 문자열 곱하기
 * 문제 설명
 * 문자열 my_string과 정수 k가 주어질 때, my_string을 k번 반복한 문자열을 return 하는 solution 함수를 작성해 주세요.
 *
 * 제한사항
 * 1 ≤ my_string의 길이 ≤ 100
 * my_string은 영소문자로만 이루어져 있습니다.
 * 1 ≤ k ≤ 100
 */
public class NTest13 {
	public static void main(String[] args) {
		String my_string = "string";
		int k = 3;
		String solution = new Solution().solution(my_string, k);
		System.out.println("solution = " + solution);
	}

	static class Solution {
		public String solution(String my_string, int k) {
			String answer = "";
			for (int i = 0; i < k; i++) {
				answer += my_string;
			}
			return answer;
		}
	}
}
