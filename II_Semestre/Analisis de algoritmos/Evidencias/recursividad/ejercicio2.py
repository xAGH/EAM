"""
    Ejercicio 2: Encontrar el máximo común divisor entre dos números
    'a' y 'b', donde ambos son mayores a 0
"""

# Función que recibe dos números y por medio del algoritmo de euclides
# calcula el M.C.D. de estos 
def mcd(numero1: int, numero2) -> int:
    # Función controladora
    if numero2 == 0:
        return numero1

    return mcd(numero2, numero1 % numero2)

# Función principal
def main() -> None:
    # Creación de excepción al recibir 0 o menor
    MenorACeroExcepcion: Exception = Exception("El número ingresado es menor a 0")

    # Entrada de datos validada
    while True:
        try:
            # Entrada del primer número convertido a tipo entero
            numero1: int = int(input("Ingrese el valor del primer número: "))

            # Entrada del segundo número convertido a tipo entero
            numero2: int = int(input("Ingrese el valor del segundo número: "))
            
            # Validación de que los números sean mayores a 0
            if numero1 <= 0 or numero2 <= 0:
                raise MenorACeroExcepcion
            break

        except ValueError:
            # Aviso de excepción por no ingreso de un número
            print("Por favor, ingrese solo números.")
        except MenorACeroExcepcion:
            # Aviso de excepción porque alguno de los valores es menor a 1
            print("Por favor, ingrese solo números mayores a 0")
        except:
            # Aviso por excepcion no controlada
            print("Ha ocurrido un error inesperado")
            exit(0)

    # Impresión de los resultados
    print(f"El M.C.D. de {numero1} y {numero2} es {mcd(numero1, numero2)}")

main()