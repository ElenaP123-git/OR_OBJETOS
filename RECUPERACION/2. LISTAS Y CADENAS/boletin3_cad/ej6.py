# SPLIT

cadena = "La inyección de SQL es un tipo de ciberataque encubierto en el cual un hacker inserta código propio en un sitio web con el fin de quebrantar las medidas de seguridad y acceder a datos protegidos. Una vez dentro, puede controlar la base de datos del sitio web y secuestrar la información de los usuarios. Le explicamos cómo funcionan los ataques de inyección de SQL, cómo combatirlos y cómo una herramienta antivirus potente lo puede proteger contra las consecuencias."

print("Op A: Presente cada frase (terminada con .)  en una línea diferente.")
print("Op B: Cuente cuántas frases hay. Las frases vienen delimitadas por .")
print("Op C: Cuántas palabras hay en total.")
print("Op D: Cuántas palabras tiene cada frase.")

# OPA Y OPB
contador = 1

frasesA = cadena.split(".")
for i in frasesA[:-1]:
    print("Frase", contador, ":",i)
    contador += 1
    
# OPC 
palabrasC = cadena.split()
contadorC = 0

for j in palabrasC:
    contadorC += 1

print("En total hay: ", contadorC,"palabras")

#OPD
contadorD = 1
for frase in frasesA[:-1]:
    palabras = frase.split()
    print("La frase", contadorD, "tiene", len(palabras),"palabras")
    contadorD +=1
