# Igualdad de sumas
# que (IA)

matriz = [
    [8, 1, 6],
    [3, 5, 7],
    [4, 9, 2]
]

def sumaPorFilasIgual(matriz):
    suma_ref = 0
    for x in matriz[0]:
        suma_ref += x

    for i in range(1, len(matriz)):
        suma = 0
        filas = matriz[i]
        for x in filas:
            suma = suma + x
        if suma != suma_ref:
            return False
        else:
            return True

def sumaColumna(matriz, columna):
    total = 0
    for i in range(len(matriz)):
        total += matriz[i][columna]
    return total

def sumaPorColumnasIgual(matriz):
    columnas = len(matriz[0])
    suma0 = sumaColumna(matriz, 0)
    for j in range(columnas):
        if sumaColumna(matriz, j) != suma0:
            return False
        else:
            return True


def sumaTotalIgual(matriz):
    return sumaPorFilasIgual(matriz) and sumaPorColumnasIgual(matriz)

print(sumaPorFilasIgual(matriz))   # → True
print(sumaPorColumnasIgual(matriz))   # → True
print(sumaTotalIgual(matriz))   # → True
