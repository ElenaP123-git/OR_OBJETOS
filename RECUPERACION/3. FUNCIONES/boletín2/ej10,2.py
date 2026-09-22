# Mínimo de toda la matriz

matriz = [
    [8, 1, 6],
    [3, 5, 7],
    [4, 9, 2]
]

def minimoMatriz(matriz):
    min = matriz[0][0]
    n = len(matriz)
    for i in range(n):
        for x in matriz[i]: # recorro filas
            if x < min:
                min = x
    return min

print("El mínimo de la matriz es: ", minimoMatriz(matriz))