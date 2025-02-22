package lv_0;

import java.util.Arrays;

/*
    잘라서 배열로 저장하기
        문자열 my_str과 n이 매개변수로 주어질 때,
        my_str을 길이 n씩 잘라서 저장한 배열을 return하도록 solution 함수를 완성해주세요.

    제한사항
    1 ≤ my_str의 길이 ≤ 100
    1 ≤ n ≤ my_str의 길이
    my_str은 알파벳 소문자, 대문자, 숫자로 이루어져 있습니다.
 */
public class Test76 {
    public static void main(String[] args) {
        String my_str = "abc1Addfggg4556b";
        int n = 6;
        String[] solution = new Solution().solution(my_str, n);
        System.out.println("solution = " + Arrays.toString(solution));
    }

    static class Solution {
        public String[] solution(String my_str, int n) {
            String[] answer = {};
            answer = new String[(int) Math.ceil(my_str.length() / (double) n)];
            for (int i = 1; i <= answer.length; i++) {
                char[] chars = Arrays.copyOfRange(my_str.toCharArray(), (i - 1) * n, n * i);
                answer[i - 1] = String.valueOf(chars).trim();
            }
            return answer;
        }
    }

    /** 모범답안 */
    /*
        class Solution {
            public String[] solution(String my_str, int n) {
                int resultCnt = (my_str.length() + n - 1) / n;
                String[] answer = new String[resultCnt];

                for (int i = 0; i < resultCnt; i++) {
                    int start = n * i;
                    int end = start + n >= my_str.length()? my_str.length(): start + n;
                    answer[i] = my_str.substring(start, end);
                }

                return answer;
            }
        }

        class Solution {
            public String[] solution(String myStr, int n) {
                return IntStream.range(0, myStr.length() / n + (myStr.length() % n > 0 ? 1 : 0))
                        .mapToObj(i -> i == myStr.length() / n ? myStr.substring(i * n) : myStr.substring(i * n, (i + 1) * n))
                        .toArray(String[]::new);
            }
        }
     */
}
