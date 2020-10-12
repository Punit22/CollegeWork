
def lru(processlist, capacity, list, tracklist):
    global equal
    count = capacity
    hits = 0
    for i in range(capacity):
        if (list[i] == -1):
            list[i] = processlist[i]
            hits += 1
            if i == 1:
                tracklist[0] += 1
            elif i==2:
                tracklist[0] += 1
                tracklist[1] += 1

    for i in range(capacity, len(processlist)):
        equal = False
        for j in range(len(list)):
            if processlist[i] == list[j]:
                tracklist[j] = 0
                x = 0
                display(list, x, count)
                if j == 0:
                    tracklist[j + 1] += 1
                    tracklist[j + 2] += 1
                elif j == 1:
                    tracklist[j - 1] += 1
                    tracklist[j + 1] += 1
                else:
                    tracklist[j - 2] += 1
                    tracklist[j - 1] += 1
                equal = True

        if not equal:
            pos = tracklist.index(max(tracklist))
            list[pos] = processlist[i]
            hits += 1
            tracklist[pos] = 0
            if pos == 0:
                tracklist[pos+1] += 1
                tracklist[pos+2] += 1
            elif pos == 1:
                tracklist[pos-1] += 1
                tracklist[pos+1] += 1
            else:
                tracklist[pos-2] += 1
                tracklist[pos-1] += 1
            x = 1
            display(list, x, count)
    print("Hits : ", hits)

def display(list2, x, count):
    if(x == 1):
        print("{",end=" ")
        for i in range(count):
            print(list2[i], end=" ")
        print("}")
    else:
        print("")
        for i in range(count):
            print(list2[i], end=" ")

processlist = [0, 4, 1, 4, 2, 4, 3, 4, 2, 4, 0, 4, 1, 4, 2, 4, 3, 4]
capacity = 3
list = [-1, -1, -1]
tracklist = [0, 0, 0]
lru(processlist, capacity, list, tracklist)


