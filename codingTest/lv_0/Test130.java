package lv_0;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * 2의 영역
 * 문제 설명
 * 정수 배열 arr가 주어집니다. 배열 안의 2가 모두 포함된 가장 작은 연속된 부분 배열을 return 하는 solution 함수를 완성해 주세요.
 * 단, arr에 2가 없는 경우 [-1]을 return 합니다.
 *
 * 제한사항
 * 1 ≤ arr의 길이 ≤ 100,000
 * 1 ≤ arr의 원소 ≤ 10
 *
 * 입출력 예
 * arr	result
 * [1, 2, 1, 4, 5, 2, 9]	[2, 1, 4, 5, 2]
 */
public class Test130 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 4, 5, 2, 9};
        int[] solution = new Solution().solution(arr);
        System.out.println("solution = " + Arrays.toString(solution));
    }

    static class Solution {
        public int[] solution(int[] arr) {
            int[] answer = {};
            int[] ints = IntStream.range(0, arr.length).filter(i -> arr[i] == 2).toArray();
            if (ints.length == 0) {
                answer = new int[1];
                answer[0] = -1;
            } else {
                answer = IntStream.rangeClosed(ints[0], ints[ints.length-1]).map(i -> arr[i]).toArray();
            }

            return answer;
        }
    }

    /*
    class Solution {
        public List<Integer> solution(int[] arr) {
            List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
            return list.contains(2) ? list.subList(list.indexOf(2), list.lastIndexOf(2) + 1) : Arrays.asList(-1);
        }
    }
     */
}

