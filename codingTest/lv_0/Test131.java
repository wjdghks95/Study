package lv_0;

import java.math.BigInteger;

/**
 * 구슬을 나누는 경우의 수
 * 문제 설명
 * 머쓱이는 구슬을 친구들에게 나누어주려고 합니다.
 * 구슬은 모두 다르게 생겼습니다.
 * 머쓱이가 갖고 있는 구슬의 개수 balls와 친구들에게 나누어 줄 구슬 개수 share이 매개변수로 주어질 때,
 * balls개의 구슬 중 share개의 구슬을 고르는 가능한 모든 경우의 수를 return 하는 solution 함수를 완성해주세요.
 *
 * 제한사항
 * 1 ≤ balls ≤ 30
 * 1 ≤ share ≤ 30
 * 구슬을 고르는 순서는 고려하지 않습니다.
 * share ≤ balls
 *
 * 입출력 예
 * balls	share	result
 * 3	2	3
 *
 * 공식
 * n! / (n-m)! * m!
 */
public class Test131 {
    public static void main(String[] args) {
        int balls = 5;
        int share = 3;
        BigInteger solution = new Solution().solution(balls, share);
        System.out.println("solution = " + solution);
    }

    static class Solution {
        public BigInteger solution(int balls, int share) {
            BigInteger answer = loop(balls).divide(loop(balls - share).multiply(loop(share)));
            return answer;
        }

        public BigInteger loop(int i) {
            BigInteger bigInt = BigInteger.valueOf(1);
            for (int j = i; j > 1; j--) {
                bigInt = bigInt.multiply(BigInteger.valueOf(j));
            }
            return bigInt;
        }
    }

    /*
    class Solution {
        public long solution(int balls, int share) {
            share = Math.min(balls - share, share);

            if (share == 0)
                return 1;

            long result = solution(balls - 1, share - 1);
            result *= balls;
            result /= share;

            return result;
        }
    }
     */
}

