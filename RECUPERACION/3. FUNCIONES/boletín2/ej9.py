# Suma de columnas pares (columnas 0, 2, 4… → suma)
# (IA)

matriz = [
    [8, 1, 6],
    [3, 5, 7],
    [4, 9, 2]
]

def sumaColumnasPares(matriz):
    total = 0
    for j in range(len(matriz[0])):
        if j % 2 == 0:
            for i in range(len(matriz)):
                total += matriz[i][j]
    return total

print(sumaColumnasPares(matriz))   # columnas 0 y 2
