def calcularMaxMin(lista):
    max = lista[0]
    min = lista[0]
    for i in range(len(lista)):
        if lista[i] > max:
            max = lista[i]
        elif lista[i] < min:
            min = lista[i]
    return max, min

lista = []
for i in range(10):
    num = int(input("Introduce un número: "))
    lista.append(num)
print("La lista de números es: ", lista)

resultado = calcularMaxMin(lista) # o también--> maximo, minimo = calcularMaxMin(lista)
print("El máximo es: ", resultado[0], "y el mínimo: ", resultado[1])