import random

# Contadores principales
ganaJugador = 0
ganaMaquina = 0
totalPartidas = 0

# Contador de apuestas del jugador (0–5)
apuestas = [0, 0, 0, 0, 0, 0]

# Primer número de la máquina
piedraMaquina = random.randint(0, 5)

# Bucle principal: termina cuando jugador y máquina sacan lo mismo
piedras = -1 # para que el bucle no termine
while piedras != piedraMaquina:

    # Entrada del jugador
    piedras = int(input("¿Cuántas piedras quieres mostrar? (0-5): "))

    # Validación
    while piedras < 0 or piedras > 5:
        piedras = int(input("Número inválido. Introduce un valor entre 0 y 5: "))

    # Registrar apuesta (piedra en posicion de apuestas)
    apuestas[piedras] += 1

    # Nueva elección de la máquina
    piedraMaquina = random.randint(0, 5)

    # Contador de partidas
    totalPartidas += 1

    # Elección Par/Impar
    seleccion = input("¿Eliges Par o Impar? [P/I]: ").upper()

    # Resultado
    suma = piedras + piedraMaquina
    resultado = suma % 2

    if seleccion == "P":
        if resultado == 0:
            print("Ganaste, elegiste par y salió", suma)
            ganaJugador += 1
        else:
            print("Perdiste, elegiste par y salió", suma)
            ganaMaquina += 1
    else:
        if resultado == 1:
            print("Ganaste, elegiste impar y salió", suma)
            ganaJugador += 1
        else:
            print("Perdiste, elegiste impar y salió", suma)
            ganaMaquina += 1

# Fin del juego
print("--- FIN DEL JUEGO ---")
print("La máquina eligió:", piedraMaquina)
print("El jugador ganó", ganaJugador, "veces")
print("La máquina ganó", ganaMaquina, "veces")
print("Número total de partidas:", totalPartidas)

# Apuesta más frecuente
mayor = apuestas[0]
posicionMayor = 0

i = 1
while i < len(apuestas):
    if apuestas[i] > mayor:
        mayor = apuestas[i]
        posicionMayor = i
    i += 1

masFrecuente = posicionMayor
print("La apuesta humana más frecuente fue:", masFrecuente)
