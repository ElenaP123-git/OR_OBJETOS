# SUBCADENA EN CADENA POR DELANTE

cadena = input("Introduce una cadena: ")
subcadena = input("Por qué empieza la cadena??: ")

es_valida = True

for i in range(len(subcadena)): 
    if subcadena[i] != cadena [i]: 
        es_valida = False

if es_valida:
    print("En la cadena se encuentra la subcadena")
else:
    print("La cadena no empieza por la subcadena")