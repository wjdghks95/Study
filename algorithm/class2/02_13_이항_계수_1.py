'''
문제
자연수 N과 정수 K가 주어졌을 때 이항 계수 (binom{N}{K})를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 N과 K가 주어진다. (1 ≤ N ≤ 10, 0 ≤ K ≤ N)

출력
(binom{N}{K})를 출력한다.

예제 입력 1
5 2
예제 출력 1
10

          1
        1   1
      1   2   1
    1   3   3   1
  1   4   6   4   1
1   5  10  10   5   1
'''
def factorial(N, K):
    if K == 0 or N == K:
        return 1

    return factorial(N - 1, K - 1) + factorial(N - 1, K)

N, K = map(int, input().split())
print(factorial(N, K))
