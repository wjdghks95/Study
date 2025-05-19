import math

a, b = map(int, input().split())

# gcd = math.gcd(a, b) # 최대 공약수
# lcm = math.lcm(a,b) # lcm = (a * b) // gcd # 최소 공배수

def gcd(a,b):
    while b != 0:
        a, b = b, a % b
    return a

g = gcd(a, b)
l = (a * b) // g

print(g)
print(l)