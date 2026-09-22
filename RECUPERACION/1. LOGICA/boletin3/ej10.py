import random
aleatorio = random.randint(0,10)
aleatorio2 = random.randint(0,10)
suma = aleatorio + aleatorio2
num = int(input("Introduce la suma de ambos números: "))

while num != suma:
    print("Incorrecto!")
    num = int(input("Intente de nuevo: "))
print("Acertaste!")