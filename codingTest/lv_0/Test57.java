package lv_0;

import java.util.stream.Collectors;

/*
    문자열 정렬하기 (2)
        영어 대소문자로 이루어진 문자열 my_string이 매개변수로 주어질 때,
        my_string을 모두 소문자로 바꾸고 알파벳 순서대로 정렬한 문자열을 return 하도록 solution 함수를 완성해보세요.
 */
public class Test57 {
    public static void main(String[] args) {
        String my_string = "Bcad";
        String solution = new Solution57().solution(my_string);
        System.out.println("solution = " + solution);
    }
}

class Solution57 {
    public String solution(String my_string) {
        String answer = "";
        String str = my_string.toLowerCase();
        answer += str.chars().mapToObj(c -> String.valueOf((char) c)).sorted().collect(Collectors.joining());

        return answer;
    }
}

/*
    모범답안
 */
/*
class Solution {
    public String solution(String my_string) {
        char[] c = my_string.toLowerCase().toCharArray();
        Arrays.sort(c);
        return new String(c);
    }
}
*/
