'''
문제
M이상 N이하의 소수를 모두 출력하는 프로그램을 작성하시오.

입력
첫째 줄에 자연수 M과 N이 빈 칸을 사이에 두고 주어진다.
(1 ≤ M ≤ N ≤ 1,000,000) M이상 N이하의 소수가 하나 이상 있는 입력만 주어진다.

출력
한 줄에 하나씩, 증가하는 순서대로 소수를 출력한다.

예제 입력 1
3 16
예제 출력 1
3
5
7
11
13
'''
import math
import sys

# import math
# import sys
#
# M, N = map(int, sys.stdin.readline().split())
# for i in range(M, N+1):
#     is_prime = True
#     for j in range(2, int(math.sqrt(i)) + 1):
#         if i % j == 0:
#             is_prime = False
#             break
#
#     if i > 1 and is_prime:
#         print(i)


M, N = map(int, sys.stdin.readline().split())
# 소수 여부를 저장하는 배열 (0과 1은 소수가 아니므로 False로 처리)
is_prime = [False, False] + [True] * (N - 1)

for i in range(2, int(math.sqrt(N)) + 1):
    if is_prime[i]:
        for j in range(i * i, N + 1, i):
            is_prime[j] = False

# M부터 N까지 중 소수만 출력
for i in range(M, N + 1):
    if is_prime[i]:
        print(i)