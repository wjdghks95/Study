package lv_0;

/**
 * 대문자로 바꾸기
 * 문제 설명
 * 알파벳으로 이루어진 문자열 myString이 주어집니다.
 * 모든 알파벳을 대문자로 변환하여 return 하는 solution 함수를 완성해 주세요.
 *
 * 제한사항
 * 1 ≤ myString의 길이 ≤ 100,000
 * myString은 알파벳으로 이루어진 문자열입니다.
 */
public class NTest5 {
	public static void main(String[] args) {
		String myString	= "aBcDeFg";
		String solution = new Solution().solution(myString);
		System.out.println("solution = " + solution);
	}

	static class Solution {
		public String solution(String myString) {
			String answer = "";
			answer = myString.toUpperCase();
			return answer;
		}
	}
}
