import random

# Contadores globales
alumnos = 0
casaG = 0
casaS = 0
casaH = 0
casaR = 0

def mostrar_menu():
    texto = "============================================"
    texto += "SOMBRERO SELECCIONADOR"
    texto += "============================================"
    texto += "1. Seleccionar casa para un alumno"
    texto += "2. Mostrar estadísticas"
    texto += "(Para salir: elige opción 1 y escribe Voldemort)"
    return texto

def asignar_casa():
    numero = random.randint(1, 4)
    if numero == 1:
        return "Gryffindor"
    elif numero == 2:
        return "Slytherin"
    elif numero == 3:
        return "Hufflepuff"
    else:
        return "Ravenclaw"

def obtener_estadisticas(): #se ven argumentos de fuera por ser globales
    texto = "=== ESTADISTICAS ==="
    texto += "Total de alumnos: " + str(alumnos)
    texto += "Gryffindor: " + str(casaG)
    texto += "Slytherin: " + str(casaS)
    texto += "Hufflepuff: " + str(casaH)
    texto += "Ravenclaw: " + str(casaR)
    texto += "===================="
    return texto

# PROGRAMA PRINCIPAL
salir = False

print(mostrar_menu())
respuesta = int(input("Elige una opcion: "))

while respuesta != 1 and respuesta != 2:
    respuesta = int(input("Incorrecto, debe ser 1 o 2: "))

while salir == False:

    if respuesta == 1:
        nombre = input("Dime el nombre del alumno: ")

        if nombre == "Voldemort":
            print("Apparition, transportame a otro sitio...")
            salir = True
        else:
            alumnos += 1
            casa = asignar_casa()

            if casa == "Gryffindor":
                casaG += 1
            elif casa == "Slytherin":
                casaS += 1
            elif casa == "Hufflepuff":
                casaH += 1
            else:
                casaR += 1

            print("El sombrero dice que", nombre, "pertenece a", casa)

    elif respuesta == 2:
        print(obtener_estadisticas())

    if salir == False:
        print(mostrar_menu())
        respuesta = int(input("Elige una opcion: "))

        while respuesta != 1 and respuesta != 2:
            respuesta = int(input("Incorrecto, debe ser 1 o 2: "))
