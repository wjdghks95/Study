package lv_0;

/**
 * l로 만들기
 * 문제 설명
 * 알파벳 소문자로 이루어진 문자열 myString이 주어집니다.
 * 알파벳 순서에서 "l"보다 앞서는 모든 문자를 "l"로 바꾼 문자열을 return 하는 solution 함수를 완성해 주세요.
 *
 * 제한사항
 * 1 ≤ myString ≤ 100,000
 * myString은 알파벳 소문자로 이루어진 문자열입니다.
 * 입출력 예
 * myString	result
 * "abcdevwxyz"	"lllllvwxyz"
 * "jjnnllkkmm"	"llnnllllmm"
 */
public class Test88 {
    public static void main(String[] args) {
        String myString = "abcdevwxyz";
        // result "lllllvwxyz"
        String solution = new Solution().solution(myString);
        System.out.println("solution = " + solution);
    }

    static class Solution {
        public String solution(String myString) {
            String answer = "";
            char[] chars = myString.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] < 'l') {
                    chars[i] = 'l';
                }
            }
            answer = String.valueOf(chars);
            return answer;
        }
    }

    /*
    class Solution {
        public String solution(String myString) {
            return myString.replaceAll("[^l-z]", "l");
        }
    }
     */
}
