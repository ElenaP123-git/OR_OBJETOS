temp_meses = []
meses = ["enero","febreo","marzo","abril","mayo","junio","julio","agosto","septiembre","octubre","noviembre","diciembre"]
for x in meses:
    temp = int(input("Introduce temperatura media en" + " " + x + ":"))
    temp_meses.append(temp)
print("Introducidas!!: ", temp_meses)

for z in range(12):
    estrellas = temp_meses[z] * "*"
    print(meses[z], ": ",estrellas, "(", temp_meses[z], "ºC )")
