import heapq

ramen_stock = 4
supply_dates = [4, 10, 15]
supply_supplies = [20, 5, 10]
supply_recover_k = 30

def get_minimum_count_of_overseas_supply(stock, dates, supplies, k):
    '''
    heap = []
    while stock <= k:

        for i in range(len(dates)):
            if dates[i] <= stock:

                if supplies[i] not in heap:
                    heapq.heappush(heap, supplies[i] * -1)

                stock += supplies[i]

    sum = 0
    count = 0
    while sum < k:
        sum += heapq.heappop(heap) * -1
        count += 1

    return count
    '''

    # 1. 현재 재고의 상태에 따라 최곳값을 받아야 한다. (동적 상황)
    # 2. 제일 많은 값만 가져가면 된다.
    # -> maxHeap

    # heap 에다가 넣어둔 다음에 최고로 많은 재고들을 꺼내서 stock 에 추가해주면 될 것.
    # 현재 재고가 바닥나는 시점 이전까지
    answer = 0
    last_added_date_index = 0
    max_heap = []

    while stock <= k: # stock 이 k 보다 크게 되면 멈출 것이다.

        while last_added_date_index < len(dates) and dates[last_added_date_index] <= stock:
            heapq.heappush(max_heap, supplies[last_added_date_index] * -1)
            last_added_date_index += 1

        supply = heapq.heappop(max_heap) * -1
        stock += supply
        answer += 1

    return answer

print(get_minimum_count_of_overseas_supply(ramen_stock, supply_dates, supply_supplies, supply_recover_k))
print("정답 = 2 / 현재 풀이 값 = ", get_minimum_count_of_overseas_supply(4, [4, 10, 15], [20, 5, 10], 30))
print("정답 = 4 / 현재 풀이 값 = ", get_minimum_count_of_overseas_supply(4, [4, 10, 15, 20], [20, 5, 10, 5], 40))
print("정답 = 1 / 현재 풀이 값 = ", get_minimum_count_of_overseas_supply(2, [1, 10], [10, 100], 11))
print("정답 = 3 / 현재 풀이 값 = ", get_minimum_count_of_overseas_supply(0, [0, 20, 25], [20, 10, 15], 35))