'''
정수 X에 사용할 수 있는 연산은 다음과 같이 세 가지 이다.
1. X가 3으로 나누어 떨어지면, 3으로 나눈다.
2. X가 2로 나누어 떨어지면, 2로 나눈다.
3. 1을 뺀다.
정수 N이 주어졌을 때, 위와 같은 연산 세 개를 적절히 사용해서 1을 만들려고 한다. 연산을 사용하는 횟수의 최솟값을 출력하시오.

입력
첫째 줄에 1보다 크거나 같고, 106보다 작거나 같은 정수 N이 주어진다.

출력
첫째 줄에 연산을 하는 횟수의 최솟값을 출력한다.

예제 입력 1
2
예제 출력 1
1
예제 입력 2
10
예제 출력 2
3
'''
from collections import deque

N = int(input())
queue = deque()
queue.append((N, 0))

while queue:
    num, count = queue.popleft()

    if num == 1:
        print(count)
        break

    if num % 2 == 0:
        queue.append((num // 2, count + 1))
    if num % 3 == 0:
        queue.append((num // 3, count + 1))
    queue.append((num - 1, count + 1))

'''
N = int(input())

dp = [0] * (N + 1)
# dp[1] = 0 → 생략 가능 (기본값 0)

for i in range(2, N + 1):
    dp[i] = dp[i - 1] + 1  # 1을 빼는 경우
    if i % 2 == 0:
        dp[i] = min(dp[i], dp[i // 2] + 1)
    if i % 3 == 0:
        dp[i] = min(dp[i], dp[i // 3] + 1)

print(dp[N])
'''