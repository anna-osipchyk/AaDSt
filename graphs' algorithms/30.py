import queue

f = open("input.txt")
n = int(f.readline())
degrees = [0 for _ in range(7)]
counter = 0
matrix = [[0 for _ in range(7)] for _ in range(7)]
start = 1000000
numbers = set()
for i, line in enumerate(f):
    data = line.split()
    u, v = int(data[0]), int(data[1])
    counter += 1
    numbers.add(u)
    numbers.add(v)
    degrees[u] += 1
    degrees[v] += 1
    if u >= v:
        start = min(v, start)
    elif u < v:
        start = min(u, start)

    matrix[u][v] = 1
    matrix[v][u] = 1
file = open("output.txt", "w")
if counter != n:
    file.write("No")
    file.close()
else:
    visited = [False for _ in range(7)]
    q = queue.Queue()
    visited[start] = True
    q.put(start)
    counter = 0

    while not q.empty():
        v = q.get()
        for u in range(7):
            if (matrix[v][u] == 1) and not visited[u]:
                visited[u] = True
                q.put(u)

    flag = True
    counter = 0
    for i, el in enumerate(visited):
        if el is False and i in numbers:
            file.write("No")
            flag = False
            file.close()
            break
        elif el is True:
            counter += 1

    if flag:

        c_o_e = 0
        flag = True

        for el in degrees:
            if el % 2 == 1:
                file.write("No")
                file.close()
                flag = False
                break
        if flag:
            file.write("Yes")
            file.close()
