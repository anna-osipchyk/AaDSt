from math import factorial


def mul(a, b):
    c = 1
    for i in range(a + 1, b + 1):
        c *= i
    return c

  
N, K = (input()).split()
N = int(N)
K = int(K)
max_num = max(K, N - K)
min_num = min(K, N - K)
fact = factorial(min_num)
answer = mul(max_num, N) // fact
answer = answer % (10 ** 9 + 7)
print(answer)
