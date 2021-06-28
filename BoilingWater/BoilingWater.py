boilingTemp = int(input())
p = 5*boilingTemp-400
if p == 100:
    print(p)
    print(0)
elif p > 100:
    print(p)
    print(-1)
else:
    print(p)
    print(1)

