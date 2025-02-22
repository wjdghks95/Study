package lv_0;

import java.util.Arrays;

/*
    가까운수
        정수 배열 array와 정수 n이 매개변수로 주어질 때, array에 들어있는 정수 중 n과 가장 가까운 수를 return 하도록 solution 함수를 완성해주세요.
        가장 가까운 수가 여러 개일 경우 더 작은 수를 return 합니다.
 */
public class Test65 {
    public static void main(String[] args) {
        int[] array = {14, 3, 18};
        int n = 16;
        int solution = new Solution65().solution(array, n);
        System.out.println("solution = " + solution);
    }
}

class Solution65 {
    public int solution(int[] array, int n) {
        int answer = 0;

        Arrays.sort(array);
        int[] absArr = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            int abs = Math.abs(n - array[i]);
            absArr[i] = abs;
        }

        int min = Arrays.stream(absArr).min().getAsInt();

        for (int i = 0; i < absArr.length; i++) {
            if (min == absArr[i]) {
                answer = i;
                break;
            }
        }

        return array[answer];
    }
}

/*
    모범 답안
 */
/*
class Solution {
    public int solution(int[] array, int n) {
        return Math.min(array[Arrays.stream(array).map(operand -> Math.abs(n - operand)).boxed().collect(Collectors.toList()).indexOf(Arrays.stream(array).map(operand -> Math.abs(n - operand)).min().orElse(0))], array[Arrays.stream(array).map(operand -> Math.abs(n - operand)).boxed().collect(Collectors.toList()).lastIndexOf(Arrays.stream(array).map(operand -> Math.abs(n - operand)).min().orElse(0))]);
    }
}

class Solution {
    public int solution(int[] array, int n) {
        int answer = 0;
        Arrays.sort(array);
        for(int i = 1 ; i < array.length ; i++){
            if(Math.abs(n-array[0]) > Math.abs(n-array[i])){
                array[0] = array[i];
            }
        }
        answer = array[0];
        return answer;
    }
}
 */