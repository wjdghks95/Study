package lv_0;

import java.util.HashSet;
import java.util.Set;

/**
 * 유한소수 판별하기
 * 문제 설명
 * 소수점 아래 숫자가 계속되지 않고 유한개인 소수를 유한소수라고 합니다.
 * 분수를 소수로 고칠 때 유한소수로 나타낼 수 있는 분수인지 판별하려고 합니다.
 * 유한소수가 되기 위한 분수의 조건은 다음과 같습니다.
 * 기약분수로 나타내었을 때, 분모의 소인수가 2와 5만 존재해야 합니다.
 * 두 정수 a와 b가 매개변수로 주어질 때, a/b가 유한소수이면 1을, 무한소수라면 2를 return하도록 solution 함수를 완성해주세요.
 *
 * 제한사항
 * a, b는 정수
 * 0 < a ≤ 1,000
 * 0 < b ≤ 1,000
 *
 * 입출력 예
 * a	b	result
 * 7	20	1
 * 11	22	1
 * 12   21  2
 */
public class Test153 {
    public static void main(String[] args) {
        int a = 7;
        int b = 20;
        int solution = new Solution().solution(a, b);
        System.out.println("solution = " + solution);
    }

    static class Solution {
        public int solution(int a, int b) {
            int answer = 0;

            if (a % b == 0) {
                return 1;
            }

            int g = 0;
            int max = a > b ? a : b;
            for (int i = 1; i <= max; i++) {
                if (a % i == 0 && b % i == 0) {
                    g = i;
                }
            }

            int denominator = b / g;

            Set<Integer> set = new HashSet<>();
            for (int i = 2; i <= denominator; i++) {
                while (denominator % i == 0) {
                    denominator /= i;
                    set.add(i);
                }
            }

            answer = 1;
            for (Integer i : set) {
                if (i != 2 && i != 5) {
                    answer = 2;
                    break;
                }
            }

            return answer;
        }
    }
}

/*
    class Solution {
        public int solution(int a, int b) {
            int answer = 0;

            for (;b%2 == 0;) {
                b = b/2;
            }
            for (;b%5 == 0;) {
                b = b/5;
            }

            if ((a/(double)b)%1 == 0) {
                answer = 1;
            } else {
                answer = 2;
            }

            return answer;
        }
    }
 */