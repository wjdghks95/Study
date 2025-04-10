k = 4  # 말의 개수

chess_map = [
    [0, 0, 0, 0],
    [0, 0, 0, 0],
    [0, 0, 0, 0],
    [0, 0, 0, 0]
]
start_horse_location_and_directions = [
    [0, 0, 0],
    [0, 1, 0],
    [0, 2, 0],
    [2, 2, 2]
]
# 이 경우는 게임이 끝나지 않아 -1 을 반환해야 합니다!
# 동 서 북 남
# →, ←, ↑, ↓
dr = [0, 0, -1, 1]
dc = [1, -1, 0, 0]

def get_d_index_when_go_back(d):
    if d % 2 == 0:
        return d + 1
    else:
        return d - 1

def get_game_over_turn_count(horse_count, game_map, horse_location_and_directions):
    n = len(game_map)
    turn_count = 1
    current_stacked_horse_map = [[ [] for _ in range(n) ] for _ in range(n)]
    for i in range(horse_count):
        r, c, d =horse_location_and_directions[i]
        current_stacked_horse_map[r][c].append(i)

    # current_stacked_horse_map
    # [[0], [1], [2], [ ]]
    # [[ ], [ ], [ ], [ ]],
    # [[ ], [ ], [3], [ ]],
    # [[ ], [ ], [ ], [ ]]

    while turn_count <= 1000:
        for horse_index in range(horse_count):
            r, c, d = horse_location_and_directions[horse_index]
            new_r, new_c = r + dr[d], c + dc[d]

#           3) 파란색인 경우에는 1번 말의 이동 방향을 반대로 하고 한 칸 이동한다. 방향을 반대로 바꾼 후에 이동하려는 칸이 파란색인 경우에는 이동하지 않고 가만히 있는다.
#           4) 체스판을 벗어나는 경우에는 파란색과 같은 경우이다.
            if not 0 <= new_r < n or not 0 <= new_c < n or game_map[new_r][new_c] == 2:
                new_d = get_d_index_when_go_back(d)

                # 이동 방향을 반대로 하고 한 칸 이동한다.
                new_r, new_c = r + dr[new_d], c + dc[new_d]
                horse_location_and_directions[horse_index][2] = new_d

                # 방향을 반대로 바꾼 후에 이동하려는 칸이 파란색인 경우에는 이동하지 않고 가만히 있는다.
                if not 0 <= new_r < n or not 0 <= new_c < n or game_map[new_r][new_c] == 2:
                    continue

#           1) 흰색인 경우에는 그 칸으로 이동한다. 이동하려는 칸에 말이 이미 있는 경우에는 가장 위에 1번 말을 올려놓는다.
#               - 1번 말의 위에 다른 말이 있는 경우에는 1번 말과 위에 있는 모든 말이 이동한다.
#               - 예를 들어, 1, 2, 3로 쌓여있고, 이동하려는 칸에 4, 5가 있는 경우에는 1번 말이 이동한 후에는 4, 5, 1, 2, 3가 된다.
            moving_horse_index_array = []
            for i in range(len(current_stacked_horse_map[r][c])):
                current_stacked_horse_index = current_stacked_horse_map[r][c][i]

                if horse_index == current_stacked_horse_index:
                    moving_horse_index_array = current_stacked_horse_map[r][c][i:]
                    current_stacked_horse_map[r][c] = current_stacked_horse_map[r][c][:i]
                    break

#           2) 빨간색인 경우에는 이동한 후에 1번 말과 그 위에 있는 모든 말의 쌓여있는 순서를 반대로 바꾼다.
#               - 1, 2, 3 가 이동하고, 이동하려는 칸에 말이 없는 경우에는 3, 2, 1가 된다.
#               - 1, 4, 6, 7가 이동하고, 이동하려는 칸에 말이 5, 3, 2로 있는 경우에는 5, 3, 2, 7, 6, 4, 1가 된다.
            if game_map[new_r][new_c] == 1:
                moving_horse_index_array = reversed(moving_horse_index_array)

            for moving_horse_index in moving_horse_index_array:
                current_stacked_horse_map[new_r][new_c].append(moving_horse_index)
                horse_location_and_directions[moving_horse_index][0], horse_location_and_directions[moving_horse_index][1] = new_r, new_c

            if len(current_stacked_horse_map[new_r][new_c]) >= 4:
                return turn_count

        turn_count += 1

    return -1

print(get_game_over_turn_count(k, chess_map, start_horse_location_and_directions))  # 2가 반환 되어야합니다

start_horse_location_and_directions = [
    [0, 1, 0],
    [1, 1, 0],
    [0, 2, 0],
    [2, 2, 2]
]
print("정답 = 9 / 현재 풀이 값 = ", get_game_over_turn_count(k, chess_map, start_horse_location_and_directions))

start_horse_location_and_directions = [
    [0, 1, 0],
    [0, 1, 1],
    [0, 1, 0],
    [2, 1, 2]
]
print("정답 = 3 / 현재 풀이 값 = ", get_game_over_turn_count(k, chess_map, start_horse_location_and_directions))