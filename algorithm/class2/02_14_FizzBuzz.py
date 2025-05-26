'''
문제
FizzBuzz 문제는
i = 1, 2, ...에 대해 다음 규칙에 따라 문자열을 한 줄에 하나씩 출력하는 문제입니다.

i가 3의 배수이면서 5의 배수이면 “FizzBuzz”를 출력합니다.
i가 3의 배수이지만 5의 배수가 아니면 “Fizz”를 출력합니다.
i가 3의 배수가 아니지만 5의 배수이면 “Buzz”를 출력합니다.
i가 3의 배수도 아니고 5의 배수도 아닌 경우 i를 그대로 출력합니다.
FizzBuzz 문제에서 연속으로 출력된 세 개의 문자열이 주어집니다. 이때, 이 세 문자열 다음에 올 문자열은 무엇일까요?

입력
FizzBuzz 문제에서 연속으로 출력된 세 개의 문자열이 한 줄에 하나씩 주어집니다.
각 문자열의 길이는 8이하입니다. 입력이 항상 FizzBuzz 문제에서 연속으로 출력된 세 개의 문자열에 대응됨이 보장됩니다.

출력
연속으로 출력된 세 개의 문자열 다음에 올 문자열을 출력하세요. 여러 문자열이 올 수 있는 경우, 아무거나 하나 출력하세요.

예제 입력 1
Fizz
Buzz
11
예제 출력 1
Fizz

예제 입력 2
980803
980804
FizzBuzz
예제 출력 2
980806
'''
A = input()
B = input()
C = input()

li = []

def append(s):
    if s == "Fizz" or s == "Buzz" or s == "FizzBuzz":
        if len(li) > 0:
            tail = li[-1]
            li.append(tail + 1)
    else:
        li.append(int(s))

append(A)
append(B)
append(C)

pop = li.pop() + 1
answer = pop
if pop % 3 == 0:
    answer = "Fizz"
if pop % 5 == 0:
    answer = "Buzz"
if pop % 15 == 0:
    answer = "FizzBuzz"

print(answer)
