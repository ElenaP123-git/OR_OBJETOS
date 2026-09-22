# Diagonales solo si es cuadrada (NxN)
# (IA)

matriz = [
    [8, 1, 6],
    [3, 5, 7],
    [4, 9, 2]
]

def esCuadrada(matriz):
    return len(matriz) == len(matriz[0])

def diagonalPrincipalSegura(matriz):
    if not esCuadrada(matriz):
        return [] # no devuelve nada
    else:
        diagonal = []
        for i in range(len(matriz)):
            diagonal.append(matriz[i][i])
        return diagonal

def diagonalSecundariaSegura(matriz):
    if not esCuadrada(matriz):
        return []
    else:
        diagonal = []
        n = len(matriz)
        for i in range(n):
            diagonal.append(matriz[i][n - 1 - i])
        return diagonal

print(diagonalPrincipalSegura(matriz))   # → [8, 5, 2]
print(diagonalSecundariaSegura(matriz))  # → [6, 5, 4]
