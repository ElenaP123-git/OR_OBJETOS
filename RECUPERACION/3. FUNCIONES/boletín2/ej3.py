# Obtener columna completa columna → lista)

matriz = [
    [8, 1, 6],
    [3, 5, 7],
    [4, 9, 2]
]

def obtenerColumna(matriz,columna):
    colu = []
    for i in range(len(matriz)):
        colu.append(matriz[i][columna])
    return colu

print(obtenerColumna(matriz,2))