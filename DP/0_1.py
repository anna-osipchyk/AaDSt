import numpy as np
file = open("input.txt")
amount = file.readline()
sizes =[line.split() for line in file]
sizes = sum(sizes,[])
last =sizes[-1]
sizes = [int(sizes[idx]) for idx in range(len(sizes)) if idx%2==0]
sizes.append(int(last))
size = len(sizes)-1
table = np.zeros((size, size))
for l in range(1, size):
    for i in range(size-l):
        j = i+l
        table[i][j] = 2000000000
        for k in range(i,j):
            table[i][j] = min(table[i][j], table[i][k]+table[k+1][j]+sizes[i]*sizes[k+1]*sizes[j+1])
file = open("output.txt", "w")
print(int(table[0][size-1]), file=file)
file.close()
