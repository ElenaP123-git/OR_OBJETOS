# PEGA POR DELANTE N VECES

num = input("Dime un número entero: ")
n = input("Num que quieres añadir delante: ")
n2 = int(input("Num veces que quieres que lo ponga: "))

for i in range (n2):
    num = n + num
print(num)