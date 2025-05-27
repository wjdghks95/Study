N = int(input())
words = set(input().strip() for _ in range(N))  # 중복 제거

sorted_words = sorted(words, key=len)

for word in sorted_words:
    print(word)