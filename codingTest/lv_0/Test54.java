package lv_0;

/*
   최대값 만들기(2)
    정수 배열 numbers가 매개변수로 주어집니다. numbers의 원소 중 두 개를 곱해 만들 수 있는 최댓값을 return하도록 solution 함수를 완성해주세요.
 */
public class Test54 {
    public static void main(String[] args) {
        int[] numbers = {1, -2};
        int solution = new Solution54().solution(numbers);
        System.out.println("solution = " + solution);
    }
}

class Solution54 {
    public int solution(int[] numbers) {
        int answer = Integer.MAX_VALUE * -1;
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                int temp = numbers[i] * numbers[j];
                if (temp > answer) {
                    answer = temp;
                }
            }
        }
        return answer;
    }
}

/* 모법답안 */
/*
class Solution {
    public int solution(int[] numbers) {
        int len = numbers.length;
        Arrays.sort(numbers);
        return Math.max(numbers[0] * numbers[1], numbers[len - 2] * numbers[len - 1]);
    }
}
*/