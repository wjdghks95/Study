package lv_0;

import java.util.Arrays;

/**
 * 문자 개수 세기
 * 문제 설명
 * 알파벳 대소문자로만 이루어진 문자열 my_string이 주어질 때,
 * my_string에서 'A'의 개수, my_string에서 'B'의 개수,..., my_string에서 'Z'의 개수,
 * my_string에서 'a'의 개수, my_string에서 'b'의 개수,..., my_string에서 'z'의 개수를
 * 순서대로 담은 길이 52의 정수 배열을 return 하는 solution 함수를 작성해 주세요.
 *
 * 제한사항
 * 1 ≤ my_string의 길이 ≤ 1,000
 *
 * 입출력 예
 * my_string	 result
 * "Programmers" [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 2, 0, 1, 0, 0, 3, 1, 0, 0, 0, 0, 0, 0, 0]
 */
public class Test129 {
    public static void main(String[] args) {
        String my_string = "Programmers";
        int[] solution = new Solution().solution(my_string);
        System.out.println("solution = " + Arrays.toString(solution));
    }

    static class Solution {
        public int[] solution(String my_string) {
            int[] answer = {};
            answer = new int[52];
            for (int i = 0; i < my_string.length(); i++) {
                int j = my_string.charAt(i);
                if (j <= 90) {
                    answer[j - 65] += 1;
                } else {
                    answer[j - 97 + 26] += 1;
                }
            }

            return answer;
        }
    }

    /*
   class Solution {
        public int[] solution(String my_string) {
            return IntStream.concat(IntStream.concat(my_string.chars(), IntStream.rangeClosed('A', 'Z')), IntStream.rangeClosed('a', 'z'))
                    .mapToObj(Character::toString)
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                    .values().stream()
                    .mapToInt(i ->  i.intValue() - 1)
                    .toArray();
        }
    }
     */
}

