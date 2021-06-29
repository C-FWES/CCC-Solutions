import math


def is_prime(number: int):
    if number % 2 == 0:
        return False
    end = math.floor(math.sqrt(number))
    for i in range(3, end + 1, 2):
        if number % i == 0:
            return False
    return True


def get_primes(inputs: list):
    good_primes = []
    for n in inputs:
        j = n * 2 - 2
        double_n = n * 2 - 1
        if j > 1:
            for i in range(2, double_n):
                if is_prime(i) and is_prime(j):
                    primes = [i, j]
                    good_primes.append(primes)
                    break
                j -= 1
    for good_prime in good_primes:
        print(good_prime[0], end=" ")
        print(good_prime[1], end="")
        print()


inputs = []
total = int(input())
while total > 0:
    line = int(input())
    inputs.append(line)
    total -= 1
get_primes(inputs)
