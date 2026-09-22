# ============================================================
# MATRIZ BASE
# ============================================================

matriz = [
    [8, 1, 6],
    [3, 5, 7],
    [4, 9, 2]
]


# ============================================================
# EJERCICIO 1 — Obtener elemento por posición
# ============================================================

def obtenerElemento(matriz, fila, columna):
    return matriz[fila][columna]


# ============================================================
# EJERCICIO 2 — Obtener fila completa
# ============================================================

def obtenerFila(matriz, fila):
    return matriz[fila]


# ============================================================
# EJERCICIO 3 — Obtener columna completa
# ============================================================

def obtenerColumna(matriz, columna):
    col = []
    for i in range(len(matriz)):
        col.append(matriz[i][columna])
    return col


# ============================================================
# EJERCICIO 4 — Suma total de la matriz
# ============================================================

def sumaMatriz(matriz):
    total = 0
    for fila in matriz:
        for elemento in fila:
            total += elemento
    return total


# ============================================================
# EJERCICIO 5 — Lista de números pares
# ============================================================

def numerosPares(matriz):
    pares = []
    for fila in matriz:
        for elemento in fila:
            if elemento % 2 == 0:
                pares.append(elemento)
    return pares


# ============================================================
# EJERCICIO 6 — Suma de una fila
# ============================================================

def sumaFila(matriz, fila):
    return sum(matriz[fila])


# ============================================================
# EJERCICIO 7 — Suma de filas pares
# ============================================================

def sumaFilasPares(matriz):
    total = 0
    for i in range(len(matriz)):
        if i % 2 == 0:
            total += sum(matriz[i])
    return total


# ============================================================
# EJERCICIO 8 — Suma de una columna
# ============================================================

def sumaColumna(matriz, columna):
    total = 0
    for i in range(len(matriz)):
        total += matriz[i][columna]
    return total


# ============================================================
# EJERCICIO 9 — Suma de columnas pares
# ============================================================

def sumaColumnasPares(matriz):
    total = 0
    for j in range(len(matriz[0])):
        if j % 2 == 0:
            for i in range(len(matriz)):
                total += matriz[i][j]
    return total


# ============================================================
# EJERCICIO 10 — Máximos
# ============================================================

def maxFila(matriz, fila):
    return max(matriz[fila])

def maxColumna(matriz, columna):
    maximo = matriz[0][columna]
    for i in range(len(matriz)):
        if matriz[i][columna] > maximo:
            maximo = matriz[i][columna]
    return maximo

def maxTotal(matriz):
    maximo = maxFila(matriz, 0)
    for i in range(len(matriz)):
        valor = maxFila(matriz, i)
        if valor > maximo:
            maximo = valor
    return maximo


# ============================================================
# EJERCICIO 11 — Diagonales
# ============================================================

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


# ============================================================
# EJERCICIO 12 — Matriz cuadrada y diagonales seguras
# ============================================================

def esCuadrada(matriz):
    return len(matriz) == len(matriz[0])

def diagonalPrincipalSegura(matriz):
    if not esCuadrada(matriz):
        return []
    return diagonalPrincipal(matriz)

def diagonalSecundariaSegura(matriz):
    if not esCuadrada(matriz):
        return []
    return diagonalSecundaria(matriz)


# ============================================================
# EJERCICIO 13 — Suma de una diagonal
# ============================================================

def sumaDiagonal(matriz, esPrincipal):
    if not esCuadrada(matriz):
        return 0
    if esPrincipal:
        return sum(diagonalPrincipal(matriz))
    else:
        return sum(diagonalSecundaria(matriz))


# ============================================================
# EJERCICIO 14 — Matriz posición
# ============================================================

def matrizPosicion(filas, columnas):
    matriz = []
    for i in range(filas):
        fila = []
        for j in range(columnas):
            fila.append(i + j)
        matriz.append(fila)
    return matriz


# ============================================================
# EJERCICIO 15 — Igualdad de sumas
# ============================================================

def sumaPorFilasIgual(matriz):
    suma0 = sum(matriz[0])
    for fila in matriz:
        if sum(fila) != suma0:
            return False
    return True

def sumaPorColumnasIgual(matriz):
    columnas = len(matriz[0])
    suma0 = sumaColumna(matriz, 0)
    for j in range(columnas):
        if sumaColumna(matriz, j) != suma0:
            return False
    return True

def sumaTotalIgual(matriz):
    return sumaPorFilasIgual(matriz) and sumaPorColumnasIgual(matriz)


# ============================================================
# EJERCICIO 16 — Lluvias
# ============================================================

import random

def generarLluvias():
    matriz = []
    for semana in range(20):
        fila = []
        for dia in range(7):
            fila.append(random.randint(0, 100))
        matriz.append(fila)
    return matriz

def maxLluvia(matriz_lluvias):
    maximo = -1
    semanaMax = 0
    diaMax = 0

    for semana in range(20):
        for dia in range(7):
            if matriz_lluvias[semana][dia] > maximo:
                maximo = matriz_lluvias[semana][dia]
                semanaMax = semana
                diaMax = dia

    return maximo, semanaMax, diaMax

def aguaPorSemana(matriz_lluvias):
    lista = []
    for semana in matriz_lluvias:
        lista.append(sum(semana))
    return lista


# ============================================================
# PROGRAMA PRINCIPAL: PRUEBAS DE CADA EJERCICIO
# (esto es solo para que tú veas los resultados)
# ============================================================

print("EJ1 elemento [1][2]:", obtenerElemento(matriz, 1, 2))          # 7
print("EJ2 fila 0:", obtenerFila(matriz, 0))                          # [8, 1, 6]
print("EJ3 columna 1:", obtenerColumna(matriz, 1))                    # [1, 5, 9]
print("EJ4 suma matriz:", sumaMatriz(matriz))                         # 45
print("EJ5 pares:", numerosPares(matriz))                             # [8, 6, 4, 2]
print("EJ6 suma fila 2:", sumaFila(matriz, 2))                        # 15
print("EJ7 suma filas pares:", sumaFilasPares(matriz))                # filas 0 y 2
print("EJ8 suma columna 0:", sumaColumna(matriz, 0))                  # 15
print("EJ9 suma columnas pares:", sumaColumnasPares(matriz))          # columnas 0 y 2

print("EJ10 max fila 1:", maxFila(matriz, 1))                         # 7
print("EJ10 max columna 2:", maxColumna(matriz, 2))                   # 7
print("EJ10 max total:", maxTotal(matriz))                            # 9

print("EJ11 diag principal:", diagonalPrincipal(matriz))              # [8, 5, 2]
print("EJ11 diag secundaria:", diagonalSecundaria(matriz))            # [6, 5, 4]

print("EJ12 diag principal segura:", diagonalPrincipalSegura(matriz)) # [8, 5, 2]
print("EJ12 diag secundaria segura:", diagonalSecundariaSegura(matriz))# [6, 5, 4]

print("EJ13 suma diag principal:", sumaDiagonal(matriz, True))        # 15
print("EJ13 suma diag secundaria:", sumaDiagonal(matriz, False))      # 15

print("EJ14 matriz posicion 4x5:", matrizPosicion(4, 5))

print("EJ15 filas igual:", sumaPorFilasIgual(matriz))                 # True
print("EJ15 columnas igual:", sumaPorColumnasIgual(matriz))           # True
print("EJ15 total igual:", sumaTotalIgual(matriz))                    # True

lluvias = generarLluvias()
print("EJ16 matriz lluvias:", lluvias)
print("EJ16 max lluvia:", maxLluvia(lluvias))
print("EJ16 agua por semana:", aguaPorSemana(lluvias))
