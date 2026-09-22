import random
aleatorio_list = []
for i in range(20):
    aleatorio = random.randint(0,100)
    aleatorio_list.append(aleatorio)
print("1º Lista: ", aleatorio_list)

cuadrados_list = []
cubos_list = []
for x in aleatorio_list:
    cuadrados = x ** 2
    cubos = x **3
    cuadrados_list.append(cuadrados)
    cubos_list.append(cubos)
print("2º Lista: ", cuadrados_list)
print("3º Lista: ", cubos_list)

# En columnas:
print("COLUMNAS")
for z in range(20): 
    print(aleatorio_list[z], cuadrados_list[z], cubos_list[z])