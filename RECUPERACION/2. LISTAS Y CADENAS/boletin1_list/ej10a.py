# [1,2,3,4,5,6,7,8,9,10,11,12,13,14,15]  num = 3
# [4,5,6,7,8,9,10,11,12,13,14,15,1,2,3]


lista = []
for i in range(15):
    num = int(input("Introduce un número: "))
    lista.append(num)

num2 = int(input("Introduce número para rotar: "))

while num2 > len(lista):
    print("INVÁLIDO")
    num2 = int(input("Introduce número para rotar: "))

new_list = []
for x in range(num2):
    primero = lista[0]
    lista.pop(0)
    new_list.append(primero)

print(lista + new_list)