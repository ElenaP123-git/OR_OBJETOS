# ESPACIO ENTRE LETRAS

def ConvertirEspaciado(texto):
    cadena = ""
    for i in (texto):
        cadena = cadena + i + " "
    return cadena

texto = input("Introduce un texto: ")

resultado = ConvertirEspaciado(texto)
print("El texto modificado es: ", resultado)