animales = ["perro","gato","digimon","dragón"] 
animal = input("Escribe el nombre de un animal: ").lower()
if animal in animales:
    print("Lo tenemos")
    n = animales.index(animal)
    print("El animal", animal, "se encuentra en la posición", n)
else:
    print("No lo tenemos, nuestra lista es: ", animales)
