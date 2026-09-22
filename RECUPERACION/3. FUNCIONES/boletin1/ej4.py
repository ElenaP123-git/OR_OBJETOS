# DEF es una exclava....
# DEF recibe lo de fuera y lo de fuera pide lo que quieres que se calcule

def calculaTemperaturaMedia(tempMAX,tempMIN):
    total = tempMAX + tempMIN
    mediaDef = total/2
    return mediaDef

lista= ["lunes", "martes", "miércoles", "jueves","viernes"]

n = int(input("Días que quieres calcular: "))

for i in range (n):
    dia = lista[i]
    tempMAX = float(input("Introduce la temperatura máxima de hoy: "))
    tempMIN = float(input("Introduce la temperatura minima: "))
    
    media = calculaTemperaturaMedia(tempMAX,tempMIN)
    print("La temmperatura media el ",dia,"es",media)

print("Fin")
