seat_count = 9
vip_seat_array = [4, 7]
'''
memo = {
    0: 1,
    1: 1
}

def get_all_ways_of_theater_seat(total_count, fixed_seat_array):
    all_ways_of_theater_seat = 1

    while fixed_seat_array:
        fixed_seat = fixed_seat_array.pop()

        seat_count = total_count - fixed_seat
        all_ways_of_theater_seat *= fibo_dynamic_programming(seat_count, memo)

        total_count = fixed_seat - 1

    all_ways_of_theater_seat *= fibo_dynamic_programming(total_count, memo)

    return all_ways_of_theater_seat

def fibo_dynamic_programming(n, fibo_memo):
    if n in fibo_memo:
        return fibo_memo[n]

    ntn_fibo = fibo_dynamic_programming(n - 1, fibo_memo) + fibo_dynamic_programming(n - 2, fibo_memo)
    fibo_memo[n] = ntn_fibo

    return ntn_fibo
    '''

# 1. 숫자를 써보면서 발견해보기
# [1] -> [1] 1
# [1, 2] -> [1, 2] [2, 1] 2
# [1, 2, 3] -> [1, 2, 3] [2, 1, 3] [1, 3, 2] 3
# [1, 2, 3, 4] -> [1, 2, 3, 4] [1, 2, 4, 3] [1, 3, 2, 4] [2, 1, 3, 4] [2, 1, 4, 3] 5

# 2. wjaghktlrdmf xhdgo vkdkr
# n 번째 티켓을 가진 사람이 앉을 수 있는 방법?
# 1) n 번째 좌석에 앉거나
# -> 좌석은 n-1 개가 남아있고, 사람도 n-1 번째 티켓까지 가진 사람이 있는 상황 -> N-1의 사람들을 좌석에 배치하는 방법 = F(N-1)
# 2) n - 1 번째 좌석에 앉거나 ->
# -> n - 1 번째 티켓을 가진 사람은 n 번째 좌석에 앉아야 한다.
# -> 좌석은 n-2 개가 남아있고, 사람도 n-2 번째 티켓까지 가진 사람이 있는 상황 -> N-2의 사람들을 좌석에 배치하는 방법 = F(N-2)

# F(N) N 명의 사람들을 좌석에 배치하는 방법
# F(N) = F(N-1) + F(N-2)

memo = {
    1: 1,
    2: 2
}

def get_all_ways_of_theater_seat(total_count, fixed_seat_array):
    all_ways = 1
    current_index = 0

    for fixed_seat in fixed_seat_array:
        fixed_seat_index = fixed_seat - 1
        count_of_ways = fibo_dynamic_programming(fixed_seat_index - current_index, memo)
        all_ways *= count_of_ways
        current_index = fixed_seat_index + 1

    count_of_ways = fibo_dynamic_programming(total_count - current_index, memo)
    all_ways *= count_of_ways

    return all_ways

def fibo_dynamic_programming(n, fibo_memo):
    if n in fibo_memo:
        return fibo_memo[n]

    ntn_fibo = fibo_dynamic_programming(n - 1, fibo_memo) + fibo_dynamic_programming(n - 2, fibo_memo)
    fibo_memo[n] = ntn_fibo

    return ntn_fibo

# 12가 출력되어야 합니다!
print(get_all_ways_of_theater_seat(seat_count, vip_seat_array))

print("정답 = 4 / 현재 풀이 값 = ", get_all_ways_of_theater_seat(9,[2,4,7]))
print("정답 = 26 / 현재 풀이 값 = ", get_all_ways_of_theater_seat(11,[2,5]))
print("정답 = 6 / 현재 풀이 값 = ", get_all_ways_of_theater_seat(10,[2,6,9]))