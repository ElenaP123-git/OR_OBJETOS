# QUITA POR DETRÁS

num = input("Dime un número entero: ")
n = int(input("Nums que quieres quitar: "))

resultado = ""

for i in range(len(num)-n): # digitos de num - n (1234 --> 12 si n=2)
    resultado += num[i] # elemento en posición i del num

print("Resultado: ", resultado)