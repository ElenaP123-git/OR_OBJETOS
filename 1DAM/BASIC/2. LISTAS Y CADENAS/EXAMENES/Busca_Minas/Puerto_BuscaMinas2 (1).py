import random

def generar_tablero():
    lista = []
    contador = 0

    for _ in range(8):
        casilla = random.randint(0, 1)
        if casilla == 1:
            lista.append("X")
            contador += 1
        else:
            lista.append("")
    return lista, contador, []   # tablero, minas, lista vacía de jugados

def jugar(tablero, minas, jugados, puntuacion):
    if len(tablero) != 8:
        print("Debes generar el tablero antes de jugar.")
        return minas, jugados, puntuacion

    print("Comienza el juego.")
    intentos = int(input("Cuantos intentos quieres tener? "))

    while minas > 0 and intentos > 0:
        print("Intentos restantes:", intentos)
        print("Minas restantes:", minas)

        pos = int(input("Elige una posicion entre 0 y 7: "))

        while pos < 0 or pos > 7 or pos in jugados:
            if pos in jugados:
                print("Ya jugaste esa posicion.")
            pos = int(input("Elige una posicion valida entre 0 y 7: "))

        jugados.append(pos)

        if tablero[pos] == "X":
            puntuacion += 1
            minas -= 1
            print("MINA! +1 punto")
        else:
            puntuacion -= 1
            intentos -= 1
            print("AGUA! -1 punto")

        print("Puntuacion actual:", puntuacion)

    print("El juego ha terminado.")
    print("Puntuacion final:", puntuacion)

    return minas, jugados, puntuacion

# PROGRAMA PRINCIPAL
salir = False
tablero = []
minas = 0
jugados = []
puntuacion = 0

while salir == False:
    print("===========================")
    print("      BUSCAMINAS SIMPLE     ")
    print("===========================")
    print("T) Generar tablero")
    print("J) Jugar")
    print("E) Salir")

    opcion = input("Elige una opcion: ").upper()

    if opcion == "T":
        tablero, minas, jugados = generar_tablero()
        print("Tablero generado:", tablero)
        print("Minas colocadas:", minas)

    elif opcion == "J":
        minas, jugados, puntuacion = jugar(tablero, minas, jugados, puntuacion)

    elif opcion == "E":
        print("Saliendo del juego...")
        salir = True

    else:
        print("Opcion no valida.")
