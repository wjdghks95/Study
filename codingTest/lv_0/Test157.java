package lv_0;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 문자열 밀기
 * 문제 설명
 * 문자열 "hello"에서 각 문자를 오른쪽으로 한 칸씩 밀고 마지막 문자는 맨 앞으로 이동시키면 "ohell"이 됩니다.
 * 이것을 문자열을 민다고 정의한다면 문자열 A와 B가 매개변수로 주어질 때,
 * A를 밀어서 B가 될 수 있다면 밀어야 하는 최소 횟수를 return하고 밀어서 B가 될 수 없으면 -1을 return 하도록 solution 함수를 완성해보세요.
 *
 * 제한사항
 * 0 < A의 길이 = B의 길이 < 100
 * A, B는 알파벳 소문자로 이루어져 있습니다.
 *
 * 입출력 예
 * A	B	result
 * "hello"	"ohell"	1
 * "apple"	"elppa"	-1
 * "atat"	"tata"	1
 * "abc"	"abc"	0
 */
public class Test157 {
    public static void main(String[] args) {
        String A = "hello";
        String B = "ohell";
        int solution = new Solution().solution(A, B);
        System.out.println("solution = " + solution);
    }

    static class Solution {
        public int solution(String A, String B) {
            int answer = 0;

            for (int i = 0; i < A.length(); i++) {

                if (A.equals(B)) {
                    answer = i;
                    break;
                } else {
                    answer = -1;
                }

                String[] split = A.split("");
                List<String> collect = Arrays.stream(split).limit(split.length - 1).collect(Collectors.toList());
                collect.add(0, split[split.length - 1]);
                A = collect.stream().collect(Collectors.joining());
            }

            return answer;
        }
    }
}

/*
    class Solution {
        public int solution(String A, String B) {
            String tempB = B.repeat(3);
            return tempB.indexOf(A);
        }
    }
 */