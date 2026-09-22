# Obtener elemento por posición (fila, columna → elemento)

matriz = [
    [8, 1, 6],
    [3, 5, 7],
    [4, 9, 2]
]

def obtenerElemento(matriz, fila, columna):
    return matriz[fila][columna] 

print(obtenerElemento(matriz, 1, 2)) # fila 2, columna 3