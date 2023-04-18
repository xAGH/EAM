# Programa que busca un valor en un arreglo de datos dados
# después de organizar este.

"""Función de solicitud de datos"""
def solitar_datos() -> tuple:
    datos: list[int] = []
    print("Datos del arreglo:")
    while True:
        numero = input("Ingrese un número. (Ingrese un valor diferente a un número para terminar)\nNúmero: ")
        if numero.isdigit():
            datos.append(int(numero))
        else:
            break
    
    while True:
        a_buscar = input("Ingrese el número a buscar: ")
        if a_buscar.isdigit():
            a_buscar = int(a_buscar)
            break

    return datos, a_buscar

"""Función encargada de ordenar."""
def ordenar(arreglo: list[int], largor: int) -> None:
    if largor <= 1:
        return
    
    # Ordena el último elemento del arreglo
    ordenar(arreglo, largor - 1)
    # Último valor de la lista ordenado
    ultimo: int = arreglo[largor - 1]
    # Iterador que controlará el flujo a continuación, su valor es el penúltimo valor
    iterador: int = largor - 2
    
    # Mientars que el iterador no sea negativo y sea mayor que el último,
    # se corren los espacios hacia la derecha
    while iterador >= 0 and arreglo[iterador] > ultimo:
        arreglo[iterador + 1] = arreglo[iterador]
        iterador -= 1

    # Coloca el valor en su posición correcta
    arreglo[iterador + 1] = ultimo
 
"""Función para buscar un valor indicado en una lista dada."""
def busqueda(arreglo: list[int], dato: int, izquierda: int, derecha: int) -> int:
    # Dado que la parte derecha es menor que la izquierda
    # el dato no ha sido encontrado.
    if izquierda > derecha:
        return -1
    
    indice_del_medio: int = (izquierda + derecha) // 2
    elemento_del_medio: int = arreglo[indice_del_medio]

    # Se retorna el índice del dato del medio si este es el dato buscado.
    if elemento_del_medio == dato: return indice_del_medio
    if dato < elemento_del_medio:
        return busqueda(arreglo, dato, izquierda, indice_del_medio - 1)
    else:
        return busqueda(arreglo, dato, indice_del_medio + 1, derecha)

"""Función main encargada de arrancar la aplicación."""
def main() -> None:
    datos, dato_a_buscar = solitar_datos()
    print(f"Arreglo original: {str(datos)}") 
    ordenar(datos, len(datos))
    print(f"Datos  ordenados: {str(datos)}")
    encontrado: int = busqueda(datos, dato_a_buscar, 0, len(datos) - 1)
    mensaje: str
    if encontrado == -1:
        mensaje = f"El dato no se ha encontrado."
    else:
        mensaje = f"El dato se ha encontrado en la posición {encontrado}"

    print(mensaje)

# Condición que se encarga de llamar el método main dada la
# condincición que se ejecute el módulo principal.
if __name__ == "__main__":
    main()
