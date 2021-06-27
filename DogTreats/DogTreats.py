smallTreats = int(input())
mediumTreats = int(input())
largeTreats = int(input())

isHappy = 1*smallTreats+2*mediumTreats+3*largeTreats
if isHappy >= 10:
    print("happy")
else:
    print("sad")
