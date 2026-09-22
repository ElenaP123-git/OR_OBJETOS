# Diagonales de la matriz

matriz = [
    [8, 1, 6],
    [3, 5, 7],
    [4, 9, 2]
]

def sumaDiagonalPrincipal(matriz):
    suma = 0
    diagP  =[] # [0][0]- [1][1] - [2][2]
    for i in range (len(matriz)):
        diagP.append(matriz[i][i])
    for x in diagP:
        suma = suma + x
    return suma

print("La suma de la diagonal principl es: ", sumaDiagonalPrincipal(matriz))


def sumaDiagonalSecundaria(matriz):
    suma = 0
    diagS = [] # [0][2]-[1][1]-[2][0]
    n = len(matriz) # hago esto para poder utilizarlo facilmente luego
    for i in range(n):
        diagS.append(matriz[i][n - 1 - i]) # (2,1,0) -1 desde atrás y -i para ser lo contrario a i (n veces)
    for x in diagS:
        suma = suma + x
    return suma

print("La suma de la diagonal secundaria es: ", sumaDiagonalSecundaria(matriz))
