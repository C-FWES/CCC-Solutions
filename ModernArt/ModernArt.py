m = int(input())
n = int(input())
k = int(input())
rows = set()
columns = set()
for i in range(k):
    paints = input().split(" ")
    direction = paints[0]
    number = paints[1]
    if direction == 'R':
        if number in rows:
            rows.remove(number)
        else:
            rows.add(number)
    else:
        if number in columns:
            columns.remove(number)
        else:
            columns.add(number)
total = 0
total += m * len(columns)
total += n * len(rows)
total -= 2 * len(columns) * len(rows)
print(total)