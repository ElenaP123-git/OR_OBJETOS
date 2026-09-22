# Cambiar posición

cadena = input("Introduce nombre y apellidos: ")

palabras = cadena.split()

for i in palabras: 
    primera = i[0].upper()
    ultima = i[-1].upper()
    resto = i[1:-1].lower()
    print(primera + resto + ultima, end=" ")