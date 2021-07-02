def check(first, second):
    first = first.replace(" ", "")
    second = second.replace(" ", "")
    l1 = len(first)
    l2 = len(second)
    if l1 != l2:
        return False
    count = [0 for i in range(256)]
    i = 0
    for i in range(l1):
        count[ord(first[i]) - ord('A')] += 1
        count[ord(second[i]) - ord('A')] -= 1
    for i in range(256):
        if count[i] != 0:
            return False
            break
    return True


first = input()
second = input()
if check(first, second):
    print("Is an anagram.")
else:
    print("Is not an anagram.")
