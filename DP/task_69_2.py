from array import array

n = int(input())
flowers = input().split()
flowers = list(map(int, flowers))
frog = array('i', [0 for _ in range(n)])
if n == 1:
    print(flowers[0])
    print(1)
elif n == 2:
    print(-1)
elif n == 3:
    print(flowers[0]+flowers[2])
    print("1 3")
else:
    frog[0] = flowers[0]
    frog[2] = frog[0] + flowers[2]
    inf = float('-inf')
    frog[1] = -1
    idx = [str(n)]
    j = n-1
    for i in range(3, n):
        frog[i] = max(frog[i - 2], frog[i - 3]) + flowers[i]
    while j >= 2:

        if j == 2 or frog[j - 2] > frog[j - 3]:

            j -= 2
        else:
            j -= 3
        idx.append(str(j+1))
    print(frog[n-1])
    string = (" ".join(idx[::-1]))

    print(string)
