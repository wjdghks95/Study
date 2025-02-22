package lv_0;

import java.util.Arrays;
import java.util.Collections;

/**
 * 배열의 원소만큼 추가하기
 * 문제 설명
 * 아무 원소도 들어있지 않은 빈 배열 X가 있습니다.
 * 양의 정수 배열 arr가 매개변수로 주어질 때,
 * arr의 앞에서부터 차례대로 원소를 보면서 원소가 a라면 X의 맨 뒤에 a를 a번 추가하는 일을 반복한 뒤의 배열 X를 return 하는 solution 함수를 작성해 주세요.
 *
 * 제한사항
 * 1 ≤ arr의 길이 ≤ 100
 * 1 ≤ arr의 원소 ≤ 100
 * 입출력 예
 * arr	result
 * [5, 1, 4]	[5, 5, 5, 5, 5, 1, 4, 4, 4, 4]
 */
public class NTest47 {
	public static void main(String[] args) {
		int[] arr = {5, 1, 4};
		// result [5, 5, 5, 5, 5, 1, 4, 4, 4, 4]
		int[] solution = new Solution().solution(arr);
		System.out.println("solution = " + Arrays.toString(solution));
	}

	static class Solution {
		public int[] solution(int[] arr) {
			int[] answer = {};
			// answer = Arrays.stream(arr).mapToObj(i -> {
			// 	int[] intArr = new int[i];
			// 	for (int j = 0; j < i; j++) {
			// 		intArr[j] = i;
			// 	}
			// 	return intArr;
			// }).flatMapToInt(Arrays::stream).toArray();

			answer = Arrays.stream(arr).boxed().flatMap(i -> Collections.nCopies(i, i).stream()).mapToInt(i -> i).toArray();
			return answer;
		}
	}

	/*
	public List<Integer> solution(int[] arr) {
        return Arrays.stream(arr).boxed().flatMap(num -> Collections.nCopies(num, num).stream()).collect(Collectors.toList());
    }
	 */
}
