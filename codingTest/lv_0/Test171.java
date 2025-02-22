package lv_0;

/**
 * 평행
 * 문제 설명
 * 점 네 개의 좌표를 담은 이차원 배열  dots가 다음과 같이 매개변수로 주어집니다.
 * [[x1, y1], [x2, y2], [x3, y3], [x4, y4]]
 * 주어진 네 개의 점을 두 개씩 이었을 때, 두 직선이 평행이 되는 경우가 있으면 1을 없으면 0을 return 하도록 solution 함수를 완성해보세요.
 *
 * 제한사항
 * dots의 길이 = 4
 * dots의 원소는 [x, y] 형태이며 x, y는 정수입니다.
 * 0 ≤ x, y ≤ 100
 * 서로 다른 두개 이상의 점이 겹치는 경우는 없습니다.
 * 두 직선이 겹치는 경우(일치하는 경우)에도 1을 return 해주세요.
 * 임의의 두 점을 이은 직선이 x축 또는 y축과 평행한 경우는 주어지지 않습니다.
 *
 * 입출력 예
 * dots	result
 * [[1, 4], [9, 2], [3, 8], [11, 6]]	1
 * [[3, 5], [4, 1], [2, 4], [5, 10]]	0
 */
public class Test171 {
    public static void main(String[] args) {
        int[][] dots = {{1, 4}, {9, 2}, {3, 8}, {11, 6}};
        int solution = new Solution().solution(dots);
        System.out.println("solution = " + solution);
    }

    static class Solution {
        public int solution(int[][] dots) {
            int answer = 0;

            /**
             * 기울기 공식
             * m = (y2-y1) / (x2-x1)
             */

            double line_01 = (dots[0][1] - dots[1][1]) / (double) (dots[0][0] - dots[1][0]);
            double line_23 = (dots[2][1] - dots[3][1]) / (double) (dots[2][0] - dots[3][0]);
            if (line_01 == line_23) answer = 1;

            double line_02 = (dots[0][1] - dots[2][1]) / (double) (dots[0][0] - dots[2][0]);
            double line_13 = (dots[1][1] - dots[3][1]) / (double) (dots[1][0] - dots[3][0]);
            if (line_02 == line_13) answer = 1;

            double line_03 = (dots[0][1] - dots[3][1]) / (double) (dots[0][0] - dots[3][0]);
            double line_12 = (dots[1][1] - dots[2][1]) / (double) (dots[1][0] - dots[2][0]);
            if (line_03 == line_12) answer = 1;

            return answer;
        }
    }
}