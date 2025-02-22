package lv_0;

import java.util.Arrays;

/**
 * 배열에서 문자열 대소문자 변환하기
 * 문제 설명
 * 문자열 배열 strArr가 주어집니다.
 * 모든 원소가 알파벳으로만 이루어져 있을 때,
 * 배열에서 홀수번째 인덱스의 문자열은 모든 문자를 대문자로,
 * 짝수번째 인덱스의 문자열은 모든 문자를 소문자로 바꿔서 반환하는 solution 함수를 완성해 주세요.
 *
 * 제한사항
 * 1 ≤ strArr ≤ 20
 * 1 ≤ strArr의 원소의 길이 ≤ 20
 * strArr의 모든 원소는 알파벳 소문자로 이루어져 있습니다.
 * 입출력 예
 * strArr	result
 * ["AAA","BBB","CCC","DDD"]	["aaa","BBB","ccc","DDD"]
 */
public class NTest43 {
	public static void main(String[] args) {
		String[] strArr = {"AAA", "BBB", "CCC", "DDD"};
		// result ["aaa","BBB","ccc","DDD"]
		String[] solution = new Solution().solution(strArr);
		System.out.println("solution = " + Arrays.toString(solution));
	}

	static class Solution {
		public String[] solution(String[] strArr) {
			String[] answer = {};
			answer = new String[strArr.length];
			for (int i = 0; i < strArr.length; i++) {
				answer[i] = i % 2 == 0 ? strArr[i].toLowerCase() : strArr[i].toUpperCase();
			}
			return answer;
		}
	}

	/*
	class Solution {
	    public String[] solution(String[] strArr) {
	        return IntStream.range(0, strArr.length).mapToObj(i -> i % 2 == 0 ? strArr[i].toLowerCase() : strArr[i].toUpperCase()).toArray(String[]::new);
	    }
	}
	 */
}
