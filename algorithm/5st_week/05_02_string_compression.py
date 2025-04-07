input = "abcabcabcabcdededededede"

# 1 개의 길이
# a
# b
# c
# a ...
#
# 2 개의 길이
# ab
# ca
# bc
# ab

# 모든 경우에서 가장 압축을 많이 시킨 문자열의 길이를 반환해야 한다.
# 문자열의 길이를 n 이라고 한다면, 1부터 n개 까지 길이로 쪼갤 수 있다는 걸 의미한다.
#
# 1 ~ n//2

def string_compression(string):
    n = len(string)
    result = n
    for split_size in range(1, n // 2 + 1):

        # for i in range(0, n, split_size):
        #     print(i, string[i:i+split_size])
        #     splited.append(string[i:i+split_size])

        splited = [
            string[i:i + split_size] for i in range(0, n, split_size)
        ]

        compressed = ""
        count = 1
        for i in range(0, len(splited) - 1):
            cur, next = splited[i], splited[i + 1]

            if cur == next:
                count += 1
            else:
                if count == 1:
                    compressed += cur
                else:
                    compressed += f"{count}{cur}"
                count = 1

        if count == 1:
            compressed += splited[-1]
        else:
            compressed += f"{count}{splited[-1]}"

        result = min(len(compressed), result)

        print("splited is ", splited)
        print("compressed is ", compressed)
        print("compressed len is ", len(compressed))

    return result


print(string_compression(input))  # 14 가 출력되어야 합니다!

print("정답 = 3 / 현재 풀이 값 = ", string_compression("JAAA")) # J3A
print("정답 = 9 / 현재 풀이 값 = ", string_compression("AZAAAZDWAAA")) # AZ3AZDW3A
print("정답 = 12 / 현재 풀이 값 = ", string_compression('BBAABAAADABBBD')) # 2B2AB3ADA3BD

