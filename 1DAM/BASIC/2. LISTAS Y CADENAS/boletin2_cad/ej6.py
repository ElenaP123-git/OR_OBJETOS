# QUITA POR DETRÁS

num = input("Dime un número entero: ")
n = int(input("Nums que quieres quitar: "))

if n > len(num):
    print("No puedes quitar más números de los que tienes")
else:
    resultado = num[:-n] # tomar todo desde atrás menos los últimos n carácteres
print("Resultado: ", resultado)

