books_sequence = input()
num_of_l = 0
num_of_m = 0
num_of_s = 0
for x in books_sequence:
    if x == 'L':
        num_of_l += 1
    elif x == 'M':
        num_of_m += 1
    elif x == 'S':
        num_of_s += 1
large = []
medium = []
small = []
k = 0
for i in range(num_of_l):
    large.append(books_sequence[k])
    k += 1
for i in range(num_of_m):
    medium.append(books_sequence[k])
    k += 1
for i in range(num_of_s):
    small.append(books_sequence[k])
    k += 1
l_in_m = 0
m_in_l = 0
s_in_m = 0
s_in_l = 0
for l in large:
    if l == 'M':
        m_in_l += 1
    elif l == 'S':
        s_in_l += 1
for m in medium:
    if m == 'L':
        l_in_m += 1
    elif m == 'S':
        s_in_m += 1
minimum_swap = m_in_l + s_in_l + l_in_m + s_in_m - (min(l_in_m, m_in_l))
print(minimum_swap)

