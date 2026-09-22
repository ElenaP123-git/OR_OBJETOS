# COMO HACER MATRIZ
def conviertoMatriz(n):
    matriz = []
    if  n != 0:
        for i in range(n):
            recurso = input("Introduce el recurso: ") .lower()
            cantidad = input("Introduce la cantidad: ") .lower()
            nvl_crit = input("Introduce el nvl crítico: ") .lower()

            fila = [recurso, cantidad, nvl_crit] # hago esto porque una lista sólo acepta un argumento
            matriz.append(fila) # aquí
        return matriz
    
def extreaer_datos(rec, matriz):
    for x in range(len(matriz)):
        fila = matriz[x] 
        if fila[0] == rec: # comparo nombre
            return fila[0] + ":" + fila[1] + ":" + fila[2]
        else:
            return "-1"


n = int(input("¿Cuántos recursos quieres añadir?: "))
matriz = conviertoMatriz(n)   
print("La matríz es: ", matriz)

rec = input("Introduce el nombre del recurso: ")
lista_rec = extreaer_datos(rec, matriz)
print(lista_rec)


# no entendí esto
mensaje =  "ERR_SISTEMA::Agua::-15++FIN" # mensaje.split("::") mensaje[1] (agua)
lecturaBaseDatos = extreaer_datos(mensaje, matriz)




