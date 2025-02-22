package lv_0;

import java.util.Arrays;

/*
    진료 순서 정하기
        외과의사 머쓱이는 응급실에 온 환자의 응급도를 기준으로 진료 순서를 정하려고 합니다.
        정수 배열 emergency가 매개변수로 주어질 때 응급도가 높은 순서대로 진료 순서를 정한 배열을 return하도록 solution 함수를 완성해주세요.

    제한사항
    중복된 원소는 없습니다.
    1 ≤ emergency의 길이 ≤ 10
    1 ≤ emergency의 원소 ≤ 100
 */
public class Test67 {
    public static void main(String[] args) {
        int[] emergency = {30, 10, 23, 6, 100}; // 2,4,3,5,1
        int[] solution = new Solution67().solution(emergency);
        System.out.println("solution = " + Arrays.toString(solution));
    }
}

class Solution67 {
    public int[] solution(int[] emergency) {
        int[] answer = {};
        answer = new int[emergency.length];
        for (int i = 0; i < emergency.length; i++) {
            int asInt = Arrays.stream(emergency).max().getAsInt();
            for (int j = 0; j < emergency.length; j++) {
                if (asInt == emergency[j]) {
                    answer[j] = i + 1;
                    emergency[j] = 0;
                }
            }
        }

        return answer;
    }
}

/*
    모범 답안
 */
/*
class Solution {
    public int[] solution(int[] e) {
        return Arrays.stream(e).map(i -> Arrays.stream(e).boxed().sorted(Comparator.reverseOrder()).collect(Collectors.toList()).indexOf(i) + 1).toArray();
    }
}

class Solution {
    public int[] solution(int[] emergency) {
        int[] answer = new int[emergency.length];

        for(int i = 0; i < answer.length; i++){
            if(answer[i] != 0){
                continue;
            }
            int idx = 1;
            for(int j = 0; j < answer.length; j++){
                if(emergency[i] < emergency[j]){
                    idx++;
                }
            }
            answer[i] = idx;
        }
        return answer;
    }
}
 */