import random
lista = []
for i in range(100):
    aleatorio = random.randint(0,100)
    lista.append(aleatorio)

par = []
impar =[]

for z in lista:
    if z % 2== 0:
        par.append(z)
    else:
        impar.append(z)
print(par + impar)