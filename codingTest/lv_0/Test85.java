package lv_0;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * 5명씩
 * 문제 설명
 * 최대 5명씩 탑승가능한 놀이기구를 타기 위해 줄을 서있는 사람들의 이름이 담긴 문자열 리스트 names가 주어질 때,
 * 앞에서 부터 5명씩 묶은 그룹의 가장 앞에 서있는 사람들의 이름을 담은 리스트를 return하도록 solution 함수를 완성해주세요.
 * 마지막 그룹이 5명이 되지 않더라도 가장 앞에 있는 사람의 이름을 포함합니다.
 *
 * 제한사항
 * 5 ≤ names의 길이 ≤ 30
 * 1 ≤ names의 원소의 길이 ≤ 10
 * names의 원소는 영어 알파벳 소문자로만 이루어져 있습니다.
 * 입출력 예
 * names	result
 * ["nami", "ahri", "jayce", "garen", "ivern", "vex", "jinx"]	["nami", "vex"]
 */
public class Test85 {
    public static void main(String[] args) {
        String[] names = {"nami", "ahri", "jayce", "garen", "ivern", "vex", "jinx"};
        // result 10
        String[] solution = new Solution().solution(names);
        System.out.println("solution = " + Arrays.toString(solution));
    }

    static class Solution {
        public String[] solution(String[] names) {
            String[] answer = {};
            answer = IntStream.iterate(0, i -> i < names.length, i -> i += 5).mapToObj(i -> names[i]).toArray(String[]::new);
            return answer;
        }
    }
}
