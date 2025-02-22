package lv_0;

import java.util.Arrays;

/*
    한 번만 등장한 문자
        문자열 s가 매개변수로 주어집니다.
        s에서 한 번만 등장하는 문자를 사전 순으로 정렬한 문자열을 return 하도록 solution 함수를 완성해보세요.
        한 번만 등장하는 문자가 없을 경우 빈 문자열을 return 합니다.

    제한사항
    0 < s의 길이 < 1,000
    s는 소문자로만 이루어져 있습니다.
 */
public class Test68 {
    public static void main(String[] args) {
        String s = "hello";
        String solution = new Solution68().solution(s);
        System.out.println("solution = " + solution);
    }
}


class Solution68 {
    public String solution(String s) {
        String answer = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                if (i != j) {
                    if (s.charAt(i) == s.charAt(j)) {
                        s = s.replace(String.valueOf(s.charAt(i)), " ");
                        System.out.println("s = " + s);
                        break;
                    }
                }
            }
        }

        char[] chars = s.trim().replace(" ", "").toCharArray();
        Arrays.sort(chars);
        answer = new String(chars);

        return answer;
    }
}

/*
    모범 답안
 */
/*
class Solution {
    public String solution(String s) {
        int[] alpha = new int[26];
        for(char c : s.toCharArray()){
            alpha[c - 'a']++;
        }

        StringBuilder answer = new StringBuilder();
        for(int i = 0; i < 26; i++){
            if(alpha[i] == 1){
                answer.append((char)(i + 'a'));
            }
        }
        return answer.toString();
    }
}

class Solution {
    public String solution(String s) {
        return Arrays.stream(s.split(""))
                .collect(Collectors.groupingBy(s1 -> s1))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue().size() <= 1)
                .map(Map.Entry::getKey)
                .sorted()
                .collect(Collectors.joining());
    }
}

class Solution {
    public String solution(String s) {

        HashSet<String> set = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            String replace = s.replace(s.charAt(i) + "", "");
            if(s.length() - replace.length() == 1){
                set.add(s.charAt(i)+"");
            }
        }
        ArrayList<String> list = new ArrayList<>(set);
        Collections.sort(list);
        return String.join("", list);
    }
}
 */