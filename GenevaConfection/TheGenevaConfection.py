t = int(input())
for i in range(t):
    n = int(input())
    rail_cars = [0]
    for l in range(n):
        rail_cars.append(int(input()))
    branch = [0]
    wanted_number = 1
    yummy = True
    while True:
        length = len(rail_cars)
        if rail_cars[len(rail_cars) - 1] == wanted_number:
            rail_cars.pop(len(rail_cars) - 1)
            wanted_number += 1
        elif branch[len(branch) - 1] == wanted_number:
            branch.pop(len(branch) - 1)
            wanted_number += 1
        elif length > 1:
            branch.append(rail_cars[len(rail_cars) - 1])
            rail_cars.pop(len(rail_cars) - 1)
        else:
            yummy = False
            break
        if wanted_number - 1 == n:
            break
    if yummy:
        print("Y")
    else:
        print("N")