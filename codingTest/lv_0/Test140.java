package lv_0;

import java.util.Arrays;

/**
 * 왼쪽 오른쪽
 * 문제 설명
 * 문자열 리스트 str_list에는 "u", "d", "l", "r" 네 개의 문자열이 여러 개 저장되어 있습니다.
 * str_list에서 "l"과 "r" 중 먼저 나오는 문자열이 "l"이라면 해당 문자열을 기준으로 왼쪽에 있는 문자열들을 순서대로 담은 리스트를,
 * 먼저 나오는 문자열이 "r"이라면 해당 문자열을 기준으로 오른쪽에 있는 문자열들을 순서대로 담은 리스트를 return하도록 solution 함수를 완성해주세요.
 * "l"이나 "r"이 없다면 빈 리스트를 return합니다.
 *
 * 제한사항
 * 1 ≤ str_list의 길이 ≤ 20
 * str_list는 "u", "d", "l", "r" 네 개의 문자열로 이루어져 있습니다.
 *
 * 입출력 예
 * str_list	result
 * ["u", "u", "l", "r"]	["u", "u"]
 * ["l"]	[]
 */
public class Test140 {
    public static void main(String[] args) {
        String[] str_list = {"r"};
        String[] solution = new Solution().solution(str_list);
        System.out.println("solution = " + Arrays.toString(solution));
    }

    static class Solution {
        public String[] solution(String[] str_list) {
            String[] answer = {};

            for (int i = 0; i < str_list.length; i++) {
                if (str_list[i].equals("l")) {
                    answer = Arrays.copyOfRange(str_list, 0, i);
                    break;
                } else if (str_list[i].equals("r")) {
                    answer = Arrays.copyOfRange(str_list, i + 1, str_list.length);
                    break;
                }
            }
            return answer;
        }
    }

    /*
    class Solution {
        public String[] solution(String[] str_list) {
            return IntStream.range(0, str_list.length)
                    .boxed()
                    .filter(i -> str_list[i].equals("l") || str_list[i].equals("r"))
                    .findFirst()
                    .map(i -> {
                        if (str_list[i].equals("l")) {
                            return Arrays.copyOfRange(str_list, 0, i);
                        }
                        return Arrays.copyOfRange(str_list, i + 1, str_list.length);
                    })
                    .orElseGet(() -> new String[]{});
        }
    }
     */
}

