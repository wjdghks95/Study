package lv_1;

import java.util.Arrays;

/**
 * 자릿수 더하기
 * 문제 설명
 * 자연수 N이 주어지면, N의 각 자릿수의 합을 구해서 return 하는 solution 함수를 만들어 주세요.
 * 예를들어 N = 123이면 1 + 2 + 3 = 6을 return 하면 됩니다.
 *
 * 제한사항
 * N의 범위 : 100,000,000 이하의 자연수
 *
 * 입출력 예
 * N	answer
 * 123	6
 * 987	24
 */
public class Test3 {
	public static void main(String[] args) {
		int n = 123;
		int solution = new Solution().solution(n);
		System.out.println("solution = " + solution);
	}

	static class Solution {
		public int solution(int n) {
			int answer = 0;
			answer = Arrays.stream(String.valueOf(n).split("")).mapToInt(Integer::parseInt).sum();
			return answer;
		}
	}
}

/*
public class Solution {
    public int solution(int n) {
        int answer = 0;

        while(true){
            answer+=n%10;
            if(n<10)
                break;

            n=n/10;
        }

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("Hello Java");

        return answer;
    }
}
 */