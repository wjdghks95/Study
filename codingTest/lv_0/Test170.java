package lv_0;

/**
 * 겹치는 선분의 길이
 * 문제 설명
 * 선분 3개가 평행하게 놓여 있습니다.
 * 세 선분의 시작과 끝 좌표가 [[start, end], [start, end], [start, end]] 형태로 들어있는 2차원 배열 lines가 매개변수로 주어질 때,
 * 두 개 이상의 선분이 겹치는 부분의 길이를 return 하도록 solution 함수를 완성해보세요.
 * lines가 [[0, 2], [-3, -1], [-2, 1]]일 때 그림으로 나타내면 다음과 같습니다.
 * 선분이 두 개 이상 겹친 곳은 [-2, -1], [0, 1]로 길이 2만큼 겹쳐있습니다.
 *
 * 제한사항
 * lines의 길이 = 3
 * lines의 원소의 길이 = 2
 * 모든 선분은 길이가 1 이상입니다.
 * lines의 원소는 [a, b] 형태이며, a, b는 각각 선분의 양 끝점 입니다.
 * -100 ≤ a < b ≤ 100
 *
 * 입출력 예
 * lines	result
 * [[0, 1], [2, 5], [3, 9]]	2
 * [[-1, 1], [1, 3], [3, 9]]	0
 * [[0, 5], [3, 9], [1, 10]]	8
 */
public class Test170 {
    public static void main(String[] args) {
        int[][] lines = {{0, 1}, {2, 5}, {3, 9}};
        int solution = new Solution().solution(lines);
        System.out.println("solution = " + solution);
    }

    static class Solution {
        public int solution(int[][] lines) {
            int answer = 0;

            for (int i = -100; i <= 100; i++) {
                int count = 0;
                if (lines[0][0] <= i && i < lines[0][1]) {count++;}
                if (lines[1][0] <= i && i < lines[1][1]) {count++;}
                if (lines[2][0] <= i && i < lines[2][1]) {count++;}

                if (count > 1) {answer++;}
            }

            return answer;
        }
    }
}

/*
    class Solution {
        public int solution(int[][] lines) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int[] line : lines) {
                int from = Math.min(line[0], line[1]);
                int to = Math.max(line[0], line[1]);
                for (int i = from; i < to; i++) {
                    map.merge(i, 1, Integer::sum);
                }
            }

            return (int) map.values().stream().filter(i -> i > 1).count();
        }
    }
 */