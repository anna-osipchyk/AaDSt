import array

file = open("input.txt")
n = int(file.readline())
arr = array.array('i', range(n+1))
i = 1
string = file.readline().split()
is_heap = True
arr[0] = -2147483648
for el in string:
    arr[i] = int(el)

    if arr[i//2] > arr[i]:
        is_heap = False
    i += 1
file.close()
file = open("output.txt", "w")
if is_heap:
    file.write("Yes")
else:
    file.write("No")
file.close()
