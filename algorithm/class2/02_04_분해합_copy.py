N = int(input())

def get_decomposition_sum(x):
    return x + sum(int(digit) for digit in str(x))

result = 0
# M의 범위를 N보다 작은 수로 제한 (최소 N - 9*len(N)까지 줄일 수 있음)
for i in range(max(1, N - 9 * len(str(N))), N):
    if get_decomposition_sum(i) == N:
        result = i
        break

print(result)