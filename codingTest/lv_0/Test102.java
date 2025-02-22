package lv_0;

import java.util.Arrays;

/**
 * 특별한 이차원 배열 1
 * 문제 설명
 * 정수 n이 매개변수로 주어질 때, 다음과 같은 n × n 크기의 이차원 배열 arr를 return 하는 solution 함수를 작성해 주세요.
 * arr[i][j] (0 ≤ i, j < n)의 값은 i = j라면 1, 아니라면 0입니다.
 *
 * 제한사항
 * 1 ≤ n ≤ 100
 * 입출력 예
 * n	result
 * 3	[[1, 0, 0], [0, 1, 0], [0, 0, 1]]
 * 6	[[1, 0, 0, 0, 0, 0], [0, 1, 0, 0, 0, 0], [0, 0, 1, 0, 0, 0], [0, 0, 0, 1, 0, 0], [0, 0, 0, 0, 1, 0], [0, 0, 0, 0, 0, 1]]
 */
public class Test102 {
    public static void main(String[] args) {
        int a = 3;
        // result [[1, 0, 0], [0, 1, 0], [0, 0, 1]]
        int[][] solution = new Solution().solution(a);
        System.out.println("solution = " + Arrays.deepToString(solution));
    }

    static class Solution {
        public int[][] solution(int n) {
            int[][] answer = {};
            answer = new int[n][n];
            for (int i = 0; i < answer.length; i++) {
                Arrays.fill(answer[i], 0);
                answer[i][i] = 1;
            }
            return answer;
        }
    }

    /*
    class Solution {
        public int[][] solution(int n) {
            int[][] answer = new int[n][n];
            for(int i = 0 ; i < n ; i++) {
                answer[i][i] = 1;
            }
            return answer;
        }
    }
     */
}

