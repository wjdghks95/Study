from collections import deque

balanced_parentheses_string = "()))((()"
'''
def get_correct_parentheses(balanced_parentheses_string):

    # 1. 입력이 빈 문자열인 경우 빈 문자열 반환
    if not balanced_parentheses_string:
        return ""

    # 2. 문자열 w를 두 균형잡힌 괄호 문자열 u, v로 분리. u는 균형잡힌 괄호 문자열로 더 이상 분리 X, v는 빈 문자열이 될 수 있다.
    # u = () 개수가 같으면서 개수가 똑같은 문자열로 더 이상 분리할 수 없다.
    # v = () 개수가 같거나 빈 문자열

    #  u      v
    # ()    ))((()
    # ))((    ()
    # ()    빈 문자열

    queue = deque()
    open = 0
    close = 0
    for parentheses_string in balanced_parentheses_string:

        if parentheses_string == "(":
            open += 1
        else:
            close += 1

        if open == close:
            break

    u, v = balanced_parentheses_string[0:open+close], balanced_parentheses_string[open+close:]

    # 3. 문자열 u가 올바른 문자열 이라면 문자열 v에 대해 다시 수행
    # 3-1 수행한 결과 문자열을 u에 이어 붙인 후 반환
    #     u = ()

    stack = []

    for str in u:
        if str == "(":
            stack.append(str)
        else:
            if not stack:
                stack.append(str)
                break
            stack.pop()

    if not stack:
        u += get_correct_parentheses(v)

        return u
    else:
        # 4.문자열 u가 "올바른 괄호 문자열"이 아니라면 아래 과정을 수행
        # u = ))((  v =  ()
        # 4-1. 빈 문자열에 첫 번째 문자로 '('를 붙인다.
        #    (
        # 4-2 문자열 v에 대해 1단계부터 재귀적으로 수행한 결과 문자열을 이어 붙인다.
        #  u = () v = 빈 문자열
        #    ()빈문자열

        # 4-3 )'를 다시 붙인다.
        #  (())
        correct_parentheses = "("
        correct_parentheses += get_correct_parentheses(v)
        correct_parentheses += ")"
        # 4-4. u의 첫 번째와 마지막 문자를 제거하고, 나머지 문자열의 괄호 방향을 뒤집어서 뒤에 붙입니다.
        #  u = ))((  v =  ()
        #  )( -> ()  -> (())()

        u = u[1:-1]
        reversed_u = ""
        for char in u:
            if char == '(':
                reversed_u += ')'
            elif char == ')':
                reversed_u += '('

        u = "".join(reversed_u)

        correct_parentheses += u

        # 4-5. 생성된 문자열을 반환합니다.
        # (())()
        # ()(())()

    return correct_parentheses
'''

def is_correct_parenthesis(string):
    stack = []
    for i in range(len(string)):
        if string[i] == "(":
            stack.append("(")
        elif string[i] == ")":
            if len(stack) == 0:
                return False
            stack.pop()

    if len(stack) != 0:
        return False
    else:
        return True


def separate_to_u_v(string):
    queue = deque(string)
    left_parenthesis_count, right_parenthesis_count = 0, 0
    u, v = "", ""

    while queue:
        char = queue.popleft()
        u += char

        if char == '(':
            left_parenthesis_count += 1
        if char == ')':
            right_parenthesis_count += 1

        if left_parenthesis_count == right_parenthesis_count:
            break

    v = ''.join(queue)

    return u, v


def reverse_parenthesis(string):
    reversed_string = ""
    for char in string:
        if char == '(':
            reversed_string += ')'
        elif char == ')':
            reversed_string += '('

    return reversed_string


def change_to_correct_parenthesis(balanced_parentheses_string):
    # 1. 입력이 빈 문자열인 경우, 빈 문자열을 반환합니다.
    if balanced_parentheses_string == '':
        return ""

    # 2. 문자열 w를 두 "균형잡힌 괄호 문자열" u, v로 분리합니다. 단, u는 "균형잡힌 괄호 문자열"로 더 이상 분리할 수 없어야 하며, v는 빈 문자열이 될 수 있습니다.
    u, v = separate_to_u_v(balanced_parentheses_string)

    # 3. 문자열 u가 "올바른 괄호 문자열" 이라면 문자열 v에 대해 1단계부터 다시 수행합니다.
    #   3-1. 수행한 결과 문자열을 u에 이어 붙인 후 반환합니다.

    if is_correct_parenthesis(u):
        return u + change_to_correct_parenthesis(v)

    # 4. 문자열 u가 "올바른 괄호 문자열"이 아니라면 아래 과정을 수행합니다.
    #   4-1. 빈 문자열에 첫 번째 문자로 '('를 붙입니다.
    #   4-2. 문자열 v에 대해 1단계부터 재귀적으로 수행한 결과 문자열을 이어 붙입니다.
    #   4-3. ')'를 다시 붙입니다.
    #   4-4. u의 첫 번째와 마지막 문자를 제거하고, 나머지 문자열의 괄호 방향을 뒤집어서 뒤에 붙입니다.
    #   4-5. 생성된 문자열을 반환합니다.
    else:
        return "(" + change_to_correct_parenthesis(v) + ")" + reverse_parenthesis(u[1:-1])



def get_correct_parentheses(balanced_parentheses_string):
    if (is_correct_parenthesis(balanced_parentheses_string)):
        return balanced_parentheses_string
    else:
        return change_to_correct_parenthesis(balanced_parentheses_string)


print(get_correct_parentheses(balanced_parentheses_string))  # "()(())()"가 반환 되어야 합니다!

print("정답 = (((()))) / 현재 풀이 값 = ", get_correct_parentheses(")()()()("))
print("정답 = ()()( / 현재 풀이 값 = ", get_correct_parentheses("))()("))
print("정답 = ((((()())))) / 현재 풀이 값 = ", get_correct_parentheses(')()()()(())('))