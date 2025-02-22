package lv_0;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 열 만들기 2
 * 문제 설명
 * 정수 l과 r이 주어졌을 때, l 이상 r이하의 정수 중에서 숫자 "0"과 "5"로만 이루어진 모든 정수를 오름차순으로 저장한 배열을 return 하는 solution 함수를 완성해 주세요.
 * 만약 그러한 정수가 없다면, -1이 담긴 배열을 return 합니다.
 *
 * 제한사항
 * 1 ≤ l ≤ r ≤ 1,000,000
 *
 * 입출력 예
 * l	r	result
 * 5	555	[5, 50, 55, 500, 505, 550, 555]
 * 10	20	[-1]
 */
public class Test158 {
    public static void main(String[] args) {
        int l = 5;
        int r = 555;
        int[] solution = new Solution().solution(l, r);
        System.out.println("solution = " + Arrays.toString(solution));
    }

    static class Solution {
        public int[] solution(int l, int r) {
            int[] answer = {};
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = l; i <= r; i++) {
                char[] chars = String.valueOf(i).toCharArray();

                boolean bool = true;
                for (char c : chars) {
                    if (c != '5' && c != '0') {
                        bool = false;
                    }
                }

                if (bool) {
                    list.add(i);
                }
            }
            answer = list.size() == 0 ? new int[]{-1} : list.stream().mapToInt(Integer::intValue).toArray();
            return answer;
        }
    }
}

/*
    class Solution {
        public int[] solution(int l, int r) {

            ArrayList<Integer> list = new ArrayList<>();

            for (int i = 1; i < 64; i++) {
                int num = Integer.parseInt(Integer.toBinaryString(i)) * 5;
                if (l <= num && num <= r)
                    list.add(num);
            }

            return list.isEmpty() ? new int[] { -1 } : list.stream().mapToInt(i -> i).toArray();
        }
    }
 */

/*
    class Solution {
        public int[] solution(int l, int r) {
            int[] answer = IntStream.rangeClosed(l, r).filter(i -> {
                while (i > 0) {
                    if (i % 5 != 0) return false;
                    i /= 10;
                }
                return true;
            }).toArray();

            return answer.length == 0 ? new int[]{-1} : answer;
        }
    }
 */