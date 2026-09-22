# INVERSIÓN

lista = []
for i in range(10):
    num = int(input("Introduce un número: "))
    lista.append(num)
print("Lista normal: ",lista)

lista_inversa = []
for i in range (len(lista)-1,-1,-1):
    lista_inversa.append(lista[i]) # "dame el elemento en la posición i de la lista"
print("Lista inversa: ", lista_inversa)
