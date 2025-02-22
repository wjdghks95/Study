package lv_0;

import java.util.Arrays;

/**
 * 정수를 나선형으로 배치하기
 * 문제 설명
 * 양의 정수 n이 매개변수로 주어집니다.
 * n × n 배열에 1부터 n2 까지 정수를 인덱스 [0][0]부터 시계방향 나선형으로 배치한 이차원 배열을 return 하는 solution 함수를 작성해 주세요.
 *
 * 제한사항
 * 1 ≤ n ≤ 30
 *
 * 입출력 예
 * n	result
 * 4	[[1, 2, 3, 4], [12, 13, 14, 5], [11, 16, 15, 6], [10, 9, 8, 7]]
 * 5	[[1, 2, 3, 4, 5], [16, 17, 18, 19, 6], [15, 24, 25, 20, 7], [14, 23, 22, 21, 8], [13, 12, 11, 10, 9]]
 */
public class Test172 {
    public static void main(String[] args) {
        int n = 5;
        int[][] solution = new Solution().solution(n);
        System.out.println("solution = " + Arrays.deepToString(solution));
    }

    static class Solution {
        public int[][] solution(int n) {
            int[][] answer = {};

            answer = new int[n][n];

            int[] position = {0, 0};
            int[][] direct = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
            
            int index = 0;
            
            for (int i = 1; i <= n * n; i++) {
                answer[position[0]][position[1]] = i;

                position[0] = position[0] + direct[index % 4][0];
                position[1] = position[1] + direct[index % 4][1];

                if (position[0] < 0 || position[1] < 0 || position[0] >= n || position[1] >= n || answer[position[0]][position[1]] != 0) {
                    index++;
                    position[0] = position[0] + direct[(index+1) % 4][0];
                    position[1] = position[1] + direct[(index+1) % 4][1];

                    position[0] = position[0] + direct[index % 4][0];
                    position[1] = position[1] + direct[index % 4][1];
                }
            }

            return answer;
        }
    }
}

/*
    class Solution {
        public int[][] solution(int n) {
            int[][] array = new int[n][n];
            int num = 1;
            int rowStart = 0;
            int rowEnd = n - 1;
            int colStart = 0;
            int colEnd = n - 1;

            while (rowStart <= rowEnd && colStart <= colEnd) {
                // 왼쪽에서 오른쪽으로
                for (int i = colStart; i <= colEnd; i++) {
                    array[rowStart][i] = num++;
                }
                rowStart++;

                // 위에서 아래로
                for (int i = rowStart; i <= rowEnd; i++) {
                    array[i][colEnd] = num++;
                }
                colEnd--;

                // 오른쪽에서 왼쪽으로
                for (int i = colEnd; i >= colStart; i--) {
                    array[rowEnd][i] = num++;
                }
                rowEnd--;

                // 아래에서 위로
                for (int i = rowEnd; i >= rowStart; i--) {
                    array[i][colStart] = num++;
                }
                colStart++;
            }
            return array;
        }
    }
 */