package lv_0;

/**
 * 문자열의 뒤의 n글자
 * 문제 설명
 * 문자열 my_string과 정수 n이 매개변수로 주어질 때,
 * my_string의 뒤의 n글자로 이루어진 문자열을 return 하는 solution 함수를 작성해 주세요.
 *
 * 제한사항
 * my_string은 숫자와 알파벳으로 이루어져 있습니다.
 * 1 ≤ my_string의 길이 ≤ 1,000
 * 1 ≤ n ≤ my_string의 길이
 */
public class NTest8 {
	public static void main(String[] args) {
		String my_string = "ProgrammerS123";
		int n = 11;
		String solution = new Solution().solution(my_string, n);
		System.out.println("solution = " + solution);
	}

	static class Solution {
		public String solution(String my_string, int n) {
			String answer = "";
			answer = my_string.substring(my_string.length()-n);
			return answer;
		}
	}
}
