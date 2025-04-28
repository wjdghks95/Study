from itertools import permutations
import re

def solution(expression):
    answer = 0

    operation_list = []
    if "*" in expression:
        operation_list.append("*")
    if "+" in expression:
        operation_list.append("+")
    if "-" in expression:
        operation_list.append("-")
    operation_permutations = list(permutations(operation_list))
    print("operation_permutations is ", operation_permutations)

    expression = re.split("([^0-9])", expression)

    for operation_permutation in operation_permutations:
        copied_expression = expression[:]
        for operator in operation_permutation:
            while operator in copied_expression:
                op_index = copied_expression.index(operator)

                # if copied_expression[op_index] == "*":
                #     cal = int(copied_expression[op_index - 1]) * int(copied_expression[op_index + 1])
                # if copied_expression[op_index] == "+":
                #     cal = int(copied_expression[op_index - 1]) + int(copied_expression[op_index + 1])
                # if copied_expression[op_index] == "-":
                #     cal = int(copied_expression[op_index - 1]) - int(copied_expression[op_index + 1])
                cal = str(eval(copied_expression[op_index - 1] + copied_expression[op_index] + copied_expression[op_index + 1]))
                print("cal is ", cal)

                copied_expression[op_index - 1] = cal
                copied_expression = copied_expression[:op_index] + copied_expression[op_index + 2:]
                print("copied_expression is ", copied_expression)

                answer = max(answer, abs(int(copied_expression[0])))

    return answer

expression = "100-200*300-500+20" # 60420
print(solution(expression))

expression = "50*6-3*2" # 300
print(solution(expression))