package lv_0;

import java.util.Arrays;

/**
 * 연속된 수의 합
 * 문제 설명
 * 연속된 세 개의 정수를 더해 12가 되는 경우는 3, 4, 5입니다.
 * 두 정수 num과 total이 주어집니다.
 * 연속된 수 num개를 더한 값이 total이 될 때, 정수 배열을 오름차순으로 담아 return하도록 solution함수를 완성해보세요.
 *
 * 제한사항
 * 1 ≤ num ≤ 100
 * 0 ≤ total ≤ 1000
 * num개의 연속된 수를 더하여 total이 될 수 없는 테스트 케이스는 없습니다.
 *
 * 입출력 예
 * num	total	result
 * 3	12	[3, 4, 5]
 * 5	15	[1, 2, 3, 4, 5]
 * 4	14	[2, 3, 4, 5]
 * 5	5	[-1, 0, 1, 2, 3]
 */
public class Test167 {
    public static void main(String[] args) {
        int num = 5;
        int total = 15;
        int[] solution = new Solution().solution(num, total);
        System.out.println("solution = " + Arrays.toString(solution));
    }

    static class Solution {
        public int[] solution(int num, int total) {
            int[] answer = {};
            int mid = total / num;
            int i = num % 2 == 0 ? mid - (num / 2 - 1) : mid - (num / 2);

            answer = new int[num];
            for (int j = 0; j < num; j++) {
                answer[j] = i;
                i++;
            }

            return answer;
        }
    }
}

/*
    class Solution {
        public int[] solution(int num, int total) {
                int[] answer = new int[num];
                int check = num*(num+1) / 2;
                int start = (total - check) / num + 1;
                for (int i = 0; i < answer.length; i++) {
                        answer[i] = start + i ;
                }
                return answer;
        }
    }
 */