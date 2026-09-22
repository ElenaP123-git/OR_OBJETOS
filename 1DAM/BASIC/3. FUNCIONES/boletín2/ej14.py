# Matriz posición (IA)

def matrizPosicion(filas, columnas):
    matriz = []
    for i in range(filas):
        fila = []
        for j in range(columnas):
            fila.append(i + j)
        matriz.append(fila)
    return matriz

print(matrizPosicion(4, 5))
