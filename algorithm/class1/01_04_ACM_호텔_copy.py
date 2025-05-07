T = int(input())  # 테스트 케이스 수

for _ in range(T):
    H, W, N = map(int, input().split())

    # 층수 구하기 (N % H == 0이면 꼭대기 층)
    floor = N % H
    print("floor is ", floor)
    if floor == 0:
        floor = H

    # 호수 구하기 (올림처리 필요)
    room_number = (N - 1) // H + 1

    # 방 번호 출력 (층수 + 호수, 호수는 2자리로 출력)
    print(f"{floor}{room_number:02}")
