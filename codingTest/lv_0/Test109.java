package lv_0;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * 수열과 구간 쿼리 1
 * 문제 설명
 * 정수 배열 arr와 2차원 정수 배열 queries이 주어집니다. queries의 원소는 각각 하나의 query를 나타내며, [s, e] 꼴입니다.
 * 각 query마다 순서대로 s ≤ i ≤ e인 모든 i에 대해 arr[i]에 1을 더합니다.
 * 위 규칙에 따라 queries를 처리한 이후의 arr를 return 하는 solution 함수를 완성해 주세요.
 *
 * 제한사항
 * 1 ≤ arr의 길이 ≤ 1,000
 * 0 ≤ arr의 원소 ≤ 1,000,000
 * 1 ≤ queries의 길이 ≤ 1,000
 * 0 ≤ s ≤ e < arr의 길이
 * 입출력 예
 * arr	queries	result
 * [0, 1, 2, 3, 4]	[[0, 1],[1, 2],[2, 3]]	[1, 3, 4, 4, 4]
 */
public class Test109 {
    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 3, 4};
        int[][] queries = {{0, 1}, {1, 2}, {2, 3}};
        // result [1, 3, 4, 4, 4]
        int[] solution = new Solution().solution(arr, queries);
        System.out.println("solution = " + Arrays.toString(solution));
    }

    static class Solution {
        public int[] solution(int[] arr, int[][] queries) {
            int[] answer = {};
            Arrays.stream(queries).forEach(query ->
                    IntStream.rangeClosed(query[0], query[1]).forEach(i -> arr[i] += 1)
            );
            answer = arr;
            return answer;
        }
    }
}

