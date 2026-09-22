cant = float(input("Ingrese la cantidad que desea retirar: "))
saldo = float(input("Saldo en tu cuenta?: "))
if cant > saldo:
    print("No se puede retirar el dinero")
else:
    print("dinero retirado")