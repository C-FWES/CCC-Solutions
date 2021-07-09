class City:
    def __init__(self, city_name, temperature):
        self.city_name = city_name
        self.temperature = int(temperature)


cities = []
while True:
    s = input().split(" ")
    cities.append(City(s[0], s[1]))
    if s[0] == 'Waterloo':
        break
coldest = 201
city = ""
for c in cities:
    temperature = c.temperature
    if temperature < coldest:
        coldest = temperature
        city = c.city_name
print(city)