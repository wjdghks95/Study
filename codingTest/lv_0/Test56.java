package lv_0;

/*
    외계행성의 나이
        우주여행을 하던 머쓱이는 엔진 고장으로 PROGRAMMERS-962 행성에 불시착하게 됐습니다.
        입국심사에서 나이를 말해야 하는데, PROGRAMMERS-962 행성에서는 나이를 알파벳으로 말하고 있습니다.
        a는 0, b는 1, c는 2, ..., j는 9입니다. 예를 들어 23살은 cd, 51살은 fb로 표현합니다.
        나이 age가 매개변수로 주어질 때 PROGRAMMER-962식 나이를 return하도록 solution 함수를 완성해주세요.
 */
public class Test56 {
    public static void main(String[] args) {
        int age = 23;
        String solution = new Solution56().solution(age);
        System.out.println("solution = " + solution);
    }
}

class Solution56 {
    public String solution(int age) {
        String answer = "";
        char arr[] = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j'};

        String str = String.valueOf(age);
        char[] chars = str.toCharArray();
        for (char c : chars) {
            answer += arr[Character.getNumericValue(c)];
        }
        return answer;
    }
}

/*
    모범답안
 */
/*
class Solution {
    public String solution(int age) {
        return String.valueOf(age).chars().mapToObj(operand -> String.valueOf((char) (49 + operand))).collect(Collectors.joining());
    }
}
*/
