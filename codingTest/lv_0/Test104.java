package lv_0;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * 등차수열의 특정한 항만 더하기
 * 문제 설명
 * 두 정수 a, d와 길이가 n인 boolean 배열 included가 주어집니다.
 * 첫째항이 a, 공차가 d인 등차수열에서 included[i]가 i + 1항을 의미할 때,
 * 이 등차수열의 1항부터 n항까지 included가 true인 항들만 더한 값을 return 하는 solution 함수를 작성해 주세요.
 *
 * 제한사항
 * 1 ≤ a ≤ 100
 * 1 ≤ d ≤ 100
 * 1 ≤ included의 길이 ≤ 100
 * included에는 true가 적어도 하나 존재합니다.
 * 입출력 예
 * a	d	included	result
 * 3	4	[true, false, false, true, true]	37
 * 7	1	[false, false, false, true, false, false, false]	10
 */
public class Test104 {
    public static void main(String[] args) {
        int a = 3;
        int d = 4;
        boolean[] included = {true, false, false, true, true}; // [3, 7, 11, 15, 19]
        // result 37
        int solution = new Solution().solution(a, d, included);
        System.out.println("solution = " +solution);
    }

    static class Solution {
        public int solution(int a, int d, boolean[] included) {
            int answer = 0;
            int[] ints = IntStream.iterate(a, i -> i + d).limit(included.length).toArray();
            answer = Arrays.stream(IntStream.iterate(0, i -> i < included.length, i -> i + 1).filter(i -> included[i]).map(i -> ints[i]).toArray()).sum();
            return answer;
        }
    }

    /*
    class Solution {
        public int solution(int a, int d, boolean[] included) {
            return IntStream.range(0, included.length).map(idx -> included[idx]?a+(idx*d):0).sum();
        }
    }
     */
}

