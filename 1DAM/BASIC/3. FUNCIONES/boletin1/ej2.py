def esMultiplo(num1,num2):
    if (num1 % num2 == 0) or (num2 % num1 == 0):
        return True
    else:
        return False

num1 = int(input("Introduce un número: "))
num2 = int(input("Introduce un segundo número: "))

if esMultiplo(num1, num2):
    print("El primero es múltiplo del segundo")
else:
    print("El primero NO es múltiplo del segundo")
