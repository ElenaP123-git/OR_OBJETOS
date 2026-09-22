def calcularMax(lista):
    max = lista[0]
    for i in range(len(lista)):
        if lista[i] > max:
            max = lista[i]
    return max

lista =[]
for i in range(10):
    lista1 = int(input("Introduce un número: "))
    lista.append(lista1)
print("La lista es: ", lista)

resultado = calcularMax(lista)
print("El máximo es: ",resultado)