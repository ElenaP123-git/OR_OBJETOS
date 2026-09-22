# QUITA POR DELANTE

num = input("Dime un número entero: ")
n = int(input("Nums que quieres quitar: "))

if n > len(num):
    print("No puedes quitar más digitos de los que tienes")
else:
    resultado = num[n:] # desde la posición n hasta el final

print("Resultado: ", resultado)