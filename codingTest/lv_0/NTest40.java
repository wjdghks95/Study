package lv_0;

/**
 * 접두사인지 확인하기
 * 문제 설명
 * 어떤 문자열에 대해서 접두사는 특정 인덱스까지의 문자열을 의미합니다.
 * 예를 들어, "banana"의 모든 접두사는 "b", "ba", "ban", "bana", "banan", "banana"입니다.
 * 문자열 my_string과 is_prefix가 주어질 때, is_prefix가 my_string의 접두사라면 1을, 아니면 0을 return 하는 solution 함수를 작성해 주세요.
 *
 * 제한사항
 * 1 ≤ my_string의 길이 ≤ 100
 * 1 ≤ is_prefix의 길이 ≤ 100
 * my_string과 is_prefix는 영소문자로만 이루어져 있습니다.
 * 입출력 예
 * my_string	is_prefix	result
 * ""banana	"ban"	1
 */
public class NTest40 {
	public static void main(String[] args) {
		String my_string = "banana";
		String is_prefix = "ban";
		// result 1
		int solution = new Solution().solution(my_string, is_prefix);
		System.out.println("solution = " + solution);
	}

	static class Solution {
		public int solution(String my_string, String is_prefix) {
			int answer = 0;
			answer = my_string.indexOf(is_prefix) == 0 ? 1 : 0;
			return answer;
		}
	}

	/*
	class Solution {
	    public int solution(String my_string, String is_prefix) {
	        if (my_string.startsWith(is_prefix)) return 1;
	        return 0;
	    }
	}
	 */
}
