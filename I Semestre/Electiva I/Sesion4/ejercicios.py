# Trabajo presentado por Alejandro Giraldo Herrera
import os

# Funciones generales
clear = lambda: os.system('cls' if os.name in ('nt', 'dos') else 'clear')
jump = "\n"

# Ejericio Inicial. Dada una cadena de texto, indique el número de vocales que tiene.
def how_many_vowels():
    word = input("Ingrese una plabra: ")
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

print(ecuation())