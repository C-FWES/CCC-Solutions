directions = []
while True:
    line = input()
    if line == "SCHOOL":
        break
    if line:
        directions.append(line)
    else:
        break

size = len(directions)
j = 0
newDirections = []
for i in range(size-1, -1, -2):
    dir = directions[i]
    if dir == "R":
        if i == 0:
            newDirections.append("Turn LEFT into your HOME.")
        else:
            location = directions[i-1]
            newDirections.append("Turn LEFT onto " + location + " street.")

    elif dir == "L":
        if i == 0:
            newDirections.append("Turn RIGHT into your HOME.")
        else:
            location = directions[i - 1]
            newDirections.append("Turn RIGHT onto " + location + " street.")

for d in newDirections:
    print(d)
