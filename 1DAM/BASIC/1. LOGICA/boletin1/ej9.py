print("Eres de riesgo???")
hist = input("Historial crediticio? (neg/post): ") .lower()
años = int(input("Años trabajando?: "))
sueldo = float(input("Tu sueldo anual: "))
cant = float(input("Cantidad que quieres tomar: "))

limite = sueldo * 0.01 # ojito tramposo

if hist == "neg" or años <2 or cant > limite:
    print("Riesgo")
else:
    print("No es de riesgo")