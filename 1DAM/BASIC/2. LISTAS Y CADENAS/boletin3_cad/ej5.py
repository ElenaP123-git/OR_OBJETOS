# SUBCADENA EN CADENA POR DETRÁS

cadena = input("Introduce una cadena: ")
subcadena = input("Por qué termina la cadena??: ")

es_valida = True

for i in range(len(subcadena)): 
    if subcadena[i] != cadena[-len(subcadena) + i]: 
        es_valida = False

if es_valida:
    print("En la cadena se encuentra la subcadena")
else:
    print("La cadena no termina por la subcadena")