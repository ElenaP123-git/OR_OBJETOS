# [1,2,3,4,5,6,7,8,9,10,11,12,13,14,15]  num = 3
# [13,14,15,1,2,3,4,5,6,7,8,9,10,11,12]

lista = []
for x in range(15):
    num = int(input("Introduce un número: "))
    lista.append(num)

num2 = int(input("Introduce nums para rotar: "))

while num2 > len(lista):
    print("INVÁLIDO")
    num2 = int(input("Introduce nums para rotar: "))

nueva_lista = []

for i in range (num2):
    ultimo = lista[-1]
    lista.pop(-1)
    nueva_lista.insert(0,ultimo)

print(nueva_lista + lista)