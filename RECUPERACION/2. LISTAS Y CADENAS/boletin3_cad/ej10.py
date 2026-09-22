# LONGITUD (len) y REPLACE

cadena = input("Escribe lo que quieras: ").lower()
caracter1 = input("Introduce un carácter: ").lower()
caracter2 = input("Introduce un segundo carácter: ").lower()

while (len(caracter1) != 1 or len(caracter2) != 1):
    print("Inválido, tiene que ser sólo un carácter")
    caracter1 = input("Introduce un carácter: ").lower()
    caracter2 = input("Introduce un segundo carácter: ").lower()

if caracter1 not in cadena:
    print("El caracter 1 no se encuentra en la cadena")
else:
    cadena = cadena.replace(caracter1, caracter2)
    print(cadena)
