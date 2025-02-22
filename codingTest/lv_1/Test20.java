package lv_1;

import java.util.Arrays;

/**
 * 제일 작은 수 제거하기
 * 문제 설명
 * 정수를 저장한 배열, arr 에서 가장 작은 수를 제거한 배열을 리턴하는 함수, solution을 완성해주세요.
 * 단, 리턴하려는 배열이 빈 배열인 경우엔 배열에 -1을 채워 리턴하세요.
 * 예를들어 arr이 [4,3,2,1]인 경우는 [4,3,2]를 리턴 하고, [10]면 [-1]을 리턴 합니다.
 *
 * 제한 조건
 * arr은 길이 1 이상인 배열입니다.
 * 인덱스 i, j에 대해 i ≠ j이면 arr[i] ≠ arr[j] 입니다.
 *
 * 입출력 예
 * arr	return
 * [4,3,2,1]	[4,3,2]
 * [10]	[-1]
 */
public class Test20 {
	public static void main(String[] args) {
		int[] numbers = {4,3,2,1};
		int[] solution = new Solution().solution(numbers);
		System.out.println("solution = " + Arrays.toString(solution));
	}

	static class Solution {
		public int[] solution(int[] arr) {
			int[] answer = {};

			int min = Arrays.stream(arr).min().getAsInt();
			answer = Arrays.stream(arr).filter(i -> i != min).toArray();
			if (answer.length == 0) { answer = new int[]{-1}; }

			return answer;
		}
	}
}

/*
	class Solution {
	  public int[] solution(int[] arr) {
	      if(arr.length == 1){
	          int[] answer = {-1};
	          return answer;
	      }

	      int[] answer = new int[arr.length-1];
	      int minIndex=0;

	      for(int i=0;i<arr.length;i++){
	          if(arr[minIndex]>arr[i]){
	              minIndex = i;
	          }
	      }
	      for(int i=minIndex+1;i<arr.length;i++){
	          arr[i-1] = arr[i];
	      }
	      for(int i=0;i<answer.length;i++){
	          answer[i] = arr[i];
	      }
	      return answer;
	  }
	}
 */