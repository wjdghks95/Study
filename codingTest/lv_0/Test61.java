package lv_0;

import java.util.HashMap;

/*
    모스부호(1)
        머쓱이는 친구에게 모스부호를 이용한 편지를 받았습니다.
        그냥은 읽을 수 없어 이를 해독하는 프로그램을 만들려고 합니다.
        문자열 letter가 매개변수로 주어질 때, letter를 영어 소문자로 바꾼 문자열을 return 하도록 solution 함수를 완성해보세요.
        모스부호는 다음과 같습니다.
        morse = {
            '.-':'a','-...':'b','-.-.':'c','-..':'d','.':'e','..-.':'f',
            '--.':'g','....':'h','..':'i','.---':'j','-.-':'k','.-..':'l',
            '--':'m','-.':'n','---':'o','.--.':'p','--.-':'q','.-.':'r',
            '...':'s','-':'t','..-':'u','...-':'v','.--':'w','-..-':'x',
            '-.--':'y','--..':'z'
        }
 */
public class Test61 {
    public static void main(String[] args) {
        String letter = ".... . .-.. .-.. ---";
        String solution = new Solution61().solution(letter);
        System.out.println("solution = " + solution);
    }
}

class Solution61 {
    public String solution(String letter) {
        String answer = "";
        HashMap<String, Character> map = new HashMap<>();
        map.put(".-", 'a');
        map.put("-...", 'b');
        map.put("-.-.", 'c');
        map.put("-..", 'd');
        map.put(".", 'e');
        map.put("..-.", 'f');
        map.put("--.", 'g');
        map.put("....", 'h');
        map.put("..", 'i');
        map.put(".---", 'j');
        map.put("-.-", 'k');
        map.put(".-..", 'l');
        map.put("--", 'm');
        map.put("-.", 'n');
        map.put("---", 'o');
        map.put(".--.", 'p');
        map.put("--.-", 'q');
        map.put(".-.", 'r');
        map.put("...", 's');
        map.put("-", 't');
        map.put("..-", 'u');
        map.put("...-", 'v');
        map.put(".--", 'w');
        map.put("-..-", 'x');
        map.put("-.--", 'y');
        map.put("--..", 'z');

        String[] strArr = letter.split(" ");
        for (String s : strArr) {
            answer += map.get(s);
        }
        return answer;
    }
}

/*
    모범답안
 */
/*
class Solution {
    public String solution(String letter) {
        String morseStr = "'.-':'a','-...':'b','-.-.':'c','-..':'d','.':'e','..-.':'f',"
                + "'--.':'g','....':'h','..':'i','.---':'j','-.-':'k','.-..':'l',"
                + "'--':'m','-.':'n','---':'o','.--.':'p','--.-':'q','.-.':'r',"
                + "'...':'s','-':'t','..-':'u','...-':'v','.--':'w','-..-':'x',"
                + "'-.--':'y','--..':'z'";
        String[] morseArr = morseStr.split(",");
        String[] letterArr = letter.split(" ");

        HashMap<String, String> morse = new HashMap<String, String>();

        for (int i = 0; i < morseArr.length; i++) {
            morseArr[i] = morseArr[i].replace("'", "");
            int idx = morseArr[i].indexOf(":");
            morse.put(morseArr[i].substring(0, idx), morseArr[i].substring(idx+1));
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < letterArr.length; i++) {
            sb.append(morse.get(letterArr[i]));
        }

        return sb.toString();
    }
}
 */