import math

N, K = map(int, input().split())
print(math.comb(N, K))

# Python 3.8 미만에서 사용할 경우 (직접 구현)
def factorial(n):
    result = 1
    for i in range(2, n + 1):
        result *= i
    return result

N, K = map(int, input().split())

numerator = factorial(N)
denominator = factorial(K) * factorial(N - K)

print(numerator // denominator)