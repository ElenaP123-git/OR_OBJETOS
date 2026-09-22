# EXAMEN CORREGIDO

print("A) Añadir escenario")
print("V) Validar venta externa")
print("E) Informe de ocupacion")
print("S) Salir")
opcion = input("Introduce una opción: ")

def añadir_escenario(capacidad_max, nombre):
    registroRecinto = []

    while capacidad_max <= 50:
        print("Inválido")
        nombre = input("Introduce el nombre del escenario: ")
        capacidad_max = int(input("Introduce la capacidad máxima: "))

    Entradas_Vendidas = 0
    cadena = (nombre, capacidad_max, Entradas_Vendidas)
    registroRecinto.append(cadena)

    return registroRecinto


def getNombreEscenario(mensaje):
    partes = mensaje.split(":::")
    nombre = partes[1].split("###")[0]
    return nombre


def getCantidadVentas(mensaje):
    partes = mensaje.split("###")
    ventas = partes[1].split("$$$")[0]
    return int(ventas)


def validaEscenario(mensaje, recinto):
    ventas = getCantidadVentas(mensaje)
    nombre_venta = getNombreEscenario(mensaje)

    escenario = recinto[0]   # (nombre, capacidad, vendidas)

    if nombre_venta != escenario[0]:
        print("ERROR: Escenario no encontrado")
        return False

    print("Entradas vendidas actualmente:", escenario[2])
    print("Dato ventas externas:", ventas)

    if ventas + escenario[2] > escenario[1]:
        print("Overbooking")
        return False
    else:
        print("Actualizable")
        return True


def informe(recinto):
    escenario = recinto[0]
    nombre = escenario[0]
    capacidad = escenario[1]
    vendidas = escenario[2]

    return "Escenario: " + nombre + " | Capacidad: " + str(capacidad) + " | Vendidas: " + str(vendidas)


def menú(opcion, capacidad_max, nombre, mensaje):
    recinto = añadir_escenario(capacidad_max, nombre)

    if opcion == "A":
        return recinto

    elif opcion == "V":
        return validaEscenario(mensaje, recinto)

    elif opcion == "E":
        return informe(recinto)

    elif opcion == "S":
        return "Saliendo del programa..."


# PROGRAMA PRINCIPAL

nombre = input("Introduce el nombre del escenario: ")
capacidad_max = int(input("Introduce la capacidad máxima: "))

mensaje = "TICKET_SALE:::FIESTAPOP###13$$$CONFIRMED"

ej_resuelto = menú(opcion, capacidad_max, nombre, mensaje)
print(ej_resuelto)
