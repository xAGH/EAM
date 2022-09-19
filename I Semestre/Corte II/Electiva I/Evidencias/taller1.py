# Escriba un programa en Python que acepte una lista de palabras y las agrupe por su
# letra inicial usando un diccionario
def ejercicio1():
    print("Ejericio 1:")
    palabras =  ["mesa", "móvil", "barco", "coche", "avión", "bandeja", "casa", "monitor", "carretera", "arco"]
    agrupacion = {}
    for palabra in palabras:
        first = palabra[0]
        if agrupacion.get(first):
            agrupacion[first].append(palabra)
        else:
            agrupacion[first] = [palabra]

    print(agrupacion)

# Escriba un programa en Python que acepte un diccionario y determine si todos los
# valores son iguales o no
def ejercicio2():
    print("\nEjericio 2:")
    diccionario = {"Juan": 5, "Antonio": 5, "Inma": 5, "Ana": 5, "Esteban": 5}
    valores = list(diccionario.values())
    iguales = all(dato == valores[0] for dato in valores)
    if iguales:
        print("Todos los valores de los elementos son iguales")
    else:
        print("Los valores de los elementos no son iguales")

# Escriba un programa en Python que acepte una lista de listas con varios elementos y
# obtenga un diccionario donde las claves serán los primeros elementos de las sublistas
# y los valores serán los restantes como listas
def ejercicio3():
    print("\nEjericio 3:")
    datos = [
        ["Episode IV - A New Hope", "May 25", 1977],
        ["Episode V -The Empire Strikes Back", "May 21", 1980],
        ["Episode VI - Return of the Jedi", "May 25", 1983]
    ]
    print(f"Datos con formato: {({dato.pop(0): dato for dato in datos})}")

# Escriba un programa en Python que acepte un diccionario cuyos valores son listas y
# borre el contenido de dichas listas.
def ejercicio4():
    print("\nEjericio 4:")
    datos = {
        "C1": [10, 20, 30],
        "C2": [20, 30, 40],
        "C3": [12, 34]
    }
    [datos.get(dato).clear() for dato in datos]
    print(datos)


# Escriba un programa en Python que acepte un diccionario y elimine los espacios de
# sus claves respetando los valores correspondientes.
def ejercicio5():
    print("\nEjericio 5:")
    datos = {
        "S 001": ["Math", "Science"], 
        "S 002": ["Math", "English"]
    }
    print({dato.replace(" ", ""): datos[dato] for dato in datos })

if __name__ == '__main__':
    ejercicio1()
    ejercicio2()
    ejercicio3()
    ejercicio4()
    ejercicio5()
