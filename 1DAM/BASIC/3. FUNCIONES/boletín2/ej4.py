# Suma total de la matriz (sumatorio de todos los elementos)
# siempre que hay que recorrer la matríz, se necesitan 2 for

matriz = [
    [8, 1, 6],
    [3, 5, 7],
    [4, 9, 2]
]

def sumaMatriz(matriz):
    suma = 0
    for filas in matriz:
        for elementos in filas:
            suma = suma + elementos
    return suma

resultado = sumaMatriz(matriz)
print("La suma de la matríz es: ", resultado)
