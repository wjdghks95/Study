package lv_0;

import java.util.Arrays;

/**
 * 정사각형으로 만들기
 * 문제 설명
 * 이차원 정수 배열 arr이 매개변수로 주어집니다.
 * arr의 행의 수가 더 많다면 열의 수가 행의 수와 같아지도록 각 행의 끝에 0을 추가하고,
 * 열의 수가 더 많다면 행의 수가 열의 수와 같아지도록 각 열의 끝에 0을 추가한 이차원 배열을 return 하는 solution 함수를 작성해 주세요.
 *
 * 제한사항
 * 1 ≤ arr의 길이 ≤ 100
 * 1 ≤ arr의 원소의 길이 ≤ 100
 * arr의 모든 원소의 길이는 같습니다.
 * 1 ≤ arr의 원소의 원소 ≤ 1,000
 *
 * 입출력 예
 * arr [[572, 22, 37], [287, 726, 384], [85, 137, 292], [487, 13, 876]]
 * result [[572, 22, 37, 0], [287, 726, 384, 0], [85, 137, 292, 0], [487, 13, 876, 0]]
 *
 * arr [[57, 192, 534, 2], [9, 345, 192, 999]]
 * result [[57, 192, 534, 2], [9, 345, 192, 999], [0, 0, 0, 0], [0, 0, 0, 0]]
 */
public class Test138 {
    public static void main(String[] args) {
        int[][] arr = {{57, 192, 534, 2}, {9, 345, 192, 999}};
        int[][] solution = new Solution().solution(arr);
        System.out.println("solution = " + Arrays.deepToString(solution));
    }

    static class Solution {
        public int[][] solution(int[][] arr) {
            int[][] answer = {};

            int rowLength = arr.length;
            int columnLength = arr[0].length;

            if (rowLength > columnLength) {
                for (int i = 0; i < rowLength; i++) {
                    arr[i] = Arrays.copyOf(arr[i], rowLength);
                }
            }
            if (rowLength < columnLength){
                arr = Arrays.copyOf(arr, columnLength);
                for (int i = rowLength; i < columnLength; i++) {
                    arr[i] = new int[columnLength];
                }
            }
            return answer = arr;
        }
    }

    /*
    class Solution {
        public int[][] solution(int[][] arr) {
            int max = Math.max(arr.length, arr[0].length);
            int[][] array = new int[max][max];

            for (int i = 0; i < arr.length; i++) {
                System.arraycopy(arr[i], 0, array[i], 0, arr[0].length);
            }
            return array;
        }
    }
     */
}

