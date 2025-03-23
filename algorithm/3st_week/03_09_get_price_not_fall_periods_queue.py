from collections import deque

prices = [1, 2, 3, 2, 3]

def get_price_not_fall_periods(prices):
    '''
    answer = []
    queue = deque()
    for i in prices:
        queue.append(i)

    while queue:
        head = queue.popleft()

        time = 0
        for i in range(len(queue)):
            time = i + 1
            if head > queue[i]:
                break

        answer.append(time)

    return answer
    '''

    result = []
    prices_queue = deque(prices)

    while prices_queue: # prices_queue 가 비어있지 않다면 반복
        price_not_fall_period = 0
        current_price = prices_queue.popleft()

        for next_price in prices_queue:
            if current_price <= next_price:
                price_not_fall_period += 1
            else:
                price_not_fall_period += 1
                break

        result.append(price_not_fall_period)

    return result

print(get_price_not_fall_periods(prices))

print("정답 = [4, 3, 1, 1, 0] / 현재 풀이 값 = ", get_price_not_fall_periods(prices))
print("정답 = [6, 2, 1, 3, 2, 1, 0] / 현재 풀이 값 = ", get_price_not_fall_periods([3, 9, 9, 3, 5, 7, 2]))
print("정답 = [6, 1, 4, 3, 1, 1, 0] / 현재 풀이 값 = ", get_price_not_fall_periods([1, 5, 3, 6, 7, 6, 5]))