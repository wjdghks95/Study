package lv_0;

/**
 * flag에 따라 다른 값 반환하기
 * 문제 설명
 * 두 정수 a, b와 boolean 변수 flag가 매개변수로 주어질 때,
 * flag가 true면 a + b를 false면 a - b를 return 하는 solution 함수를 작성해 주세요.
 *
 * 제한사항
 * -1000 ≤ a, b ≤ 1,000
 */
public class NTest26 {
	public static void main(String[] args) {
		int a = -4;
		int b = 7;
		boolean flag = true;
		// result 3
		int solution = new Solution().solution(a, b, flag);
		System.out.println("solution = " + solution);
	}

	static class Solution {
		public int solution(int a, int b, boolean flag) {
			int answer = 0;
			if (flag) {
				answer = a + b;
			} else {
				answer = a - b;
			}
			return answer;
		}
	}

	/*
	class Solution {
	    public int solution(int a, int b, boolean flag) {
	        return flag ? a + b : a - b;
	    }
	}
	 */
}
