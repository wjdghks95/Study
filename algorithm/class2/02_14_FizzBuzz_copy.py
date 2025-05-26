def fizzbuzz(n):
    if n % 15 == 0:
        return "FizzBuzz"
    elif n % 3 == 0:
        return "Fizz"
    elif n % 5 == 0:
        return "Buzz"
    else:
        return str(n)

# 입력 받기
inputs = [input().strip() for _ in range(3)]

# 가능한 시작 위치를 1부터 시도
for start in range(1, 1000000):
    generated = [fizzbuzz(start + i) for i in range(3)]
    if generated == inputs:
        print(fizzbuzz(start + 3))
        break
