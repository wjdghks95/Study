from itertools import combinations

def make_all_cases(user_info_array):
    all_cases_from_user = []

    for i in range(5):
        combination_array = combinations([0,1,2,3], i)
        for combination in combination_array:
            case = ""

            for j in range(4):
                if j in combination:
                    case += user_info_array[j]
                else:
                    case += "-"

            all_cases_from_user.append(case)

    return all_cases_from_user

def get_lower_bound(target, array):
    current_min = 0
    current_max = len(array)

    while current_min < current_max:
        current_guess = (current_min + current_max) // 2
        if array[current_guess] >= target:
            current_max = current_guess
        else:
            current_min = current_guess + 1

    return current_max


def solution(info, query):
    answer = []
    all_cases_from_users = {}

    for user_info in info:
        user_info_array = user_info.split()
        all_cases_from_user = make_all_cases(user_info_array)
        # print("all_cases_from_user is ", all_cases_from_user)

        for case in all_cases_from_user:
            if case not in all_cases_from_users.keys():
                all_cases_from_users[case] = [int(user_info_array[4])]
            else:
                all_cases_from_users[case].append(int(user_info_array[4]))

    for key in all_cases_from_users.keys():
        all_cases_from_users[key].sort()

    # print(all_cases_from_users)

    for query_info in query:
        query_info_array = query_info.split()
        case = query_info_array[0] + query_info_array[2] + query_info_array[4] + query_info_array[6]

        if case in all_cases_from_users.keys():
            target_users = all_cases_from_users[case]
            answer.append(len(target_users) - get_lower_bound(int(query_info_array[7]), target_users))
        else:
            answer.append(0)

    return answer

info = ["java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"]
query = ["java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"]

print(solution(info, query)) # [1,1,1,1,2,4]
