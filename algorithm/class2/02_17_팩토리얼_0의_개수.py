'''
문제
N!에서 뒤에서부터 처음 0이 아닌 숫자가 나올 때까지 0의 개수를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 N이 주어진다. (0 ≤ N ≤ 500)

출력
첫째 줄에 구한 0의 개수를 출력한다.

예제 입력 1
10
예제 출력 1
2

예제 입력 2
3
예제 출력 2
0
'''
import math

N = int(input())
answer = 0

result = math.factorial(N)
li = list(str(result))
while li:
    if li.pop() != '0':
        print(answer)
        break
    answer += 1

'''
n = int(input())
count = 0

# 5, 25, 125, ...로 나누어 몫을 누적합
# 각각 5의 배수, 5^2, 5^3 등의 영향
while n >= 5:
    n //= 5
    count += n
print(count)
'''