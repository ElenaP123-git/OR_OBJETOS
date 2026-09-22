import random
aleatorio = random.randint(1,10)

num = int(input("Adivina el número 1-10: "))
while num != aleatorio:
    print("Fallaste!")
    num = int(input("Adivina el número 1-10: "))
print("Acertaste!")