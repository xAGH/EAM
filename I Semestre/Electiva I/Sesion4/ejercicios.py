# Trabajo presentado por Alejandro Giraldo Herrera
import os

# Funciones generales
clear = lambda: os.system('cls' if os.name in ('nt', 'dos') else 'clear')
jump = "\n"

# Ejericio Inicial. Dada una cadena de texto, indique el número de vocales que tiene.
def how_many_vowels():
    word = input("Ingrese una palabra o frase: ")
    vowels_quantity = {}
    vowels_counter = 0
    for letter in word:
        if letter.upper() in ("A", "E", "I", "O", "U"):
            vowels_counter += 1
            actual_value = vowels_quantity.get(letter)
            vowels_quantity[letter] = actual_value + 1 if actual_value else 1
    return f"Cantidad de vocales: {vowels_counter}. Coincidencias: {vowels_quantity}"

# Ejercicio 1. Escriba un programa en Python que realice las siguientes 9
# multiplicaciones
# 1 · 1
# 11 · 11
# 111 · 111
# ...
# 111111111 · 111111111
def multiplications():
    try:
        base_number = int(input("Ingrese el número base: "))
        times = int(input("Veces a multipicar el número: "))
    except:
        return "El valor no es un número entero"

    result = ""
    
    for i in range(1, times + 1):
        time = str(base_number) * i
        result += f"{time} * {time} = {int(time) * int(time)}{jump}"
    return result


# Ejercicio 2. Escriba un programa en Python que acepte una cadena de 
# texto e indique si todos sus caracteres son alfabéticoss.
def only_alphabetics():
    allowed_letters = "abcdefghijklmnñopqrstuvwxyz "
    word = input("Ingrese una palabra: ")
    message = "Todos los carácteres son alfabéticos."
    
    for letter in word:
        if letter not in allowed_letters:
            message = "Se han encontrado caracteres no alfabéticos"
    return message

# Ejercicio 3. Escriba un programa en Python que acepte un número entero 
# 𝑛 y realice una ecuación planteada.
def ecuation():
    try:
        limit = int(input("Ingrese un número entero que será la cantidad de iteraciones: "))
    except:
        return "El valor no es un número entero"

    total = 0
    before = 1
    for _ in range(1, limit + 1):
        try:
            number = int(input(f"Ingrese un número entero para multiplicar en la iteración {_}: ")) ** 2
            total = number * before
            before = total
        except:
            return "El valor no es un número entero"

    return f"El resultado de la multiplicación sucesiva es: {total}"
    

# Ejercicio 4. Escriba un programa en Python que acepte dos cadenas de texto
# y compute el producto cartesiano letra a letra entre ellas
def cartesian_product():
    factor_a = input("Ingrese un carácter 'a': ")
    factor_b = input("Ingrese un carácter 'b': ")
    result = ""
    for a in factor_a:
        for b in factor_b:
            result += f"{a}{b}"
            result += ", " if b != factor_b[-1] else ""
        result += jump if a != factor_a[-1] else ""
    return result


# Ejercicio 5. Escriba un programa en Python que acepte dos valores enteros (x e y) que
# representarán un punto (objetivo) en el plano. El programa simulará el movimiento de
# un "caballo" de ajedrez moviéndose de forma alterna: 2 posiciones en x + 1 posición en
# y. El siguiente movimiento que toque sería para moverse 1 posición en x + 2 posiciones
# en y. El programa deberá ir mostrando los puntos por los que va pasando el "caballo"
# hasta llegar al punto objetivo
def horse_movement():
    try:
        x_objetive = int(input("Objetivo x: "))
        y_objetive = int(input("Objetivo y: "))
    except:
        return "El valor no es un número entero"
    
    x = 0
    y = 0
    plus = "y"
    result = ""
    result += f"({x}, {y}), "

    while x != x_objetive or y != y_objetive:
        if len(result.split(")")) > 30:
            result = f"El programa ha llegado un punto donde se queda haciendo circulos: {result}"
            return result

        if plus == "x":  # x += 2 & y += 1
            x = x + 2 if x < x_objetive else x - 2
            y = y + 1 if y < y_objetive else y - 1
            plus = "y"
            result += f"({x}, {y}), "

        if plus == "y": # x += 1 & y += 2
            x = x + 1 if x < x_objetive else x - 1
            y = y + 2 if y < y_objetive else y - 2
            plus = "x"
            result += f"({x}, {y}), "

    return result[:-2]

def main():
    clear()
    exercise = input("Escriba el número del ejercicio que desea ejecutar: \
    \n1. Cantidad de vocales \n2. Multiplicaciones \n3. Solo alfabéticos \n4. Ecuación\n5. Producto cartesiano\n6. Movimiento de caballo\
    \n0. Salir\nElección: ")
    if exercise == "1":
        print(how_many_vowels())
    elif exercise == "2":
        print(multiplications())
    elif exercise == "3":
        print(only_alphabetics())
    elif exercise == "4":
        print(ecuation())
    elif exercise == "5":
        print(cartesian_product())
    elif exercise == "6":
        print(horse_movement())
    elif exercise == "0":
        exit()
    else:
        clear()
        print("No se encuentra el ejercicio")
    if (input("Presione enter para continuar o 0 para salir") == "0"):
        exit()
    clear()
    main()

if __name__ == "__main__":
    main()