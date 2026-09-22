print("Vamos a ver si tienes descuento en la tienda")
gasto = float(input("Escribe cuánto has gastado como cliente: "))
miembro = input("Escribe SI/NO si eres miembro del programa: ") . lower()
if gasto > 100.0 or miembro == "si":
    print("Tienes descuento")
else:
    print("Sin descuento")
