N,M = map(int, input().split())
basket = list(range(1, N+1))
for _ in range(M):
    i,j = map(int, input().split())
    for k in range(i, j+1):
        max = max(basket[k-1], basket[k])
        min = min(basket[k-1], basket[k])

        basket[k-1] = max
        basket[k] = min