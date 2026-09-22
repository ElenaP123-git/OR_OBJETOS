# DIGITOS

num = input("Introduce un numero: ")

# Por si pone un num negativo
if num[0] == "-":
    num = num[1:] # sigue a partir de el 2º


# Por si pone una letra
es_valido = True

for i in (num):
    if not ("0" <= i <= "9"): # si el num no está entre 0 y 9... (EN STRING!! pq i contiene la letra que introduces)
        es_valido = False

if es_valido:
    digitos = len(num)
    print("Tiene",digitos,"digitos")
else:
    print("Eso no es un número entero válido")
