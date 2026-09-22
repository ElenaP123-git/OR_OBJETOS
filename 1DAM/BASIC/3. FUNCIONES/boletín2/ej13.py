# Suma de una diagonal si es cuadrada (IA)

matriz = [
    [8, 1, 6],
    [3, 5, 7],
    [4, 9, 2]
]

def esCuadrada(matriz):
    return len(matriz) == len(matriz[0])

def diagonalPrincipal(matriz):
    diag = []
    for i in range(len(matriz)):
        diag.append(matriz[i][i])
    return diag

def diagonalSecundaria(matriz):
    diag = []
    n = len(matriz)
    for i in range(n):
        diag.append(matriz[i][n - 1 - i])
    return diag

def sumaDiagonal(matriz, esPrincipal):
    if not esCuadrada(matriz): # puede hacerse una variable para esto
        return 0
    elif esPrincipal:
        diag1 = diagonalPrincipal(matriz)
        sum = 0
        for i in diag1:
            sum = sum + i
        return sum
    else:
        suma = 0
        diag2 = diagonalSecundaria(matriz)
        for i in diag2:
            suma = suma + i
        return  suma

print(sumaDiagonal(matriz, True))   # → 8 + 5 + 2 = 15
print(sumaDiagonal(matriz, False))  # → 6 + 5 + 4 = 15
