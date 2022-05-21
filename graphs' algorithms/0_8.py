import queue
def bfs(i, counter):
    q =queue.Queue()
    visited[i]=True
    q.put(i)
    while not q.empty():
        counter += 1
        v = q.get()
        order_of_going[v] = str(counter)
        for u in range(n):
            if (matrix[v][u] == 1) and not visited[u]:
                visited[u] = True
                q.put(u)
    return counter
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
counter = 0
for i in range(n):
    if not visited[i]:
        counter = bfs(i, counter)




file.close()
file = open("output.txt", "w")
file.write(" ".join(order_of_going))
file.close()
