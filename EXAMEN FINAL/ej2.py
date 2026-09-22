print("A) Añadir escenario")
print("V) Validar venta externa")
print("E) Informe de ocupacion")
print("S) Salir")
opcion = input("Introduce una opción: ")

def añadir_escenario(capacidad_max, nombre):
    registroRecinto =[]
    Entradas_Vendidas = 0

    while capacidad_max < 0 or capacidad_max <= 50:
        print("Inválido")
        nombre = input("Introdue el nombre del escenario: ")
        capacidad_max = int(input("Introdue la capacidad máxima: "))
        Entradas_Vendidas += 1

        cadena = nombre, capacidad_max, Entradas_Vendidas
    registroRecinto.append(cadena)

    return registroRecinto

def getNombreEscenario(mensaje):
    cadena = mensaje.split(":::")
    cadenasalida = ""
    for y in cadena: 
        cadenasalida = cadenasalida + y

    cadenasalida = cadenasalida.find("#")
    cadena_bien = cadena[0]

    return cadena_bien

def getCantidadVentas():
    cadena2 = mensaje.split("###")
    cadena2.pop(0)

    cadenasalida2 = ""
    for y in cadena2: 
        cadenasalida2 = cadenasalida2 + y

    cadenasal2_bien = cadenasalida2.split("$$$")
    cadenasal2_bien.pop(1)

    cadenasal2_bien2 = ""
    for y in cadenasal2_bien: 
        cadenasal2_bien2 = cadenasal2_bien2 + y

    return cadenasal2_bien2

def busqueda():
    return

def validaEscenario(mensaje):
    ventas = getCantidadVentas()
    escenario = getNombreEscenario(mensaje)
    recinto = añadir_escenario(capacidad_max, nombre)

    if ventas not in recinto:
        print("ERROR: Escenario no encontrado")
        return False
    else:
        print("Entradas vendidas: ", escenario[2])
        print("Dato ventas: ", ventas)
        if ventas >= escenario[1]:
            print("Overbooking")
            return False
        else:
            print("Actualizable")
            return True
        
def menú():
    if opcion == "A":
        resultado1 = añadir_escenario(capacidad_max, nombre)
        return resultado1
    elif opcion == "V":
        resultado2 = getCantidadVentas()
        return resultado2
    elif opcion == "E":
        resultado3 = validaEscenario(mensaje)
        return resultado3
    elif opcion == "S":
        print("Saliendo del programa...")
        
# PROGRAMA PRINCIPAL

nombre = input("Introdue el nombre del escenario: ")
capacidad_max = int(input("Introdue la capacidad máxima: "))

mensaje = "TICKET_SALE:::FIESTAPOP###13$$$CONFIRMED"

ej_resuelto = menú()
print(ej_resuelto)
