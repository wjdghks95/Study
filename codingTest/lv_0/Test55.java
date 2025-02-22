package lv_0;

/*
   인덱스 바꾸기
    문자열 my_string과 정수 num1, num2가 매개변수로 주어질 때, my_string에서 인덱스 num1과 인덱스 num2에 해당하는 문자를 바꾼 문자열을 return 하도록 solution 함수를 완성해보세요.
 */
public class Test55 {
    public static void main(String[] args) {
        String my_string = "hello";
        int num1 = 1;
        int num2 = 2;
        String solution = new Solution55().solution(my_string, num1, num2);
        System.out.println("solution = " + solution);
    }
}

class Solution55 {
    public String solution(String my_string, int num1, int num2) {
        char[] chars = my_string.toCharArray();
        char temp = chars[num1];
        chars[num1] = chars[num2];
        chars[num2] = temp;

        String answer = "";
        for (char ch : chars) {
            answer += ch;
        }
        return answer;
    }
}

/* 모범답안 */
/*
class Solution {
    public String solution(String myString, int num1, int num2) {
        List<String> list = Arrays.stream(myString.split("")).collect(Collectors.toList());

        Collections.swap(list, num1, num2);
        return String.join("", list);
    }
}
*/