temp_media = []
meses = ["enero","febreo","marzo","abril","mayo","junio","julio","agosto","septiembre","octubre","noviembre","diciembre"]
for x in meses:
    temp = float(input("Introduzca la temperatura media en" + " " + x + ":")) # aqui me dio error por poner ,
    temp_media.append(temp)
print("Temperaturas medias introducidas!!")
print("Las tempertaturas son: ", temp_media)

for z in range(12):
    print(meses[z]," : (",temp_media[z],"ºC)") # in love w this