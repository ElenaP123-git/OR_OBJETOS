import random

carton_bingo = [
    [5, 21, 38, 50, 63],
    [12, 17, 44, 47, 74],
    [1, 29, "--", 55, 69],
    [9, 25, 32, 59, 61],
    [14, 19, 41, 52, 66]
]

listaNumerosSalidos = []

def generaAleatorio(lista):
    generado = 0
    valido = False
    while not valido:
        generado = random.randint(1, 75)
        if generado not in lista:
            lista.append(generado)
            valido = True
    return generado

def filaCompleta(carton, listaSalidos, fila):
    indice = 0
    completa = True
    while indice < len(carton[fila]) and completa:
        numero = carton[fila][indice]
        if numero != "--" and numero not in listaSalidos:
            completa = False
        indice += 1
    return completa

def jugarALaLinea(carton):
    listaNumerosSalidos = []
    linea = False
    filaGanadora = -1

    while not linea:
        generaAleatorio(listaNumerosSalidos)

        filaActual = 0
        while filaActual < 5 and not linea:
            if filaCompleta(carton, listaNumerosSalidos, filaActual):
                linea = True
                filaGanadora = filaActual
            else:
                filaActual += 1

    cantidad = len(listaNumerosSalidos)
    return filaGanadora, carton[filaGanadora], cantidad, listaNumerosSalidos

def imprimeSalida(fila, contenido, cantidad, lista):
    print("LÍNEA CONSEGUIDA")
    print("Fila ganadora:", fila)
    print("Contenido de la fila:", contenido)
    print("Números salidos antes de completar la línea:", cantidad)
    print("Lista de números salidos:", lista)

fila, contenido, cantidad, lista = jugarALaLinea(carton_bingo)
imprimeSalida(fila, contenido, cantidad, lista)
