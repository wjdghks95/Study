'''
문제
주어진 수 N개 중에서 소수가 몇 개인지 찾아서 출력하는 프로그램을 작성하시오.

입력
첫 줄에 수의 개수 N이 주어진다. N은 100이하이다. 다음으로 N개의 수가 주어지는데 수는 1,000 이하의 자연수이다.

출력
주어진 수들 중 소수의 개수를 출력한다.

예제 입력 1
4
1 3 5 7
예제 출력 1
3
'''
import math

N = int(input())
numbers = list(map(int, input().split()))
answer = 0

# numbers_copy = numbers.copy()
# for num in numbers_copy:
for num in numbers:
    if num < 2:
        # numbers.remove(num) # 리스트를 수정하지 않음
        continue

    is_prime = True

    # for i in range(2, num//2 + 1):
    for i in range(2, int(math.sqrt(num)) + 1): # √num(제곱근)까지만 검사
        if num % i == 0:
            # numbers.remove(num)
            is_prime = False
            break

    if is_prime:
        answer += 1

# answer = len(numbers)
print(answer)

