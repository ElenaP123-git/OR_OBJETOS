

mensaje = "TICKET_SALE:::FIESTAPOP###13$$$CONFIRMED"
cadena2 = mensaje.split("###")
cadena2.pop(0)


cadenasalida2 = ""
for y in cadena2: 
  cadenasalida2 = cadenasalida2 + y
print(cadenasalida2)

cadenasal2_bien = cadenasalida2.split("$$$")
cadenasal2_bien.pop(1)

cadenasal2_bien2 = ""
for y in cadenasal2_bien: 
  cadenasal2_bien2 = cadenasal2_bien2 + y

print(cadenasal2_bien2)
