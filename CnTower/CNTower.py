import math


def get_optimal_range(landmarks: list):
    landmarks.sort()
    length = len(landmarks) - 1
    max_range = (landmarks[0] + 360) - landmarks[length]
    for i in range(length):
        max_range = max(max_range, landmarks[i + 1] - landmarks[i])
    minimum_seconds = (360.0 - float(max_range)) * 12
    if isinstance(minimum_seconds, float):
        return math.ceil(minimum_seconds)
    return minimum_seconds


n = int(input())
landmarks = []
count = n
while count > 0:
    s = input().split(" ")
    landmarks.append(float(s[1]))
    count -= 1
time = get_optimal_range(landmarks)
print(time)
