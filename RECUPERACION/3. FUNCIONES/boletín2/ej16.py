# Lluvias (matriz aleatoria 20×7) (IA)

matriz = [
    [8, 1, 6],
    [3, 5, 7],
    [4, 9, 2]
]

import random

def generarLluvias():
    matriz = []
    for semana in range(20):
        fila = []
        for dia in range(7):
            fila.append(random.randint(0, 100))
        matriz.append(fila)
    return matriz

def maxLluvia(matriz):
    maximo = -1
    semanaMax = 0
    diaMax = 0

    for semana in range(20):
        for dia in range(7):
            if matriz[semana][dia] > maximo:
                maximo = matriz[semana][dia]
                semanaMax = semana
                diaMax = dia

    return maximo, semanaMax, diaMax

def aguaPorSemana(matriz):
    lista = []
    for semana in matriz:
        lista.append(sum(semana))
    return lista

lluvias = generarLluvias()
print(lluvias)
print(maxLluvia(lluvias))
print(aguaPorSemana(lluvias))
