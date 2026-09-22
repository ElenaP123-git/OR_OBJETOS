#  DIGITO N (POSICIONES)

num = input("Introduce un número: ")

if num[0] == "-":
    num = num[1:]

es_num = True

for i in (num):   
    if not ("0"<= i <= "9"):
        es_num = False

if es_num:
    digitos = len(num)
    print("Hay", digitos,"digitos")
else:
    print("No se permiten caracteres")

n = int(input("Posición dígito que buscas: "))


# Clave

if (n < 0 or n >= digitos):
    print("N inválida")
else:
    print(num[n]) # n tiene que ser un número (posición)
                  # el elemento en el número n...