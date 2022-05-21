counter = 1


def dfs(v):
    global counter
    print(counter)
    visited[v] = True
    order_of_going[v] = str(counter)
    for u in range(n):
        if matrix[v][u] == 1 and visited[u] is False:
            counter += 1
            dfs(u)


file = open("input.txt")
n = int(file.readline())
matrix = [[0 for _ in range(n)] for _ in range(n)]
for i, line in enumerate(file):
    line1 = line.split()
    for j, el in enumerate(line1):
        if int(el) == 1:
            matrix[i][j] = 1

order_of_going = ['0' for _ in range(n)]
visited = [False for _ in range(n)]
for i, visit in enumerate(visited):
    if not visit:
        dfs(i)
        counter += 1

file.close()
file = open("output.txt", "w")
file.write(" ".join(order_of_going))
file.close()
