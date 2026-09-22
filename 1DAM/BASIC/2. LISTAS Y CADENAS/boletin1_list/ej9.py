# [1,2,3,4,5,6,7,8,9,10,11,12,13,14,15]
# [15,1,2,3,4,5,6,7,8,9,10,11,12,13,14]


lista_num = []
for x in range(15):
    num = int(input("Dime un número: "))
    lista_num.append(num)

último = lista_num[-1] # num 15
lista_num.pop(-1) 
lista_num.insert(0,último)
print(lista_num)