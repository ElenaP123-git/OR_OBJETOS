# hice que termine el programa sólo cuando es válido

n = int(input("Introduce un número: "))
suma = 0

while n <= 0:
    print("Inválido")
    n = int(input("Introduce un número: "))

for i in range(1,n+1):
    suma = suma + i
print(suma)
print("Fin programa")