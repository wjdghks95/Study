T = int(input())
dp = [[0] * 15 for _ in range(15)]  # 0층~14층, 1호~14호

# 0층 초기화
for i in range(1, 15):
    dp[0][i] = i

# 나머지 층 계산
for k in range(1, 15):
    for n in range(1, 15):
        dp[k][n] = dp[k][n-1] + dp[k-1][n]

# 테스트 케이스 처리
for _ in range(T):
    k = int(input())
    n = int(input())
    print(dp[k][n])
