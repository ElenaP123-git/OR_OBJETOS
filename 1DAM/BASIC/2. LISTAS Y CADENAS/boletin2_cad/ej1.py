# ES CAPICUA

esCapicua = input("Introduce una palabra: ") .lower()

lo_es = True

for i in range(len(esCapicua)):
    if esCapicua[i] != esCapicua[-1-i]: # misma letra (i) desde el final (-1)
        lo_es = False
if lo_es:
    print("Es capicua")
else:
    print("No es capicua")