n = int(input())
day1 = input()
day2 = input()
count = 0
for i in range(n):
    if day1[i] == 'C' and day2[i] == 'C':
        count = count + 1
    i += 1

print(count)
