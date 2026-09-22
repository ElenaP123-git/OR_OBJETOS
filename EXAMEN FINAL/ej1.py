def capturaPokemon():
    print("---¡CAPTURA TU POKEMON!---")
    lista_pokemon = []
    lista_niveles = []

    for i in range(15):
        nombre = input("Introduce el nombre del pokemon: ")
        lista_pokemon.append(nombre)
        nivel = int(input("Introduce el nivel de tu pokemon: "))
        lista_niveles.append(nivel)
    return lista_pokemon, lista_niveles

def realizarBatalla(pos):
    print("---COMIENZA LA BATALLA---")

    listas = capturaPokemon()
    lista_pokemon = listas[0]
    lista_niveles = listas[1]
    contador_yo = 0
    contador_oponente = 0

    import random
    for i in range(len(lista_pokemon)):
        aleatorio = random.randint(0,i)

    while aleatorio == pos:
        aleatorio = random.randint(i)
    
    soy_ganador = False
    es_ganador = False

    if lista_niveles[aleatorio] > lista_niveles[pos]:
        es_ganador = True
        print("Resultado: Derrota!!!")
        return "Tu pokemon", lista_pokemon[pos], "(nivel",lista_niveles[pos], ")", "luchó contra", lista_pokemon[aleatorio], "de nivel", lista_niveles[aleatorio]

    elif lista_niveles[aleatorio] == lista_niveles[pos]:
        print("Resultado: Empate!!!")
        return "Tu pokemon", lista_pokemon[pos], "(nivel",lista_niveles[pos], ")", "luchó contra", lista_pokemon[aleatorio], "de nivel", lista_niveles[aleatorio]
    
    elif lista_niveles[aleatorio] < lista_niveles[pos]:
        soy_ganador = True
        print("Ganas batalla!!!")
        return "Tu pokemon", lista_pokemon[pos], "(nivel",lista_niveles[pos], ")", "luchó contra", lista_pokemon[aleatorio], "de nivel", lista_niveles[aleatorio]

    if es_ganador:
        contador_oponente += 1
        return ("El contador del oponente a subido a: ", contador_oponente)
    elif soy_ganador:
        contador_yo += 1 
        return ("El contador del oponente a subido a: ", contador_yo)

def mostrarPokedex():
    print("---POKEDEX---")

    listas = listas = capturaPokemon()
    lista_pokemon = listas[0]
    lista_niveles = listas[1]
    contador = 0

    for i in range(len(lista_pokemon)):
        contador += 1

    return ("Pokemon:",contador, ".", lista_pokemon[i]," - Nivel",lista_niveles[i])

def Finalizar():
    print("---FINAL---")
    listas = listas = capturaPokemon()
    lista_pokemon = listas[0]
    lista_niveles = listas[1]
    contador2 = 0
    suma = 0

    for i in range(len(lista_pokemon)):
        contador2 += 1
    
    for x in lista_niveles:
        suma += x

    total = contador2
    media = suma//total

    return "Tu equipo tiene", contador2, "pokemons y su nivel medio es: ", media

def menú(opcion):
    if opcion == 1:
        resultado1 = capturaPokemon()
        print("Tu lista de pokemon es: ", resultado1[0])
        print("Tu lista de niveles para cada pokemon es: ", resultado2[1])
        return resultado1
    elif opcion == 2:
        resultado2 = realizarBatalla(pos)
        return resultado2
    elif opcion == 3:
        resultado3 = mostrarPokedex()
        return resultado3
    elif opcion == 4:
        resultado4 = Finalizar()
        return resultado4

# PROGRAMA PRINCIPAL

print("1. Capturar Pokémon")
print("2. Realizar batalla")
print("3. Mostrar pokédex")
print("4. Finalizar")

opcion = int(input("Introduce una opción del menú: "))

# DEF CAPTURAPOKEMONA

# DEF REALIZAR BATALLA
pos = int(input("Introduce una posición: "))


# DEF MOSTRAR POKEDEX


#DEF FINALIZAR

#DEF MENÚ
fin = menú(opcion)
print(fin)
