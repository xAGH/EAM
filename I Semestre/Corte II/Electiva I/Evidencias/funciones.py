# Escriba una función en Python que indique si un número está en un determinado
# intervalo (solución)
def ejercicio1(numero: float, limite_min: float, limite_max: float) -> bool:
    print("Ejercicio 1")
    return limite_min <= numero <= limite_max

# Escriba una función en Python que reciba una lista de valores enteros y devuelva otra
# lista sólo con aquellos valores pares (solución).
def ejercicio2(lista: list[int]) -> str or list[int]:
    print("\nEjercicio 2")
    if type(lista) != list:
        return "Envíe una lista como parámetro"
    try:
        lista = [int(x) for x in lista]
    except:
        return "La lista no contiene solo números enteros"
    
    return [numero for numero in lista if numero % 2 == 0]

# Escriba una función en Python que indique si un número es perfecto. Utilice una
# función auxiliar que calcule los divisores propios.
def aux_ejercicio3_divisores(numero: float or int) -> list[float or int]:
    return [x for x in range(1, numero) if numero % x == 0]

def ejercicio3(numero: float) -> bool:
    print("\nEjercicio 3") 
    return sum(aux_ejercicio3_divisores(numero)) == numero

# Escriba una función en Python que determine si una cadena de texto es un palíndromo
def ejercicio4(cadena: str) -> bool:
    print("\nEjercicio 4")
    cadena = cadena.replace(" ", "")
    return list(cadena) == list(reversed(cadena))

# Escriba una función en Python que determine si una cadena de texto es un pangrama
def ejercicio5(cadena: str) -> bool:
    print("\nEjercicio 5")
    abecedario = "abcdefghijklmnoqrstuvwxyz"
    for letra in abecedario:
        if not (letra in cadena.lower()):
            return False
    return True

if __name__ == '__main__':
    print(ejercicio1(3, 2 ,5))
    print(ejercicio2([1, 2, 3, 4, 5, 6, 7, 8, 9]))
    print(ejercicio3(8128))
    print(ejercicio4("ana lava lana"))
    print(ejercicio5("The quick brown fox jumps over the lazy dog"))
