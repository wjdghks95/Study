package lv_1;

import java.util.Arrays;

/**
 * 최대공약수와 최소공배수
 * 문제 설명
 * 두 수를 입력받아 두 수의 최대공약수와 최소공배수를 반환하는 함수, solution을 완성해 보세요.
 * 배열의 맨 앞에 최대공약수, 그다음 최소공배수를 넣어 반환하면 됩니다.
 * 예를 들어 두 수 3, 12의 최대공약수는 3, 최소공배수는 12이므로 solution(3, 12)는 [3, 12]를 반환해야 합니다.
 *
 * 제한 사항
 * 두 수는 1이상 1000000이하의 자연수입니다.
 *
 * 입출력 예
 * n	m	return
 * 3	12	[3, 12]
 * 2	5	[1, 10]
 */
public class Test30 {
	public static void main(String[] args) {
		int n = 3;
		int m = 12;
		int[] solution = new Solution().solution(n, m);
		System.out.println("solution = " + Arrays.toString(solution));
	}

	static class Solution {
		public int[] solution(int n, int m) {
			int[] answer = {};

			answer = new int[2];

			for (int i = 1; i <= Math.max(n, m); i++) {
				if (n % i == 0 && m % i == 0) {
					answer[0] = i;
					answer[1] = n * m / i;
				}
			}

			return answer;
		}
	}
}

/**
 * 유클리드 호제법(Euclidean Algorithm)
 * 2개의 자연수를 받아 최대공약수를 받기 위해 2부터 두 자연수 중 작은 자연수까지 모두 나누어보면서 가장 큰 공약수를 구할 수 있다.
 * 위와 같은 방법으로 문제를 풀면 시간복잡도는 O(N)이 된다. 나쁜 방법은 아니지만 효율을 높이기 위해 유클리드 호제법이란 알고리즘을 사용하면 시간복잡도를 O(logN)으로 줄일 수 있다.
 * 2개의 자연수  a, b에 대해서 a를 b로 나눈 나머지를 r이라 하면 (단 a>b), a와 b의 최대공약수는 b와 r의 최대공약수와 같다.
 * 이 성질에 따라, b를 r로 나눈 나머지 r0를 구하고, 다시 r을 r0로 나눈 나머지를 구하는 과정을 반복하여 나머지가 0이 되었을 때 나누는 수가 a와 b의 최대공약수이다.
 */
/*
	class Solution {
		public int[] solution(int n, int m) {
			int[] answer = new int[2];

			answer[0] = gcd(n, m);
			answer[1] = (n * m) / answer[0];
			return answer;
		}

	   public static int gcd(int n, int m) {
		   if (m == 0) return n;
		   return gcd(m, n % m);
	   }
   }
 */