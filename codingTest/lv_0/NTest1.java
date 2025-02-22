package lv_0;

/**
 * 문자 리스트를 문자열로 변환하기
 *  문자들이 담겨있는 배열 arr가 주어집니다.
 *  arr의 원소들을 순서대로 이어 붙인 문자열을 return 하는 solution함수를 작성해 주세요.
 *
 * 제한사항
 * 1 ≤ arr의 길이 ≤ 200
 * arr의 원소는 전부 알파벳 소문자로 이루어진 길이가 1인 문자열입니다.
 */
public class NTest1 {
	public static void main(String[] args) {
		String[] arr = {"a", "b", "c"};
		String solution = new Solution().solution(arr);
		System.out.println("solution = " + solution);
	}

	static class Solution {
		public String solution(String[] arr) {
			String answer = "";
			for (String s : arr) {
				answer += s;
			}
			return answer;
		}
	}

	/** 모범답안 */
	/*
	class Solution {
	    public String solution(String[] arr) {
	        return Arrays.stream(arr).collect(Collectors.joining());
	    }
	}
	 */
}


