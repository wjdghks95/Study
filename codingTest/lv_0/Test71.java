package lv_0;

import java.util.*;

/*
    소인수분해
        소인수분해란 어떤 수를 소수들의 곱으로 표현하는 것입니다.
        예를 들어 12를 소인수 분해하면 2 * 2 * 3 으로 나타낼 수 있습니다. 따라서 12의 소인수는 2와 3입니다.
        자연수 n이 매개변수로 주어질 때 n의 소인수를 오름차순으로 담은 배열을 return하도록 solution 함수를 완성해주세요.

    제한사항
    2 ≤ n ≤ 10,000
 */
public class Test71 {
    public static void main(String[] args) {
        int n = 420;
        int[] solution = new Solution().solution(n);
        System.out.println("solution = " + Arrays.toString(solution));
    }

    static class Solution {
        public int[] solution(int n) {
            int[] answer = {};
            List<Integer> arr = new ArrayList<>();
            int i = 2;
            while (n != 1) {
                if (n % i == 0) {
                    n /= i;
                    arr.add(i);
                } else {
                    i++;
                }
            }

            answer = arr.stream().distinct().mapToInt(Integer::intValue).toArray();
            return answer;
        }
    }

    /** [모범답안] */
    /*
        class Solution {
            public int[] solution(int n) {
                LinkedHashSet<Integer> primeNumbers = new LinkedHashSet<>();

                int i = 2;
                while (n != 0 && i <= n) {
                    if (n % i == 0) {
                        primeNumbers.add(i);
                        n /= i;
                    } else {
                        i++;
                    }
                }
                return primeNumbers.stream().mapToInt(Integer::intValue).toArray();
            }
        }
     */
}
