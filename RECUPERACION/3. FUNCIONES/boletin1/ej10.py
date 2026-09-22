# FUNCIÓN DENTRO DE FUNCIÓN

def pasoSeg_Min(segundos):
    solucionMIN =  segundos / 60
    return solucionMIN

def pasoSeg_Horas(segundos):
    minutos = pasoSeg_Horas(segundos)
    solucionHORAS = minutos /60
    return solucionHORAS

segundos = int(input("Dime un número: "))

resultadoM = pasoSeg_Min(segundos)
print("En minutos, los",segundos,"ssegundos son: ",resultadoM)

resultadoH = pasoSeg_Horas(segundos)
print("En horas, los", segundos, " segundos son", resultadoH)