package lv_0;

/*
    숨어있는 숫자의 덧셈 (2)
        문자열 my_string이 매개변수로 주어집니다.
        my_string은 소문자, 대문자, 자연수로만 구성되어있습니다.
        my_string안의 자연수들의 합을 return하도록 solution 함수를 완성해주세요.

    제한사항
    1 ≤ my_string의 길이 ≤ 1,000
    1 ≤ my_string 안의 자연수 ≤ 1000
    연속된 수는 하나의 숫자로 간주합니다.
    000123과 같이 0이 선행하는 경우는 없습니다.
    문자열에 자연수가 없는 경우 0을 return 해주세요.
 */
public class Test69 {
    public static void main(String[] args) {
        String my_string = "10101010";
        int solution = new Solution69().solution(my_string);
        System.out.println("solution = " + solution);
    }
}

class Solution69 {
    public int solution(String my_string) {
        int answer = 0;
        char[] array = my_string.toCharArray();
        String str = "";
        int i = 0;
        while (i < array.length) {
            if ((int) array[i] > 47 && (int) array[i] <= 57) {
                str += array[i];
                i++;
            } else {
                str += " ";
                i++;
            }
        }
        String[] split = str.split(" ");
        for (String s : split) {
            if (!s.equals("")) {
                answer +=  Integer.parseInt(s);
            }
        }

        return answer;
    }
}

/*
    모범답안
 */
/*
class Solution {
    public int solution(String my_string) {
        int answer = 0;

        String[] str = my_string.replaceAll("[a-zA-Z]", " ").split(" ");

        for(String s : str){
            if(!s.equals("")) answer += Integer.valueOf(s);
        }

        return answer;
    }
}

class Solution {
    public int solution(String my_string) {
        int answer = 0;
        String s = my_string.replaceAll("[^0-9]", " ");
        StringTokenizer st = new StringTokenizer(s, " ");

        while (st.hasMoreTokens()) {
            answer += Integer.parseInt(st.nextToken());
        }

        return answer;
    }
}

class Solution {
    public int solution(String myString) {
        return Arrays.stream(myString.split("[A-Z|a-z]")).filter(s -> !s.isEmpty()).mapToInt(Integer::parseInt).sum();
    }
}
 */