input = 5

# memo 라는 변수에 Fibo(1)과 Fibo(2) 값을 저장해놨습니다!
memo = {
    1: 1,
    2: 1
}

# 1. 메모에 이미 해당 값이 있으면 반환한다.
# 2. 만약 없다면, 그 값을 피보나치를 통해 구하고 메모에 저장한다.
def fibo_dynamic_programming(n, fibo_memo):
    if n in fibo_memo:
        return fibo_memo[n]

    ntn_fibo = fibo_dynamic_programming(n - 1, fibo_memo) + fibo_dynamic_programming(n - 2, fibo_memo)
    fibo_memo[n] = ntn_fibo

    return ntn_fibo


print(fibo_dynamic_programming(input, memo))