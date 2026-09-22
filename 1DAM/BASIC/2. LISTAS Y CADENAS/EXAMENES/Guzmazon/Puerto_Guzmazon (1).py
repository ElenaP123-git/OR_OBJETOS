listaProductos = []
listaPrecios = []
listaMayor = []

sumaprecio = 0

precioMax = float(input("Introduce el dinero maximo que te quieres gastar: "))

# FASE DE COMPRA
while sumaprecio < precioMax:
    producto = input("Dime el nombre del producto: ")
    precio = float(input("Dime el precio del producto: "))

    listaProductos.append(producto)
    listaPrecios.append(precio)
    sumaprecio = sumaprecio + precio

print("Se ha realizado la compra.")

# Eliminar el ultimo producto
listaProductos.pop()
listaPrecios.pop()

# Recalcular suma 
sumaprecio = 0
i = 0
while i < len(listaPrecios):
    sumaprecio = sumaprecio + listaPrecios[i]
    i = i + 1

print("--- RESUMEN DE COMPRA ---")
print("Importe maximo a gastar:", precioMax)
print("Productos:", listaProductos)
print("Precios:", listaPrecios)
print("Precio total de la cesta:", sumaprecio, "€")

# MENU
salir = False

while salir == False:
    print("Pulsa S para calcular dinero sobrante")
    print("Pulsa R para eliminar un producto y su precio")
    print("Pulsa C para mostrar productos cuyo precio es mayor que un importe")
    print("Pulsa X para salir")

    respuesta = input("Elige una opcion: ").upper()

    match respuesta:

        case "S":
            dineroSobrante = precioMax - sumaprecio
            print("Dinero sobrante:", dineroSobrante, "€")

        case "R":
            print("Productos actuales:", listaProductos)
            nombre = input("Dime el nombre del producto a eliminar: ")

            if nombre in listaProductos:
                indice = listaProductos.index(nombre)
                confirmar = input("Seguro que quieres borrarlo? S/N: ").upper()

                if confirmar == "S":
                    listaProductos.pop(indice)
                    listaPrecios.pop(indice)

                    # Recalcular suma 
                    sumaprecio = 0
                    j = 0
                    while j < len(listaPrecios):
                        sumaprecio = sumaprecio + listaPrecios[j]
                        j = j + 1

                    print("Producto eliminado.")
                else:
                    print("No se ha eliminado nada.")
            else:
                print("Ese producto no esta en la lista.")

            print("Productos:", listaProductos)
            print("Precios:", listaPrecios)

        case "C":
            listaMayor = []   # SIN clear()
            importe = float(input("Dime un importe: "))

            k = 0
            while k < len(listaPrecios):
                if listaPrecios[k] > importe:
                    listaMayor.append(listaPrecios[k])
                k = k + 1

            print("Precios mayores que", importe, ":", listaMayor)

        case "X":
            print("Saliendo del programa.")
            salir = True

        case _:
            print("Opcion no valida.")
