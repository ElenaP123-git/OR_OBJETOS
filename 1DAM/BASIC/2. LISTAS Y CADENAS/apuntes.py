# LISTAS

dias_semana = ["Lunes", "Martes", "Jueves"]
#                 0        1          2
print(dias_semana[1]) 
print(dias_semana[-1])
dias_semana.insert(2,"Miércoles") #para introducir datos donde quiera
dias_semana.append("Viernes") #para introducir datos al final de la tabla
print(dias_semana)

# Para cambiar un elemento de la lista
dias = ["Lunes", "Martes", "Miércoles", "Jueves"]
print(dias)  
# ['Lunes', 'Martes', 'Miércoles', 'Jueves']
dias[2] = "Wednesday"   # cambio el elemento en la posición 2
print(dias)
# ['Lunes', 'Martes', 'Wednesday', 'Jueves']

dias_finde = ["Sábado", "Domingo"]
dias_semana = dias_semana + dias_finde #fusionamos ambas listas
print(dias_semana)

dias_semana.pop(6) #para borrar por posición
ultimo_elemento = dias_semana.pop() # elimina el último elemento de la lista
dias_semana.remove ("Martes") #para borrar por valor (sólo elimina el primer elemento de la lista con ese nombre)
print(dias_semana)

# NUEVA LISTA
animales = ["perro","zorro","dragón","perro"]
animales.remove ("perro")
print(animales)
# FIN NUEVA LISTA

print(len(dias_semana)) #para indicar el número de elementos que hay en la lista

for dias in dias_semana: #para imprimir cada dato de la lista
    print(dias)

for dias in range (len(dias_semana)): 
    print(dias_semana[dias])

for i in reversed (dias_semana): #para imprimir al revés la lista  A SORAYA NO LE GUSTA 
    print(i)

for x in "banana":
    print(x) # te dice todos los caracteres letra por letra

print(dias_semana.index("Lunes")) #para saber la posición en la que está el dato en la lista

d = input("Introduce dia semana: ")
if d in dias_semana:
    n = dias_semana.index(d)
    print("El día", d, "se encuentra en la posición", n )
    print(dias_semana[n])

if "Lunes" in dias_semana:
    print("lo tengo")
else:
    print("no lo tengo")

print(dias_semana[1]) #para imprimir el dia de la semana que indicas

txt = "The best things in life are free!"
print("free" in txt) #true
print("expensive" not in txt) #true

# [inicio:fin-1]

print(dias_semana[1:4]) #se imprime todo de la lista entre el 1 y el 4
print(dias_semana[0:len(dias_semana)]) #imprime lista completa
print(dias_semana[-len(dias_semana)])  #si la lista tiene 7 elementos imprime primero el -7
print(dias_semana[:-len(dias_semana)]) #imprime lista vacía "desde el primer num hasta el -7 sin incluir"
print(dias_semana[::-1]) #imprime la lista al revés A SORAYA NO LE GUSTA
print(dias_semana[:-1]) #imprime todos los elementos de la lista menos el último 
                        # por eso print(dias_semana[:-2]) elimina los últimos 2


# CADENAS

a = "Hello, World"

print(a[1])  # acceder a un carácter mediante su posición (e)

mensaje9 = "Hola Mundo"
mensaje9a = mensaje9[1:8]  # genera una nueva cadena desde la posición inicial (incluida) hasta la posición final (excluida). "ola Mun"

mensaje1 = 'Hola' + ' ' + 'Mundo' # Une dos o más cadenas usando el operador +. "Hola Mundo"
len(mensaje1)  # devuelve el número de caracteres de la cadena (incluidos espacios). (10)

for x in "banana":
  print(x) #imprime cada letra

txt = "The best things in life are free!"
print("free" in txt)  # devuelve True or False si está o no en el txt
print("expensive" not in txt)

mensaje5 = "Hola Mundo" 
mensaje5a = mensaje5.find("Mundo") # find(): Busca la subcadena en cadena y muestra posición
print(mensaje5a)

mensaje8 = "HOLA MUNDO LOS LUNES"
mensaje8 = mensaje8.replace("L", "pizza") #cambia las L por "pizza"
print(mensaje8)                           # las cadenas son inmutables

mensaje2a = 'Hola ' * 3 # Repite la cadena el número de veces especificado. "hola hola hola"
mensaje8.lower() # pasar a minúsculas
mensaje8.upper() # pasar a mayúsculas

s = "Esto es una comilla doble \" de ejemplo"
print(s)


# Pasar de cadena a lista

txt = "Bienvenidos,a,la,clase,de,programación"
lista = txt.split(',') # (split): Devuelve una lista de cadenas separadas por , si no pones nada separa por espacios
['Bienvenidos', 'a', 'la', 'clase', 'de', 'programación'] # resultado lista[2] == la

nombre = "elena"
print(nombre)
nombre = list(nombre) # para convertir una cadena(str) a lista [] 
print(nombre) 
nombre.insert(0,"A") 
print (nombre)

# Pasar de lista a cadena

cadenasalida = ""
for y in nombre: 
  cadenasalida = cadenasalida + y
print(cadenasalida)
