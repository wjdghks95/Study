package lv_0;

import java.util.Arrays;

/**
 * 순서 바꾸기
 * 문제 설명
 * 정수 리스트 num_list와 정수 n이 주어질 때,
 * num_list를 n 번째 원소 이후의 원소들과 n 번째까지의 원소들로 나눠 n 번째 원소 이후의 원소들을 n 번째까지의 원소들 앞에 붙인 리스트를 return하도록 solution 함수를 완성해주세요.
 *
 * 제한사항
 * 2 ≤ num_list의 길이 ≤ 30
 * 1 ≤ num_list의 원소 ≤ 9
 * 1 ≤ n ≤ num_list의 길이
 * 입출력 예
 * num_list	n	result
 * [2, 1, 6]	1	[1, 6, 2]
 * [5, 2, 1, 7, 5]	3	[7, 5, 5, 2, 1]
 */
public class Test98 {
    public static void main(String[] args) {
        int[] num_list = {2, 1, 6};
        int n = 1;
        // result [1, 6, 2]
        int[] solution = new Solution().solution(num_list, n);
        System.out.println("solution = " + Arrays.toString(solution));
    }

    static class Solution {
        public int[] solution(int[] num_list, int n) {
            int[] answer = {};
            int[] a = Arrays.stream(num_list).skip(n).toArray();
            int[] b = Arrays.stream(num_list).limit(n).toArray();
            answer = Arrays.asList(a, b).stream().flatMapToInt(Arrays::stream).toArray();
            return answer;
        }
    }

    /*
    class Solution {
        public int[] solution(int[] num_list, int n) {
            return IntStream.range(0, num_list.length).map(i -> num_list[(i + n) % num_list.length]).toArray();
        }
    }
     */
}

