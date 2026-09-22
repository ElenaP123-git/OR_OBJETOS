# NÚMEROS NATURALES GRANDES (10.000.000)

cadena = input("Introduce un número grande (ej:28397424): ")


cad_rev = ""   # le damos la vuelta para que introduca punto cada 3 caracteres
for i in range (len(cadena)-1,-1,-1):
    cad_rev += cadena[i]

resultado = ""
contador = 0
for c in cad_rev:
    resultado += c
    contador += 1
    if contador == 3:
        resultado += "."
        contador = 0 # para que el contador empiece de nuevo

if resultado[-1] == ".":
    resultado = resultado[:-1] # para que no termine con un .

final = ""
for i in range(len(resultado)-1, -1, -1):  # para darle la vuelta (123.4 ..> 4.321)
    final += resultado[i]

print(final)