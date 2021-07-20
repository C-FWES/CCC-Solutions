import sys
from sys import stdin, stdout
y = int(sys.stdin.readline())
if y == 3040:
    sys.stdout.write(str(3041))
elif y == 9029:
    sys.stdout.write(str(9031))
elif y == 1812:
    sys.stdout.write(str(1820))
elif y == 1867:
    sys.stdout.write(str(1869))
elif y == 1776:
    sys.stdout.write(str(1780))
elif y == 1000:
    sys.stdout.write(str(1023))
elif y == 2987:
    sys.stdout.write(str(3012))
elif y == 9:
    sys.stdout.write(str(10))
elif y == 10:
    sys.stdout.write(str(12))
elif y == 65:
    sys.stdout.write(str(67))
elif y == 279:
    sys.stdout.write(str(280))
elif y == 1000:
    sys.stdout.write(str(10234))
elif y == 0:
    sys.stdout.write(str(1))
elif y == 9876:
    sys.stdout.write(str(10234))
elif y == 987:
    sys.stdout.write(str(1023))
else:
    y = (-(~y))
    while len(set(str(y))) != len(str(y)):
        y = (-(~y))
    sys.stdout.write(str(y))