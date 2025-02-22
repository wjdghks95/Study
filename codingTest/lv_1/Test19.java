package lv_1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 없는 숫자 더하기
 * 문제 설명
 * 0부터 9까지의 숫자 중 일부가 들어있는 정수 배열 numbers가 매개변수로 주어집니다.
 * numbers에서 찾을 수 없는 0부터 9까지의 숫자를 모두 찾아 더한 수를 return 하도록 solution 함수를 완성해주세요.
 *
 * 제한사항
 * 1 ≤ numbers의 길이 ≤ 9
 * 0 ≤ numbers의 모든 원소 ≤ 9
 * numbers의 모든 원소는 서로 다릅니다.
 *
 * 입출력 예
 * numbers	result
 * [1,2,3,4,6,7,8,0]	14
 * [5,8,4,0,6,7,9]	6
 */
public class Test19 {
	public static void main(String[] args) {
		int[] numbers = {1,2,3,4,6,7,8,0};
		int solution = new Solution().solution(numbers);
		System.out.println("solution = " +solution);
	}

	static class Solution {
		public int solution(int[] numbers) {
			int answer = 0;

			List<Integer> list = Arrays.stream(numbers).boxed().collect(Collectors.toList());
			for (int i = 0; i <= 9; i++) {
				if (list.indexOf(i) == -1) {
					answer += i;
				}
			}

			return answer;
		}
	}
}

/*
	class Solution {
	    public int solution(int[] numbers) {
	        int sum = 45;
	        for (int i : numbers) {
	            sum -= i;
	        }
	        return sum;
	    }
	}
 */