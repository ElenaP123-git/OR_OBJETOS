suma = 0
contador = 0
# no hace falta poner siempre un input antes del while

while contador < 5:
    num  = int(input("Introduce números del 1-5: "))
    if num > 5 or num < 1: # quiero que me vuelva a preguntar un num pero que no los sume
        print("Inválido")
    else:   
        suma = suma + num
        contador = contador + 1

print(suma)