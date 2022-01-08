class Friend:
    def __init__(self, field_position, max_walk, range):
        self.field_position = field_position
        self.max_walk = max_walk
        self.range = range

def calculate_walking_time(mid: int, friends: list):
    total = 0
    for friend in friends:
        distance = 0
        distance += abs(mid-friend.field_position)-friend.range
        if distance > 0:
            total += distance*friend.max_walk
    return total


n = int(input())
friends = []
high = 0
low = 2147483647
for i in range(n):
    friend = input().split(" ")
    if int(friend[0]) > high:
        high = int(friend[0])
    if int(friend[0]) < low:
        low = int(friend[0])
    friends.append(Friend(int(friend[0]), int(friend[1]), int(friend[2])))

mid = 0
s = 0

while high >= low:
    mid = int((low+high)/2)
    s = calculate_walking_time(mid, friends)
    left_of_s = calculate_walking_time(mid-1, friends)
    right_of_s = calculate_walking_time(mid+1, friends)
    if s < right_of_s and s < left_of_s:
        break
    if s == right_of_s and s == left_of_s:
        break
    if s < right_of_s:
        high = mid-1
    if s < left_of_s:
        low = mid+1
print(s)
