# TROZO DE NÚMERO

num = input(("Introduce el número: "))

primero = int(input("Posición inicial: "))
último = int(input("Posición final: "))

num = num[primero + 1:último]

print(num)