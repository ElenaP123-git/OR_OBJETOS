# SPLIT (mayusculas en palabras)

cadena = input("Introduce nombre y apellidos: ")

palabras = cadena.split()

for i in palabras: 
    primera = i[0] . upper()
    resto = i[1:] .lower()
    print(primera + resto, end=" ")

