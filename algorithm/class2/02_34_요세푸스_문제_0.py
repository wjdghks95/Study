'''
요세푸스 문제는 다음과 같다.
1번부터 N번까지 N명의 사람이 원을 이루면서 앉아있고, 양의 정수 K(≤ N)가 주어진다.
이제 순서대로 K번째 사람을 제거한다.
한 사람이 제거되면 남은 사람들로 이루어진 원을 따라 이 과정을 계속해 나간다.
이 과정은 N명의 사람이 모두 제거될 때까지 계속된다.
원에서 사람들이 제거되는 순서를 (N, K)-요세푸스 순열이라고 한다.
예를 들어 (7, 3)-요세푸스 순열은 <3, 6, 2, 7, 5, 1, 4>이다.
N과 K가 주어지면 (N, K)-요세푸스 순열을 구하는 프로그램을 작성하시오.

입력
첫째 줄에 N과 K가 빈 칸을 사이에 두고 순서대로 주어진다. (1 ≤ K ≤ N ≤ 1,000)

출력
예제와 같이 요세푸스 순열을 출력한다.

예제 입력 1
7 3
예제 출력 1
<3, 6, 2, 7, 5, 1, 4>
'''
# N, K = map(int, input().split())
# circle = [i for i in range(1, N+1)]
# Josephus = []
# cur = K - 1
# while circle:
#     if cur > len(circle) - 1:
#         temp_circle = circle + circle.copy()
#         while cur > len(temp_circle) - 1:
#             temp_circle = temp_circle + circle.copy()
#
#         target = temp_circle.pop(cur)
#         cur = circle.index(target)
#
#     pop = circle.pop(cur)
#     Josephus.append(pop)
#     cur += K - 1
#
# answer = '<'
# for i in range(len(Josephus)):
#     answer += str(Josephus[i])
#
#     if i < len(Josephus) - 1:
#         answer += ', '
# answer += '>'
# print(answer)

from collections import deque

N, K = map(int, input().split())

# 1부터 n까지 deque 생성
people = deque(range(1, N + 1))
result = []

# 순차적으로 제거
while people:
    people.rotate(-(K - 1)) # 왼쪽으로 K-1칸 회전
    result.append(people.popleft())

# 출력 형식 맞추기
print("<" + ", ".join(map(str, result)) + ">")