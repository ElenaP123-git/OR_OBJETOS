# MÁXIMOS Y MÍNIMOS

lista = []
for i in range (10):
    num = int(input("Introduce un número: "))
lista.append(num)

maximo = lista[0]
minimo = lista[0]

for x in lista:      # aquí el programa lee el max y min
    if x < minimo:
        minimo = x
    elif x > maximo:
        maximo = x

for x in lista:      # aquí se imprime todo
    if x == maximo:
        print(x, "--> maximo")
    elif x == minimo:
        print(x, "--> mínimo")
    else:
        print(x)
