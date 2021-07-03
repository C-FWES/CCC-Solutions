class Observation:
    def __init__(self, time, spot):
        self.time = time
        self.spot = spot


n = int(input())
count = n
observations1 = []
while count > 0:
    s = input().split(" ")
    observations1.append(Observation(int(s[0]), int(s[1])))
    count -= 1
observations1.sort(key=lambda x: x.time)
time_diff = 0
meter_diff = 0
temp = 0.0
max_divided = 0.0
for i in range(len(observations1) - 1):
    time_diff = observations1[i+1].time - observations1[i].time
    meter_diff = abs(observations1[i+1].spot - observations1[i].spot)
    temp = 1.0 * meter_diff / time_diff
    if temp > max_divided:
        max_divided = temp
print(max_divided)