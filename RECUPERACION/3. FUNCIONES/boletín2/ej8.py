# Suma de una columna (columna → suma)

matriz = [
    [8, 1, 6],
    [3, 5, 7],
    [4, 9, 2]
]

def sumaColumna(matriz,columna):
    suma = 0
    colu = []
    for i in range(len(matriz)):
        colu.append(matriz[i][columna])
    for x in colu:
        suma = suma + x
    return suma

print("La suma de la columna es: ", sumaColumna(matriz,1))
