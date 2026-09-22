# para la tabla del 3

contador = 0
while contador < 10:
    contador += 1
    multiplicacion = 3 * contador
    print(contador, "x 3 =", multiplicacion)
print("Fin")


# para cualquier número

n = int(input("Introduce la tabla que quieres ver: "))
for i in range (1,10+1):
    multiplicacion = n * i
    print(n, "x", i, "=",multiplicacion)
print("Fin")