time = int(input())
chore_choices = int(input())
c = chore_choices
chores = []
while c > 0:
    chores.append(int(input()))
    c -= 1
chores.sort()
total = 0
i = 0
while i < len(chores) and total <= time:
    total += chores[i]
    i += 1
if total > time:
    print(i-1)
else:
    print(total)