'''
다음 소스는 N번째 피보나치 수를 구하는 C++ 함수이다.
int fibonacci(int n) {
    if (n == 0) {
        printf("0");
        return 0;
    } else if (n == 1) {
        printf("1");
        return 1;
    } else {
        return fibonacci(n‐1) + fibonacci(n‐2);
    }
}
fibonacci(3)을 호출하면 다음과 같은 일이 일어난다.
fibonacci(3)은 fibonacci(2)와 fibonacci(1) (첫 번째 호출)을 호출한다.
fibonacci(2)는 fibonacci(1) (두 번째 호출)과 fibonacci(0)을 호출한다.
두 번째 호출한 fibonacci(1)은 1을 출력하고 1을 리턴한다.
fibonacci(0)은 0을 출력하고, 0을 리턴한다.
fibonacci(2)는 fibonacci(1)과 fibonacci(0)의 결과를 얻고, 1을 리턴한다.
첫 번째 호출한 fibonacci(1)은 1을 출력하고, 1을 리턴한다.
fibonacci(3)은 fibonacci(2)와 fibonacci(1)의 결과를 얻고, 2를 리턴한다.
1은 2번 출력되고, 0은 1번 출력된다.
N이 주어졌을 때, fibonacci(N)을 호출했을 때, 0과 1이 각각 몇 번 출력되는지 구하는 프로그램을 작성하시오.

입력
첫째 줄에 테스트 케이스의 개수 T가 주어진다.
각 테스트 케이스는 한 줄로 이루어져 있고, N이 주어진다.
N은 40보다 작거나 같은 자연수 또는 0이다.

출력
각 테스트 케이스마다 0이 출력되는 횟수와 1이 출력되는 횟수를 공백으로 구분해서 출력한다.

예제 입력 1
3
0
1
3
예제 출력 1
1 0
0 1
1 2
예제 입력 2
2
6
22
예제 출력 2
5 8
10946 17711
'''
import sys

def fibonacci(n, note):
    if note.get(n):
        return note.get(n)
    else:
        if n == 0:
            return note.get(0)
        elif n == 1:
            return note.get(1)
        else:
            fibonacci1 = fibonacci(n - 1, note)
            fibonacci2 = fibonacci(n - 2, note)

            fibonacci_num = fibonacci1[0] + fibonacci2[0]
            fibonacci_zero_count = fibonacci1[1] + fibonacci2[1]
            fibonacci_one_count = fibonacci1[2] + fibonacci2[2]
            note[n] = (fibonacci_num, fibonacci_zero_count, fibonacci_one_count)
            return note.get(n)

input = sys.stdin.readline
T = int(input().strip())
note = {
    0: (0, 1, 0),
    1: (1, 0, 1)
}
for _ in range(T):
    N = int(input().strip())
    result = fibonacci(N, note)
    print(result[1], result[2])

'''
T = int(input())
tests = [int(input()) for _ in range(T)]

max_n = max(tests)

# DP 테이블 초기화
count_0 = [0] * (max_n + 1)
count_1 = [0] * (max_n + 1)

# 초기값
count_0[0] = 1
count_1[0] = 0

if max_n >= 1:
    count_0[1] = 0
    count_1[1] = 1

# 점화식에 따라 계산
for i in range(2, max_n + 1):
    count_0[i] = count_0[i-1] + count_0[i-2]
    count_1[i] = count_1[i-1] + count_1[i-2]

# 결과 출력
for n in tests:
    print(count_0[n], count_1[n])
'''