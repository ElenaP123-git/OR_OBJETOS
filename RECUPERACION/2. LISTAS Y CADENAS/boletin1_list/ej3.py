# Muestra el elemento de la posición 6 de una lista diasSemana con los días de la semana.
dias_Semana = ["lunes","martes","miércoles","jueves","viernes","sabado","domingo"]
n = dias_Semana.index ("domingo")
print(n)

#CORRECCIÓN
elemento = dias_Semana[6]
print(elemento)

# Inicializa una lista con 5 elementos  con números enteros aleatorios del 0 al 8.
import random
lista = []
for i in range(5):
    aleatorio = random.randint(0,8)
    lista.append(aleatorio)
print(lista)

# Crea una lista con los 20 primeros números múltiplos de 3
lista2 = []
for i in range(1,21):
    multiplicación = 3 * i
    lista2.append(multiplicación)
print(lista2)
print("Fin")

#Usa la lista anterior para copiarle por el final elemento a elemento ['martes', 'miércoles', 'jueves']
lista3 = lista2 + dias_Semana[1:4]
print(lista3)

# Genera de la lista de múltiplos de 3 con 10 elementos
lista4 = []
for j in range (1,11):
    multiplicación = 3 * j
    lista4.append(multiplicación)
print(lista4)
print("Fin")

# En la lista anterior, inserta en la posición 8 la palabra “programo”
lista4.insert(8,"programo")
print(lista4)