package lv_0;

/**
 * 문자열이 몇 번 등장하는지 세기
 * 문제 설명
 * 문자열 myString과 pat이 주어집니다. myString에서 pat이 등장하는 횟수를 return 하는 solution 함수를 완성해 주세요.
 *
 * 제한사항
 * 1 ≤ myString ≤ 1000
 * 1 ≤ pat ≤ 10
 *
 * 입출력 예
 * myString	pat	result
 * "banana"	"ana"	2
 * "aaaa"	"aa"	3
 */
public class Test120 {
    public static void main(String[] args) {
        String myString = "banana";
        String pat = "ana";
        // result 2
        int solution = new Solution().solution(myString, pat);
        System.out.println("solution = " + solution);
    }

    static class Solution {
        public int solution(String myString, String pat) {
            int answer = 0;
            for (int i = 0; i < myString.length(); i++) {
                if (myString.substring(i).startsWith(pat)) {
                    answer++;
                }
            }
            return answer;
        }
    }

    /*
    class Solution {
        public int solution(String myString, String pat) {
            return (int) Stream.iterate(0, i -> i + 1)
                .limit(myString.length() - pat.length() + 1)
                .filter(i -> myString.substring(i, i + pat.length()).equals(pat))
                .count();
        }
    }
     */
}

