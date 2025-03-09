input = 20

# 소수는 자기 자신과 1외에는 아무것도 나눌 수 없다.
def find_prime_list_under_number(number):
    '''
    prime_list = []
    for num in range(2, number + 1):
        prime = True

        for under_num in range(2, num):
            if num % under_num == 0:
                prime = False
                break

        if prime: prime_list.append(num)

    return prime_list
    '''

    prime_list = []

    # 2~20 까지 찾아서
    for n in range(2, number + 1): # 2~n 까지의 숫자들이 n 에 들어가는 것을 반복한다.
        # 이것들이 소수인가? 소수라면 prime_list 에 넣어라!
        # for i in range(2, n): # 2 부터 n-1 까지를 i에 들어가는 것을 반복한다.
        for i in prime_list:  # n 보다 작은 모든 소수에 대해서
            # if n % i == 0:
            if i * i <= n and n % i == 0: # N의 제곱근보다 크지 않은 어떤 소수로도 나누어 떨어지지 않는다.
                break
        else:
            prime_list.append(n)

    return prime_list

result = find_prime_list_under_number(input)
print(result)