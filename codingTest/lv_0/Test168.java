package lv_0;

import java.util.HashMap;

/**
 * 주사위 게임 3
 * 문제 설명
 * 1부터 6까지 숫자가 적힌 주사위가 네 개 있습니다. 네 주사위를 굴렸을 때 나온 숫자에 따라 다음과 같은 점수를 얻습니다.
 *
 * 네 주사위에서 나온 숫자가 모두 p로 같다면 1111 × p점을 얻습니다.
 * 세 주사위에서 나온 숫자가 p로 같고 나머지 다른 주사위에서 나온 숫자가 q(p ≠ q)라면 (10 × p + q)2 점을 얻습니다.
 * 주사위가 두 개씩 같은 값이 나오고, 나온 숫자를 각각 p, q(p ≠ q)라고 한다면 (p + q) × |p - q|점을 얻습니다.
 * 어느 두 주사위에서 나온 숫자가 p로 같고 나머지 두 주사위에서 나온 숫자가 각각 p와 다른 q, r(q ≠ r)이라면 q × r점을 얻습니다.
 * 네 주사위에 적힌 숫자가 모두 다르다면 나온 숫자 중 가장 작은 숫자 만큼의 점수를 얻습니다.
 * 네 주사위를 굴렸을 때 나온 숫자가 정수 매개변수 a, b, c, d로 주어질 때, 얻는 점수를 return 하는 solution 함수를 작성해 주세요.
 *
 * 제한사항
 * a, b, c, d는 1 이상 6 이하의 정수입니다.
 *
 * 입출력 예
 * a	b	c	d	result
 * 2	2	2	2	2222
 * 4	1	4	4	1681
 * 6	3	3	6	27
 * 2	5	2	6	30
 * 6	4	2	5	2
 */
public class Test168 {
    public static void main(String[] args) {
        int a = 2;
        int b = 5;
        int c = 2;
        int d = 6;
        int solution = new Solution().solution(a, b, c, d);
        System.out.println("solution = " + solution);
    }

    static class Solution {
        public int solution(int a, int b, int c, int d) {
            int answer = 0;
            int[] ints = new int[]{a, b, c, d};
            HashMap<Integer, Integer> map = new HashMap<>();

            for (int i : ints) {
                int count = 0;
                if (map.get(i) != null) {
                    count = map.get(i);
                }

                map.put(i, ++count);
            }

            if (map.size() == 1) {
                answer = 1111 * a;
            } else if (map.size() == 2) {
                int p = 0, q = 0;
                if (map.containsValue(3)) {
                    for (Integer key : map.keySet()) {
                        if (map.get(key) == 3) {
                            p = key;
                        } else {
                            q = key;
                        }
                    }
                    answer = (int) Math.pow(10 * p + q, 2);
                }
                if (map.containsValue(2)) {
                    for (Integer key : map.keySet()) {
                        if (map.get(key) == 2) {
                            if (p == 0) {
                                p = key;
                            } else {
                                q = key;
                            }
                        }
                    }
                    answer = (p + q) * Math.abs(p - q);
                }

            } else if (map.size() == 3) {
                int q = 0, r = 0;
                for (Integer key : map.keySet()) {
                    if (map.get(key) == 1) {
                        if (q == 0) {
                            q = key;
                        } else {
                            r = key;
                        }
                    }
                }
                answer = q * r;
            } else {
                answer = map.keySet().stream().mapToInt(Integer::intValue).min().getAsInt();
            }

            return answer;
        }
    }

}

/*
    class Solution {
        public int solution(int a, int b, int c, int d) {

            int[] dice = { a, b, c, d };
            Arrays.sort(dice);

            int ans = 0;

            if (dice[0] == dice[3]) {
                ans = 1111 * dice[3];
            } else if (dice[0] == dice[2] || dice[1] == dice[3]) {
                ans = (int) Math.pow(dice[1] * 10 + (dice[0] + dice[3] - dice[1]), 2);
            } else if (dice[0] == dice[1] && dice[2] == dice[3]) {
                ans = (dice[0] + dice[3]) * (dice[3] - dice[0]);
            } else if (dice[0] == dice[1]) {
                ans = dice[2] * dice[3];
            } else if (dice[1] == dice[2]) {
                ans = dice[0] * dice[3];
            } else if (dice[2] == dice[3]) {
                ans = dice[0] * dice[1];
            } else {
                ans = dice[0];
            }

            return ans;
        }
    }
 */