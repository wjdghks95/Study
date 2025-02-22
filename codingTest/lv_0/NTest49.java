package lv_0;

/**
 * 문자열 바꿔서 찾기
 * 문제 설명
 * 문자 "A"와 "B"로 이루어진 문자열 myString과 pat가 주어집니다.
 * myString의 "A"를 "B"로, "B"를 "A"로 바꾼 문자열의 연속하는 부분 문자열 중 pat이 있으면 1을
 * 아니면 0을 return 하는 solution 함수를 완성하세요.
 *
 * 제한사항
 * 1 ≤ myString ≤ 100
 * 1 ≤ pat ≤ 10
 * myString과 pat는 문자 "A"와 "B"로만 이루어진 문자열입니다.
 * 입출력 예
 * myString	pat	result
 * "ABBAA"	"AABB"	1
 */
public class NTest49 {
	public static void main(String[] args) {
		String myString = "ABBAA";
		String pat = "AABB";
		// result 1
		int solution = new Solution().solution(myString, pat);
		System.out.println("solution = " + solution);
	}

	static class Solution {
		public int solution(String myString, String pat) {
			int answer = 0;
			char[] chars = myString.toCharArray();
			for (int i = 0; i < chars.length; i++) {
				chars[i] = chars[i] == 'A' ? 'B' : 'A';
			}
			answer = String.valueOf(chars).contains(pat) ? 1 : 0;
			return answer;
		}
	}

	/*
	public int solution(String myString, String pat) {
        return myString.contains(Stream.of(pat.split("")).map(str -> "A".equals(str)?"B":"A").collect(Collectors.joining()))?1:0;
    }
	 */
}
