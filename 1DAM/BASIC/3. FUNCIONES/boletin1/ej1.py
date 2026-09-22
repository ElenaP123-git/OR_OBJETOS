
def obtieneYValidaDatosDeEntrada():
    num = int(input("Introduce un número: "))
    while num < 0:
        num = int(input("Introduce un número: "))
    return num

resultado = obtieneYValidaDatosDeEntrada()
print("El número válido es: ", resultado)