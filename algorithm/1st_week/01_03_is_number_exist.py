# 빅오 -> 최악의 경우
# 빅오메가 -> 최선의 경우
def is_number_exist(number, array):
    for element in array: # array의 길이만큼 아래 연산이 실행
        if number == element: # 비교 연산이 1번 실행
            return True # 시간복잡도는 N 만큼 걸린다.
    return False

result = is_number_exist
print("정답 = True 현재 풀이 값 =", result(3, [3,5,6,1,2,4])) # 운이 좋은 경우!! 시간 복잡도가 1밖에 안걸림
# -> 최선의 경우에는 1만큼의 연산만 필요하다.
print("정답 = Flase 현재 풀이 값 =", result(7, [6,6,6])) # 운이 좋지 않은 경우!!
# -> 이 경우에는 배열의 끝까지 찾아야 하기 때문에, 시간복잡도가 N 만큼 걸린다.
print("정답 = True 현재 풀이 값 =", result(2, [6,9,2,7,1888]))