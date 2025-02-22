package lv_0;

/**
 * 옹알이 (1)
 * 문제 설명
 * 머쓱이는 태어난 지 6개월 된 조카를 돌보고 있습니다.
 * 조카는 아직 "aya", "ye", "woo", "ma" 네 가지 발음을 최대 한 번씩 사용해 조합한(이어 붙인) 발음밖에 하지 못합니다.
 * 문자열 배열 babbling이 매개변수로 주어질 때, 머쓱이의 조카가 발음할 수 있는 단어의 개수를 return하도록 solution 함수를 완성해주세요.
 *
 * 제한사항
 * 1 ≤ babbling의 길이 ≤ 100
 * 1 ≤ babbling[i]의 길이 ≤ 15
 * babbling의 각 문자열에서 "aya", "ye", "woo", "ma"는 각각 최대 한 번씩만 등장합니다.
 * 즉, 각 문자열의 가능한 모든 부분 문자열 중에서 "aya", "ye", "woo", "ma"가 한 번씩만 등장합니다.
 * 문자열은 알파벳 소문자로만 이루어져 있습니다.
 *
 * 입출력 예
 * babbling	result
 * ["aya", "yee", "u", "maa", "wyeoo"]	1
 * ["ayaye", "uuuma", "ye", "yemawoo", "ayaa"]	3
 */
public class Test173 {
    public static void main(String[] args) {
        String[] babbling = {"ayaye", "uuuma", "ye", "yemawoo", "ayaa"};
        int solution = new Solution().solution(babbling);
        System.out.println("solution = " + solution);
    }

    static class Solution {
        public int solution(String[] babbling) {
            int answer = 0;

            String[] words = {"aya", "ye", "woo", "ma"};

            for (int i = 0; i < babbling.length; i++) {
                for (String word : words) {
                    if (babbling[i].indexOf(word) != -1) {
                        babbling[i] = babbling[i].replace(word, " ");
                    }
                }
            }

            for (String str : babbling) {
                str = str.replace(" ", "");
                if (str == "") {
                    answer++;
                }
            }

            return answer;
        }
    }
}

/*
    class Solution {
        public int solution(String[] babbling) {
            int answer = 0;
            for(int i=0; i<babbling.length; i++){
                if(babbling[i].matches("^(aya(?!aya)|ye(?!ye)|woo(?!woo)|ma(?!ma))+$")){
                    answer++;
                }
            }
            return answer;
        }
    }

    class Solution {
        public int solution(String[] babbling) {
            int answer = 0;

            for(int i =0; i < babbling.length; i++) {
                babbling[i] = babbling[i].replace("aya", "1");
                babbling[i] = babbling[i].replace("woo", "1");
                babbling[i] = babbling[i].replace("ye", "1");
                babbling[i] = babbling[i].replace("ma", "1");
                babbling[i] = babbling[i].replace("1", "");
                if(babbling[i].isEmpty()) {
                    answer = answer + 1;
                }
            }

            return answer;
        }
    }
 */