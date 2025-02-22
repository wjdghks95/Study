package lv_1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

/**
 * 문자열 내림차순으로 배치하기
 * 문제 설명
 * 문자열 s에 나타나는 문자를 큰것부터 작은 순으로 정렬해 새로운 문자열을 리턴하는 함수, solution을 완성해주세요.
 * s는 영문 대소문자로만 구성되어 있으며, 대문자는 소문자보다 작은 것으로 간주합니다.
 *
 * 제한 사항
 * str은 길이 1 이상인 문자열입니다.
 * 입출력 예
 * s	return
 * "Zbcdefg"	"gfedcbZ"
 */
public class Test25 {
	public static void main(String[] args) {
		String s = "Zbcdefg";
		String solution = new Solution().solution(s);
		System.out.println("solution = " + solution);
	}

	static class Solution {
		public String solution(String s) {
			String answer = "";

			answer = Arrays.stream(s.split("")).sorted(Comparator.reverseOrder()).collect(Collectors.joining());

			return answer;
		}
	}
}

/*
	class Solution {
		public String solution(String s) {
			char[] sol = s.toCharArray();
	        Arrays.sort(sol);
	        return new StringBuilder(new String(sol)).reverse().toString();
		}
	}
 */