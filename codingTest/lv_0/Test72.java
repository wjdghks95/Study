package lv_0;

/*
    7의 개수
        머쓱이는 행운의 숫자 7을 가장 좋아합니다.
        정수 배열 array가 매개변수로 주어질 때, 7이 총 몇 개 있는지 return 하도록 solution 함수를 완성해보세요.

    제한사항
    1 ≤ array의 길이 ≤ 100
    0 ≤ array의 원소 ≤ 100,000
 */

public class Test72 {
    public static void main(String[] args) {
        int[] array = {7, 77, 17};
        int solution = new Solution().solution(array);
        System.out.println("solution = " + solution);
    }

    static class Solution {
        public int solution(int[] array) {
            int answer = 0;
            String str = "";
            for (int i : array) {
                str += String.valueOf(i);
            }
            char[] chars = str.toCharArray();
            for (char c : chars) {
                if (Character.getNumericValue(c) == 7) {
                    answer++;
                }
            }
            return answer;
        }
    }

    /** 모범답안 */
    /*
        class Solution {
            public int solution(int[] array) {
                return (int) Arrays.stream(
                                Arrays.stream(array)
                                        .mapToObj(String::valueOf)
                                        .collect(Collectors.joining())
                                        .split("")
                        )
                        .filter(s -> s.equals("7"))
                        .count();
            }
        }

        class Solution {
            public int solution(int[] array) {
                int answer = 0;
                for(int a : array){
                    while(a != 0){
                        if(a % 10 == 7){
                            answer++;
                        }
                        a /= 10;
                    }
                }
                return answer;
            }
        }
     */
}
