def check_if_monkey(word: str):
    while 'ANA' in word or 'BAS' in word:
        word = word.replace('ANA', 'A')
        word = word.replace('BAS', 'A')
    return word == 'A'


words = []
while True:
    l = input()
    if l == 'X':
        break
    else:
        words.append(l)

for w in words:
    print("YES") if check_if_monkey(w) else print("NO")
