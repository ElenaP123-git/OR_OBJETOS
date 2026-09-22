# % Y CONTADOR DE CARACTERES

print("Opción 1: escribirá por pantalla cada carácter de una cadena introducida por teclado") 
print("Opción 2: pedirá un caracter por teclado y el sistema  contará el % de veces que aparece un carácter que se ha introducido por teclado")

opcion = int(input("Introduce la opción: ")) 

match opcion:
    case 1:
        cadena = input("Escribe lo que quieras: ")
        for i in cadena:
            print(i)
    case 2:
        cadena = input("Escribe lo que quieras: ")
        caracter = input("Introduce un carácter: ")

        contador = 0

        for i in cadena:
            if i == caracter:
                contador += 1

        total = len(cadena) # todos los carácteres
        porcentaje = (contador/total) * 100 # porcentaje de veces que aparece el carácter

        print("La letra aparece", contador, "veces")
        print("% que aparece el carácter: ", porcentaje)
