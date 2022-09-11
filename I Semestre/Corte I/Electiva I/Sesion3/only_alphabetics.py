string = input("Ingrese una cadena: ")

allowed = "abcdefghijklmnñopqrstuvwxyz"

for leter in string:
    if leter.isalpha:
        print(True)