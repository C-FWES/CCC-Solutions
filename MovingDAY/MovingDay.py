class House:
    def __init__(self, house_number, is_occupied=False):
        self.house_number = int(house_number)
        self.is_occupied = is_occupied


class Person:
    def __init__(self, name, current_address, moving_to_address):
        self.name = name
        self.current_address = int(current_address)
        self.moving_to_address = int(moving_to_address)


def get_person_with_vacant(persons: list, houses: list, ordered: list, n: int):
    for house in houses:
        if not house.is_occupied:
            for person in persons:
                if person.moving_to_address == house.house_number:
                    house.is_occupied = True
                    old_index = [x.house_number for x in houses].index(person.current_address)
                    houses[old_index].is_occupied = False
                    person.current_address = house.house_number
                    person.moving_to_address = -1
                    ordered.append(person.name)
                    persons.remove(person)
                    get_person_with_vacant(persons, houses, ordered, n)
    if len(ordered) == n:
        return ordered


n = int(input())
count = n
check = n
persons = []
current_adresses = []
new_adresses = []
while count > 0:
    s = input().split(" ")
    persons.append(Person(s[0], s[1], s[2]))
    current_adresses.append(int(s[1]))
    new_adresses.append(int(s[2]))
    count -= 1
current_adresses.sort()
new_adresses.sort()
street_set = set(current_adresses + new_adresses)
for i in range(n):
    if current_adresses[i] == new_adresses[i]:
        check -= 1
if check == 0:
    print("Impossible")
else:
    street = list(street_set)
    ordered = []  # ordered names
    houses = []
    for i in range(len(street)):
        if street[i] in current_adresses:
            houses.append(House(street[i], True))
        else:
            houses.append(House(street[i], False))
    ordered = get_person_with_vacant(persons, houses, ordered, n)
    if not ordered:
        print("Impossible")
    else:
        for o in ordered:
            print(o)
