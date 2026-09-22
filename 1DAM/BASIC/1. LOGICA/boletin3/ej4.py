num = int(input("Ingrese un número: "))
suma = 0
while num != 0:
    suma = suma + num # si esto no lo pongo aquí el primer num no se suma
    num = int(input("Introduce otro número: "))
print(suma)
