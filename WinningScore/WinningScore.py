app3 = int(input())*3
app2 = int(input())*2
app1 = int(input())
b3 = int(input())*3
b2 = int(input())*2
b1 = int(input())

apples = app3+app2+app1
bananas = b3+b2+b1
if apples > bananas:
    print("A")
elif bananas > apples:
    print("B")
else:
    print("T")