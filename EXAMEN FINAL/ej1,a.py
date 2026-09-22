# EXAMEN CORREGIDO

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


def realizarBatalla(lista_pokemon, lista_niveles, pos):
    print("---COMIENZA LA BATALLA---")

    import random
    aleatorio = random.randint(0, len(lista_pokemon) - 1)

    while aleatorio == pos:
        aleatorio = random.randint(0, len(lista_pokemon) - 1)

    nivel_mio = lista_niveles[pos]
    nivel_oponente = lista_niveles[aleatorio]

    if nivel_oponente > nivel_mio:
        print("Resultado: Derrota!!!")
    elif nivel_oponente == nivel_mio:
        print("Resultado: Empate!!!")
    else:
        print("Ganas batalla!!!")

    return "Tu Pokémon " + lista_pokemon[pos] + " (nivel " + str(nivel_mio) + ") luchó contra " + lista_pokemon[aleatorio] + " (nivel " + str(nivel_oponente) + ")"


def mostrarPokedex(lista_pokemon, lista_niveles):
    print("---POKEDEX---")

    for i in range(len(lista_pokemon)):
        print(str(i) + ". " + lista_pokemon[i] + " - Nivel " + str(lista_niveles[i]))

    return "Fin de la Pokédex."


def Finalizar(lista_pokemon, lista_niveles):
    print("---FINAL---")

    total = len(lista_pokemon)

    # Calcular suma sin usar sum()
    suma = 0
    for nivel in lista_niveles:
        suma = suma + nivel

    media = suma // total

    return "Tu equipo tiene " + str(total) + " pokemons y su nivel medio es " + str(media)


def menú(opcion, lista_pokemon, lista_niveles):
    if opcion == 1:
        print("Tu lista de Pokémon es:", lista_pokemon)
        print("Sus niveles son:", lista_niveles)
        return "Pokémon capturados correctamente."

    elif opcion == 2:
        pos = int(input("Introduce la posición del Pokémon que luchará: "))
        return realizarBatalla(lista_pokemon, lista_niveles, pos)

    elif opcion == 3:
        return mostrarPokedex(lista_pokemon, lista_niveles)

    elif opcion == 4:
        return Finalizar(lista_pokemon, lista_niveles)

# PROGRAMA PRINCIPAL

print("1. Capturar Pokémon")
print("2. Realizar batalla")
print("3. Mostrar pokédex")
print("4. Finalizar")

opcion = int(input("Introduce una opción del menú: "))

# Capturamos los pokémon una sola vez
lista_pokemon, lista_niveles = capturaPokemon()

resultado = menú(opcion, lista_pokemon, lista_niveles)
print(resultado)
