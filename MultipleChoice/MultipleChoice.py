n = int(input())
student = []
correct = []
i = 0
while i < n * 2:
    if i >= n:
        correct.append(input())
    else:
        student.append(input())
    i += 1
correct_count = 0
for i in range(n):
    if i == n - 1 and student[i] != correct[i]:
        break
    if student[i] == correct[i]:
        correct_count += 1
print(correct_count)
