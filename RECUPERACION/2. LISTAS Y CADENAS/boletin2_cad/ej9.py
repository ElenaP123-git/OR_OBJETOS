# PEGA POR DETRÁS N VECES

num = input("Dime un número entero: ")
n = input("Num que quieres añadir: ")
n2 = int(input("Num veces que quieres que lo ponga: "))

for i in range(n2):
    num = num + n
print(num)
