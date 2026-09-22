# Suma de una fila (fila → suma)

matriz = [
    [8, 1, 6],
    [3, 5, 7],
    [4, 9, 2]
]

def sumaFila(matriz,fila):
    suma = 0
    for i in matriz[fila]: # dentro de la fila que se elija
        suma = suma + i
    return suma

print("La suma de la fila, es: ", sumaFila(matriz,1))