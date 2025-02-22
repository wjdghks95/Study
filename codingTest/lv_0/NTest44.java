package lv_0;

import java.util.Arrays;

/**
 * 배열의 길이에 따라 다른 연산하기
 * 문제 설명
 * 정수 배열 arr과 정수 n이 매개변수로 주어집니다.
 * arr의 길이가 홀수라면 arr의 모든 짝수 인덱스 위치에 n을 더한 배열을,
 * arr의 길이가 짝수라면 arr의 모든 홀수 인덱스 위치에 n을 더한 배열을 return 하는 solution 함수를 작성해 주세요.
 *
 * 제한사항
 * 1 ≤ arr의 길이 ≤ 1,000
 * 1 ≤ arr의 원소 ≤ 1,000
 * 1 ≤ n ≤ 1,000
 * 입출력 예
 * arr	n	result
 * [49, 12, 100, 276, 33]	27	[76, 12, 127, 276, 60]
 */
public class NTest44 {
	public static void main(String[] args) {
		int[] arr = {49, 12, 100, 276, 33};
		int n = 27;
		// result [76, 12, 127, 276, 60]
		int[] solution = new Solution().solution(arr, n);
		System.out.println("solution = " + Arrays.toString(solution));
	}

	static class Solution {
		public int[] solution(int[] arr, int n) {
			int[] answer = {};
			if (arr.length % 2 != 0) {
				for (int i = 0; i < arr.length; i += 2) {
					arr[i] += n;
				}
			} else {
				for (int i = 1; i < arr.length; i += 2) {
					arr[i] += n;
				}
			}

			return answer = arr;
		}
	}

	/*
	public int[] solution(int[] arr, int n) {
        IntStream.iterate((arr.length + 1) % 2, i -> i < arr.length, i -> i + 2)
                .forEach(i -> arr[i] += n);
        return arr;
    }
	 */
}
