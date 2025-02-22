package lv_1;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 자연수 뒤집어 배열로 만들기
 * 문제 설명
 * 자연수 n을 뒤집어 각 자리 숫자를 원소로 가지는 배열 형태로 리턴해주세요.
 * 예를들어 n이 12345이면 [5,4,3,2,1]을 리턴합니다.
 *
 * 제한 조건
 * n은 10,000,000,000이하인 자연수입니다.
 * 입출력 예
 * n	return
 * 12345	[5,4,3,2,1]
 */
public class Test7 {
	public static void main(String[] args) {
		long n = 12345;
		int[] solution = new Solution().solution(n);
		System.out.println("solution = " + Arrays.toString(solution));
	}

	static class Solution {
		public int[] solution(long n) {
			int[] answer = {};

			List<Integer> list = Arrays.stream(String.valueOf(n).split("")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
			Collections.reverse(list);
			answer = list.stream().mapToInt(Integer::intValue).toArray();

			return answer;
		}
	}
}

/*
	class Solution {
	    public int[] solution(long n) {
	        return new StringBuilder().append(n).reverse().chars().map(Character::getNumericValue).toArray();
	    }
	}
 */