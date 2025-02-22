package lv_0;

/**
 * 문자열 여러 번 뒤집기
 * 문제 설명
 * 문자열 my_string과 이차원 정수 배열 queries가 매개변수로 주어집니다.
 * queries의 원소는 [s, e] 형태로, my_string의 인덱스 s부터 인덱스 e까지를 뒤집으라는 의미입니다.
 * my_string에 queries의 명령을 순서대로 처리한 후의 문자열을 return 하는 solution 함수를 작성해 주세요.
 *
 * 제한사항
 * my_string은 영소문자로만 이루어져 있습니다.
 * 1 ≤ my_string의 길이 ≤ 1,000
 * queries의 원소는 [s, e]의 형태로 0 ≤ s ≤ e < my_string의 길이를 만족합니다.
 * 1 ≤ queries의 길이 ≤ 1,000
 *
 * 입출력 예
 * my_string	queries	result
 * "rermgorpsam"	[[2, 3], [0, 7], [5, 9], [6, 10]]	"programmers"
 */
public class Test141 {
    public static void main(String[] args) {
        String my_string = "rermgorpsam";
        int[][] queries = {{2, 3}, {0, 7}, {5, 9}, {6, 10}};
        String solution = new Solution().solution(my_string, queries);
        System.out.println("solution = " + solution);
    }

    static class Solution {
        public String solution(String my_string, int[][] queries) {
            String answer = "";
            StringBuffer sb = new StringBuffer(my_string);
            for (int[] query : queries) {
                String substring = sb.substring(query[0], query[1] + 1);
                sb.replace(query[0], query[1] + 1, new StringBuffer(substring).reverse().toString());
            }
            answer = sb.toString();
            return answer;
        }
    }

    /*
    class Solution {
        public String solution(String myString, int[][] queries) {
            for (int[] arr : queries) {
                myString = myString.substring(0, arr[0]) + new StringBuilder(myString.substring(arr[0], arr[1] + 1)).reverse().toString() + myString.substring(arr[1] + 1);
            }
            return myString;
        }
    }
     */

    /*
    class Solution {
        char[] arr;
        public String solution(String my_string, int[][] queries) {
            arr = my_string.toCharArray();
            for (int[] query : queries) {
                reverse(query[0], query[1]);
            }
            return new String(arr);
        }

        private void reverse(int s, int e) {
            while (s < e) {
                char temp = arr[s];
                arr[s++] = arr[e];
                arr[e--] = temp;
            }
        }
     }
     */
}

