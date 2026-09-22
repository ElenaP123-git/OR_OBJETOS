# CONDICIONALES

# Esto no es del boletín pero está curioso
for i in range(2, 4):
    for j in range(1, 11):
        print(i, "*", j, "=", i*j)

numero1 = int(input("Introduce un número: "))
if numero1 > 18 and numero1 < 30:
    print("La variable es mayor que 18 y menor que 30")
else:
    print("Nop")