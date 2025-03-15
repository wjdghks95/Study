input = "abcba"


def is_palindrome(string):
    n = len(string)
    for i in range(n):
        if string[i] == string[n-1-i]:
            return True
    return False


print(is_palindrome(input))