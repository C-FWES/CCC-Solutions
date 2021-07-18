def get_nearest_vowel(vowels: list, cosonant_sections: list, letter):
    for i in range(len(cosonant_sections)):
        if letter in cosonant_sections[i]:
            return vowels[i]


def get_nearest_consonant(consonants_list, letter):
    good = ""
    to_list = list(consonants_list)
    for i in range(len(to_list) - 1):
        if to_list[i] == letter:
            good = to_list[i+1]
            break
    return good


original_string = input()
vowels = ['a', 'e', 'i', 'o', 'u']
consanant_list = "bcdfghjklmnpqrstvwxyzz"

consonants = [False for x in range(256)]

consonants[ord('b')] = True
consonants[ord('c')] = True
consonants[ord('d')] = True
consonants[ord('f')] = True
consonants[ord('g')] = True
consonants[ord('h')] = True
consonants[ord('j')] = True
consonants[ord('k')] = True
consonants[ord('l')] = True
consonants[ord('m')] = True
consonants[ord('n')] = True
consonants[ord('p')] = True
consonants[ord('q')] = True
consonants[ord('r')] = True
consonants[ord('s')] = True
consonants[ord('t')] = True
consonants[ord('v')] = True
consonants[ord('w')] = True
consonants[ord('x')] = True
consonants[ord('y')] = True
consonants[ord('z')] = True

consonant_sections = ["bc", "dfg", "hjkl", "mnpqr", "stvwxyz"]
new_string = ""
for s in original_string:
    if consonants[ord(s)]:
        new_string = new_string + s + get_nearest_vowel(vowels, consonant_sections, s) + get_nearest_consonant(consanant_list, s)
    else:
        new_string = new_string + s
print(new_string)
