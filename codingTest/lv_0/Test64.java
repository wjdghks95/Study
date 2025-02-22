package lv_0;

import java.util.Arrays;

/*
    2차원으로 만들기
        정수 배열 num_list와 정수 n이 매개변수로 주어집니다.
        num_list를 다음 설명과 같이 2차원 배열로 바꿔 return하도록 solution 함수를 완성해주세요.
        num_list가 [1, 2, 3, 4, 5, 6, 7, 8] 로 길이가 8이고 n이 2이므로 num_list를 2 * 4 배열로 다음과 같이 변경합니다.
        2차원으로 바꿀 때에는 num_list의 원소들을 앞에서부터 n개씩 나눠 2차원 배열로 변경합니다.
 */
public class Test64 {
    public static void main(String[] args) {
        int[] num_list = {100, 95, 2, 4, 5, 6, 18, 33, 948};
        int n = 3;
        int[][] solution = new Solution64().solution(num_list, n);
        System.out.println("solution = " + Arrays.deepToString(solution));
    }
}

class Solution64 {
    public int[][] solution(int[] num_list, int n) {
        int[][] answer = {};
        int m = num_list.length / n;

        answer = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                answer[i][j] = num_list[i * n + j];
            }
        }
        return answer;
    }
}

/*
    모범답안
 */
/*
class Solution {
    public int[][] solution(int[] num_list, int n) {
        int[][] answer = {};

        int length = num_list.length;

        answer = new int[length/n][n];

        for(int i=0; i<length; i++){
            answer[i/n][i%n]=num_list[i];
        }

        return answer;
    }
}
 */