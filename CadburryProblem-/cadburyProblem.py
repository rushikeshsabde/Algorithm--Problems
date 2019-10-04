# print(f"Enter your M ,N ,P ,Q values")
m = int(input())
n = int(input())
p = int(input())
q = int(input())

 # print(f"{m},{n},{p},{q}")
# m=5
# n=6
# p=3
# q=4

if m>n:
    min1 = n
    max1 = m
else:
    min1 = m
    max1 = n
    
mainList=[]
while min1<=max1:

    if p>q:
        min2 = q
        max2 = p
    else:
        min2 = p
        max2 = q

    while min2<=max2:
        subList=[]
        subList.append(min1)
        subList.append(min2)
        min2 = min2+1
        mainList.append(subList)
    min1 = min1+1
# print(mainList)

# processing the individual item in mainList

processedList=[]
count=0

for item in mainList:
    # print(item)
    if(item[0]==item[1]):
        processedList.append(item)
    elif(item[0]>item[1]):
        maxItem = item[0]
        minItem = item[1]
    else:
        maxItem = item[1]
        minItem = item[0]
    while maxItem!=1 or minItem!=1:
        subList = []
        subList.append(minItem)
        subList.append(minItem)
        processedList.append(subList)
        buffer = (maxItem-minItem)
        if buffer==0:
            break
        if buffer>minItem:
            maxItem = buffer
            minItem = minItem
        else:
            maxItem = minItem
            minItem = buffer
    else:
        subList = []
        subList.append(minItem)
        subList.append(minItem)
        processedList.append(subList)

# print(processedList)
print(len(processedList))            




