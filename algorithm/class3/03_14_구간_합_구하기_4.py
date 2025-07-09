'''
수 N개가 주어졌을 때, i번째 수부터 j번째 수까지 합을 구하는 프로그램을 작성하시오.

입력
첫째 줄에 수의 개수 N과 합을 구해야 하는 횟수 M이 주어진다.
둘째 줄에는 N개의 수가 주어진다. 수는 1,000보다 작거나 같은 자연수이다.
셋째 줄부터 M개의 줄에는 합을 구해야 하는 구간 i와 j가 주어진다.

출력
총 M개의 줄에 입력으로 주어진 i번째 수부터 j번째 수까지 합을 출력한다.

제한
1 ≤ N ≤ 100,000
1 ≤ M ≤ 100,000
1 ≤ i ≤ j ≤ N

예제 입력 1
5 3
5 4 3 2 1
1 3
2 4
5 5
예제 출력 1
12
9
1
'''
# 수의갯수 5 -> 5 4 3 2 1
# 횟수 3       1   3      -> 12
#                2   4   -> 9
#                      5 -> 1

# dp[0] = 0
# dp[1] = 5
# dp[2] = 9
# dp[3] = 12
# dp[4] = 14
# dp[5] = 15

import sys

input = sys.stdin.readline
N, M = map(int, input().split())
numbers = list(map(int, input().split()))

dp = [0] * (N+1)
for i in range(len(numbers)):
    dp[i+1] = numbers[i] + dp[i]

for _ in range(M):
    i, j = map(int, input().split())
    print(dp[j] - dp[i-1])

'''
import sys
input = sys.stdin.read

data = input().split()
N = int(data[0])
M = int(data[1])
arr = list(map(int, data[2:N+2]))

# 누적합 배열 생성
prefix_sum = [0] * (N + 1)
for i in range(1, N + 1):
    prefix_sum[i] = prefix_sum[i - 1] + arr[i - 1]

# 질의 처리
results = []
for k in range(M):
    i = int(data[N+2 + 2*k])
    j = int(data[N+2 + 2*k + 1])
    results.append(str(prefix_sum[j] - prefix_sum[i - 1]))

print('\n'.join(results))
'''