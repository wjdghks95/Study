package lv_0;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/*
    중복된 문자 제거
        문자열 my_string이 매개변수로 주어집니다.
        my_string에서 중복된 문자를 제거하고 하나의 문자만 남긴 문자열을 return하도록 solution 함수를 완성해주세요.
 */
public class Test60 {
    public static void main(String[] args) {
        String my_string = "We are the world";
        String solution = new Solution60().solution(my_string);
        System.out.println("solution = " + solution);
    }
}

class Solution60 {
    public String solution(String my_string) {
        String answer = "";
//        char[] array = my_string.toCharArray();
//        List<Character> list = new ArrayList<>();
//        for (char c : array) {
//            list.add(c);
//        }
//
//        for (int i = 0; i < list.size(); i++) {
//            for (int j = i + 1; j < list.size(); j++) {
//                if (list.get(i) == list.get(j)) {
//                    list.remove(j);
//                    j--;
//                }
//            }
//        }
//
//        for (Character character : list) {
//            answer += character;
//        }

        answer = my_string.chars().mapToObj(c -> Character.toString(c)).distinct().collect(Collectors.joining());

        return answer;
    }
}

/*
    모범답안
 */
/*
class Solution {
    public String solution(String my_string) {
        return my_string.chars()
                .mapToObj(Character::toString)
                .distinct()
                .collect(Collectors.joining());
    }
}
 */
/*
class Solution {
    public String solution(String my_string) {
        String answer = "";

        for(int i=0; i<my_string.length(); i++){
            //my_string.indexOf(my_string.charAt(i));
            if(i==my_string.indexOf(my_string.charAt(i)))
                answer+=my_string.charAt(i);
        }

        return answer;
    }
}
 */