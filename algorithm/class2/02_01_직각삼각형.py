'''
문제
과거 이집트인들은 각 변들의 길이가 3, 4, 5인 삼각형이 직각 삼각형인것을 알아냈다. 주어진 세변의 길이로 삼각형이 직각인지 아닌지 구분하시오.

입력
입력은 여러개의 테스트케이스로 주어지며 마지막줄에는 0 0 0이 입력된다. 각 테스트케이스는 모두 30,000보다 작은 양의 정수로 주어지며, 각 입력은 변의 길이를 의미한다.

출력
각 입력에 대해 직각 삼각형이 맞다면 "right", 아니라면 "wrong"을 출력한다.

예제 입력 1
6 8 10
25 52 60
5 12 13
0 0 0
예제 출력 1
right
wrong
right
'''
import math

while True:
    line_list = list(map(int,input().split()))
    if line_list == [0]*3:
        break

    max_line = max(line_list)
    line_list.remove(max_line)

    if math.pow(max_line, 2) == math.pow(line_list[0], 2) + math.pow(line_list[1], 2):
        print("right")
    else:
        print("wrong")

    '''
    a, b, c = map(int, input().split())
    if a == 0 and b == 0 and c == 0:
        break
        
    sides = sorted([a, b, c])  # 가장 큰 변이 마지막에 오도록 정렬
    if sides[0]**2 + sides[1]**2 == sides[2]**2:
        print("right")
    else:
        print("wrong")
    '''