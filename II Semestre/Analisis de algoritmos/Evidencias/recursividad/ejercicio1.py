"""
    Ejercicio 1: Diseñar el producto de 'a' con 'b' ( a>0 , b>0 ) mediante sumas
    sucesivas.
"""
# Función que suma un número 'a' 'b' veces
def suma_suscesiva(a: int, b: int) -> int:
    # Condición controladora
    if b <= 1:
        return a
    
    return a + suma_suscesiva(a, b - 1)

# Función principal
def main() -> None:
    # Creación de excepción al recibir 0 o menor
    MenorACeroExcepcion: Exception = Exception("El número ingresado es menor a 0")

    # Entrada de datos validada
    while True:
        try:
            # Entrada del valor de a convertido a tipo entero
            a: int = int(input("Ingrese el valor de 'a': "))

            # Entrada del valor de b convertido a tipo entero
            b: int = int(input("Ingrese el valor de 'b': "))
            
            # Validación de que los números sean mayores a 0
            if a <= 0 or b <= 0:
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
    print(f"El resultado de sumar '{a}' '{b}' veces es {suma_suscesiva(a, b)}'")

main()