# Máximo de toda la matriz

matriz = [
    [8, 1, 6],
    [3, 5, 7],
    [4, 9, 2]
]

def maximoMatriz(matriz):
    max = matriz[0][0] # necesito empezar con un número
    for i in range(len(matriz)):
        for x in matriz[i]: # recorro filas
            if x > max:
                max = x
    return max

print("El maximo de la matriz completa es: ", maximoMatriz(matriz))