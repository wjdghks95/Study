from collections import deque

c = 11
b = 2

'''
def catch_me(cony_loc, brown_loc):
    answer = 0
    queue = deque()

    if cony_loc == brown_loc:
        return answer

    queue.append(brown_loc - 1)
    queue.append(brown_loc + 1)
    queue.append(brown_loc * 2)

    while cony_loc <= 200000:

        answer += 1
        cony_loc += answer

        for i in range(len(queue)):
            brown_loc = queue.popleft()

            if cony_loc == brown_loc:
                return answer

            queue.append(brown_loc - 1)
            queue.append(brown_loc + 1)
            queue.append(brown_loc * 2)
    '''

# Cony
# T  0 1  2  3  4
#   11 12 14 17 21
# Brown
# T 0   1              2
#   2   1-1. B-1 = 1   1-1-1. B-1 = 0
#                      1-1-2. B+1 = 2
#                      1-1-3. 2*b = 2
#       1-2. B+1 = 3   1-2-1. B-1 = 2
#                      1-2-2. B+1 = 4
#                      1-2-3. 2*B = 6
#       1-3. 2*b = 4

# visited[1]{1:True}   # visited[0]{2:True}
# visited[3]{1:True}   # visited[2]{2:True}
# visited[4]{1:True}   # visited[4]{1:True, 2:True}
                       # visited[6]{2:True}

def catch_me(cony_loc, brown_loc):
    time = 0
    queue = deque()
    queue.append((brown_loc, 0))

    visited = [{} for _ in range(200001)]

    while cony_loc <= 200000:
        cony_loc += time

        if time in visited[cony_loc]:
            return time

        for i in range(0, len(queue)):
            current_position, current_time = queue.popleft()

            new_time = current_time + 1
            new_position = current_position - 1
            if 0 <= new_position <= 200000:
                visited[new_position][new_time] = True
                queue.append((new_position, new_time))

            new_position = current_position + 1
            if 0 <= new_position <= 200000:
                visited[new_position][new_time] = True
                queue.append((new_position, new_time))

            new_position = current_position * 2
            if 0 <= new_position <= 200000:
                visited[new_position][new_time] = True
                queue.append((new_position, new_time))

        time += 1

    return

print(catch_me(c, b))  # 5가 나와야 합니다!

print("정답 = 3 / 현재 풀이 값 = ", catch_me(10,3))
print("정답 = 8 / 현재 풀이 값 = ", catch_me(51,50))
print("정답 = 28 / 현재 풀이 값 = ", catch_me(550,500))