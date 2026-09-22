# lo compliqué

punt = int(input("Introduce su historial crediticio: "))
contador = 0
suma =0

while contador != 12:
    ing = float(input(("Introduce tu ingreso mensual: ")))
    suma = suma + ing
    contador +=1
print("Tu ingreso es:", suma, " y tu puntuación:", punt)

if punt > 700 and suma >= 60000:
    print("Elegible")
else:
    print("No elegible")