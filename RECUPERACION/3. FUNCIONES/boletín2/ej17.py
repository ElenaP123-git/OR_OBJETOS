# Cuántos números hay mayores a un valor dado

matriz = [
    [8, 1, 6],
    [3, 5, 7],
    [4, 9, 2]
]

def contarMayores(matriz,valor):
    lista = []
    contador = 0
    for i in matriz:
        for x in i:
            if x > valor:
                contador += 1
                lista.append(x)
    return contador, lista

resultado = contarMayores(matriz,3)
print("Hay:", resultado[0], "números mayores al introducido")
print("La lista es:", resultado[1])