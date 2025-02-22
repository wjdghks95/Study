package lv_0;

import java.util.Arrays;

/**
 * 외계어 사전
 * 문제 설명
 * PROGRAMMERS-962 행성에 불시착한 우주비행사 머쓱이는 외계행성의 언어를 공부하려고 합니다.
 * 알파벳이 담긴 배열 spell과 외계어 사전 dic이 매개변수로 주어집니다.
 * spell에 담긴 알파벳을 한번씩만 모두 사용한 단어가 dic에 존재한다면 1, 존재하지 않는다면 2를 return하도록 solution 함수를 완성해주세요.
 *
 * 제한사항
 * spell과 dic의 원소는 알파벳 소문자로만 이루어져있습니다.
 * 2 ≤ spell의 크기 ≤ 10
 * spell의 원소의 길이는 1입니다.
 * 1 ≤ dic의 크기 ≤ 10
 * 1 ≤ dic의 원소의 길이 ≤ 10
 * spell의 원소를 모두 사용해 단어를 만들어야 합니다.
 * spell의 원소를 모두 사용해 만들 수 있는 단어는 dic에 두 개 이상 존재하지 않습니다.
 * dic과 spell 모두 중복된 원소를 갖지 않습니다.
 *
 * 입출력 예
 * spell	dic	result
 * ["p", "o", "s"]	["sod", "eocd", "qixm", "adio", "soo"]	2
 * ["z", "d", "x"]	["def", "dww", "dzx", "loveaw"] 1
 */
public class Test139 {
    public static void main(String[] args) {
        String[] spell = {"z", "d", "x"};
        String[] dic = {"def", "dww", "dzx", "loveaw"};
        int solution = new Solution().solution(spell, dic);
        System.out.println("solution = " + solution);
    }

    static class Solution {
        public int solution(String[] spell, String[] dic) {
            int answer = 0;
            for (String s : spell) {
                dic = Arrays.stream(dic).filter(str -> str.contains(s)).toArray(String[]::new);
            }
            answer = dic.length > 0 ? 1 : 2;
            return answer;
        }
    }

    /*
    class Solution {
        public int solution(String[] spell, String[] dic) {
            return Arrays.stream(dic).map(s -> s.chars().sorted().mapToObj(i -> String.valueOf((char) i)).collect(Collectors.joining())).collect(Collectors.toList()).contains(Arrays.stream(spell).sorted().collect(Collectors.joining())) ? 1 : 2;
        }
    }
     */
}

