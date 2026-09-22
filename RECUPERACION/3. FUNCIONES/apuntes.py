# Una función es un bloque de código que se puede REUTILIZAR
def nombre_funcion(parametros): # "parametros" no sirve para nada, se lee después del return (ej abajo:  matriz letras)
    # código que hace algo
    return resultado

# Ejemplo básico
def suma(a, b):
    return a + b

print(suma(3, 4))  # Resultado: 7  Aquí solo se imprime, no se guarda en una variable.
# Si quiero reutilizarlo, debo guardarlo:
resultado = suma(3, 4)
print(resultado)       # 7
print(resultado * 2)   # 14


# Función dentro de otra
def cuadrado_suma(a, b):
    return suma(a, b) ** 2  # usamos la función suma dentro de otra

print(cuadrado_suma(2, 3))  # (2+3)^2 = 25


# MATRICES (listas de listas)
matriz = [
    [1, 2, 3],
    [4, 5, 6],
    [7, 8, 9]
]

# Acceso por índices:
# matriz[0] → [1, 2, 3] (primera fila)
# matriz[1] → [4, 5, 6] (segunda fila)
# matriz[0][0] → 1 (fila 1, columna 1)
# matriz[1][2] → 6 (fila 2, columna 3)

# COLUMNAS
mA = [[1, 2],
      [3, 4]]
columna_0 = [fila[0] for fila in mA]  # primera columna [1, 3]
columna_1 = [fila[1] for fila in mA]  # segunda columna [2, 4]

print(columna_0)  # [1, 3]
print(columna_1)  # [2, 4]


# Recorrer toda la matriz
for fila in matriz:
    for elemento in fila:
        print(elemento, end=" ")
    print()  # salto de línea al final de cada fila (forma matriz)


# EJEMPLOS TÍPICOS DE EXAMEN

# SUMAR TODOS LOS ELEMENTOS
def suma_matriz(matriz):
    total = 0
    for fila in matriz:
        for elemento in fila:
            total += elemento
    return total

print(suma_matriz([[1, 2], [3, 4]]))  # Resultado: 10


# ENCONTRAR EL MAYOR ELEMENTO
def max_matriz(matriz):
    mayor = matriz[0][0]  # primer elemento como punto de partida
    for fila in matriz:
        for elemento in fila:
            if elemento > mayor:
                mayor = elemento
    return mayor

print(max_matriz([[5, 8], [2, 9]]))  # Resultado: 9


# TRANSPONER MATRIZ (intercambiar filas por columnas)
def transponer(matriz):
    filas = len(matriz) # 2 filas
    columnas = len(matriz[0]) # 3 columnas en primera fila
    nueva = []
    for j in range(columnas): # recorre columnas (0,1,2) j = columna dentro de fila
        fila_nueva = []
        for i in range(filas): # recorre filas (0,1) i = fila
            fila_nueva.append(matriz[i][j]) 
        nueva.append(fila_nueva)
    return nueva

print(transponer([[1, 2, 3], [4, 5, 6]]))  # Resultado: [[1,4],[2,5],[3,6]]

# EXPLICACIÓN ARRIBA [][]
# j = 0 (primera columna):
#   i = 0 → matriz[0][0] = 1 (fila 1 col 1...)
#   i = 1 → matriz[1][0] = 4 → fila nueva = [1, 4] (fila 2 columna 1...)

# j = 1 (segunda columna):
#   i = 0 → matriz[0][1] = 2
#   i = 1 → matriz[1][1] = 5 → fila nueva = [2, 5]

# j = 2 (tercera columna):
#   i = 0 → matriz[0][2] = 3
#   i = 1 → matriz[1][2] = 6 → fila nueva = [3, 6]


# FUNCIONES QUE USAN OTRAS FUNCIONES
def media_matriz(matriz):
    total = suma_matriz(matriz)
    cantidad = len(matriz) * len(matriz[0]) # 2 filas x 2 columnas de primera fila
    return total / cantidad

print(media_matriz([[1, 2], [3, 4]]))  # Resultado: 2.5


def resumen_matriz(matriz):
    return {
        "suma": suma_matriz(matriz),
        "media": media_matriz(matriz),
        "maximo": max_matriz(matriz)
    }

print(resumen_matriz([[5, 8], [2, 9]]))
# Resultado: {'suma': 24, 'media': 6.0, 'maximo': 9}


# DIAGONALES
matrix = [[1,2,3],
          [4,5,6],
          [7,8,9]]

def imprimir_diagonales(matrix):
    num_filas_y_col = len(matrix) # numero de filas (igual que columnas pq es cuadrada)
    diagonal_principal = [matrix[i][i] for i in range(num_filas_y_col)] # [i][i] es para que la dp sea [1][1], [2][2]...
    diagonal_secundaria = [matrix[i][num_filas_y_col -1 -i] for i in range(num_filas_y_col)] # num_f_c = 3 -> [i][num_filas_y_col -1 -i] -> [0,2], [1,1], [2,0]
    #                                                                                          se -i porque si no, imprime todos los últimos elementos de cada fila
    
    return diagonal_principal, diagonal_secundaria

dp,ds = imprimir_diagonales(matrix)
print("Diagonal principal:", dp)
print("Diagonal secundaria:", ds)


# ABECEDARIO (ELEMENTOS ESPECÍFICOS DE LA MATRIZ)
matriz_letras = [
    ["A", "B", "C", "D", "E"],
    ["F", "G", "H", "I", "J"],
    ["K", "L", "M", "N", "O"],
    ["P", "Q", "R", "S", "T"],
    ["U", "V", "W", "X", "Y"]
]

def formar_palabra(matriz, posiciones):
    palabra = ""
    for fila, col in posiciones:
        palabra += matriz[fila][col]
    return palabra

print(formar_palabra(matriz_letras, [(0,0),(1,2),(2,4)]))  # "AHO"
                                     # posiciones (fila,col)

# ROTAR MATRIZ 90º
def rotar_90(matriz):
    filas = len(matriz)
    columnas = len(matriz[0])
    nueva = []
    for j in range(columnas):
        fila_nueva = []
        for i in range(filas-1, -1, -1): # filas al revés
            fila_nueva.append(matriz[i][j]) # cambia filas por columnas
        nueva.append(fila_nueva)
    return nueva

m = [[1,2,3],[4,5,6],[7,8,9]]
print(rotar_90(m))  # [[7,4,1],[8,5,2],[9,6,3]]


# SUMA POR FILAS
def suma_filas(matriz):
    resultado = []
    for i in range(len(matriz)):
        total_fila = 0
        for j in range(len(matriz[i])):
            total_fila = total_fila + matriz[i][j]
        resultado.append(total_fila)
    return resultado

m = [[1,2,3],[4,5,6],[7,8,9]]
print(suma_filas(m))  # [6, 15, 24]


# SUMA POR COLUMNAS
def suma_columnas(matriz):
    resultado = []
    columnas = len(matriz[0])
    filas = len(matriz)
    for j in range(columnas):
        total_col = 0
        for i in range(filas):
            total_col = total_col + matriz[i][j]
        resultado.append(total_col)
    return resultado

m = [[1,2,3],[4,5,6],[7,8,9]]
print(suma_columnas(m))  # [12, 15, 18]


# BUSCAR UN ELEMENTO EN LA MATRIZ
def buscar(matriz, valor):
    for i in range(len(matriz)):
        for j in range(len(matriz[i])):
            if matriz[i][j] == valor:
                return (i, j)   # devuelve fila y columna si lo encuentra
    return None # si no lo encuentra, devuelve "nada"

m = [[1,2,3],[4,5,6],[7,8,9]]
print(buscar(m, 5))  # (1,1)


# ASSERT
print("Hola mundo")
assert (3+2 == 5) # si no se cumple (3+2=6)no imprime el "Adios" y da un error
print("Adios")

def suma (num1, num2): # otro ejemplo
    return num1+num2
print("Hola mundito")
assert(suma(3,2) == 5)
print("Adioss")

def cuadrado_num(numero): #otro
    return numero **2
assert(cuadrado_num(9)>0)
assert(cuadrado_num(-9) == 81)
print("yes")

def calCULO (n1,n2):
    return n1+n2
assert calCULO(2, 3) == 5   #sirve para asegurarse de que cualquier acción lógica te de lo que tu pongas ahí
                #en este caso pones como "verdad absoluta" que 2+3=5, si en tu función el resultado no te da 5 te da un assert error 
print("Correcto")