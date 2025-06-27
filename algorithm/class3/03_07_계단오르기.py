'''
문제
계단 오르기 게임은 계단 아래 시작점부터 계단 꼭대기에 위치한 도착점까지 가는 게임이다.
<그림 1>과 같이 각각의 계단에는 일정한 점수가 쓰여 있는데 계단을 밟으면 그 계단에 쓰여 있는 점수를 얻게 된다.

<그림 1>

예를 들어 <그림 2>와 같이 시작점에서부터 첫 번째, 두 번째, 네 번째, 여섯 번째 계단을 밟아 도착점에 도달하면 총 점수는 10 + 20 + 25 + 20 = 75점이 된다.
<그림 2>

계단 오르는 데는 다음과 같은 규칙이 있다.
계단은 한 번에 한 계단씩 또는 두 계단씩 오를 수 있다. 즉, 한 계단을 밟으면서 이어서 다음 계단이나, 다음 다음 계단으로 오를 수 있다.
연속된 세 개의 계단을 모두 밟아서는 안 된다. 단, 시작점은 계단에 포함되지 않는다.
마지막 도착 계단은 반드시 밟아야 한다.
따라서 첫 번째 계단을 밟고 이어 두 번째 계단이나, 세 번째 계단으로 오를 수 있다.
하지만, 첫 번째 계단을 밟고 이어 네 번째 계단으로 올라가거나, 첫 번째, 두 번째, 세 번째 계단을 연속해서 모두 밟을 수는 없다.
각 계단에 쓰여 있는 점수가 주어질 때 이 게임에서 얻을 수 있는 총 점수의 최댓값을 구하는 프로그램을 작성하시오.

입력
입력의 첫째 줄에 계단의 개수가 주어진다.
둘째 줄부터 한 줄에 하나씩 제일 아래에 놓인 계단부터 순서대로 각 계단에 쓰여 있는 점수가 주어진다.
계단의 개수는 300이하의 자연수이고, 계단에 쓰여 있는 점수는 10,000이하의 자연수이다.

출력
첫째 줄에 계단 오르기 게임에서 얻을 수 있는 총 점수의 최댓값을 출력한다.

예제 입력 1
6
10
20
15
25
10
20
예제 출력 1
75
'''
# [10, 20, 15, 25, 10, 20]
# 20
# 20 10 한 칸 내려왔으면 다음은 무조건 두 칸 내려가야함
# 20 25 두 칸 내려왔으면 다음은 한 칸 또는 두 칸 가능
#
# 20 10 15 두 칸 내려왔으면 다음은 한 칸 또는 두 칸 가능
# 20 25 15 한 칸 내려왔으면 다음은 무조건 두 칸 내려가야함
# 20 25 20 두 칸 내려왔으면 다음은 무조건 한 칸 또는 두 칸 가능
#
# 20 10 15 20 한 칸 내려왔는데 두 칸 밑이 없음
# 20 10 15 10 두 칸 내려왔는데 한 칸 밑도 없음
# 20 25 20 10 한 칸 내려왔는데 두 칸 밑이 없음

N = int(input())
scores = [int(input()) for _ in range(N)]
note = [[-1] * 2 for _ in range(N)]

def get_max_score(index, flag):
    print(note)
    if index < 0:
        return 0
    if note[index][flag] != -1:
        return note[index][flag]

    if index == 0:
        note[index][flag] = scores[0]
    elif flag:
        note[index][flag] = scores[index] + max(get_max_score(index - 1, 0), get_max_score(index - 2, 1))
    else:
        note[index][flag] = scores[index] + get_max_score(index - 2, 1)

    return note[index][flag]

cur = N - 1
flag = 1 # 1 둘 다 가능 / 0 두 칸만 가능
result = get_max_score(cur, flag)
print(result)

'''
import sys

input = sys.stdin.readline

n = int(input())
score = [int(input()) for _ in range(n)]

if n == 1:
    print(score[0])
elif n == 2:
    print(score[0] + score[1])
else:
    dp = [0] * n
    dp[0] = score[0]
    dp[1] = score[0] + score[1]
    dp[2] = max(score[0] + score[2], score[1] + score[2])

    for i in range(3, n):
        dp[i] = max(dp[i-2] + score[i], dp[i-3] + score[i-1] + score[i])

    print(dp[-1])
'''