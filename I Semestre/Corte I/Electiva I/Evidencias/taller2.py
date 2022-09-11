def ejercicio1():
    print("Programa que acepta una lista de valores numéricos y obtenga su valor máximo sin utilizar la función max.")
    numbers_list =  [6, 3, 9, 2, 10, 31, 15, 7]
    max_number = 0
    is_valid = False
    
    for n in numbers_list:
        try:
            float(n)
            is_valid = True

        except:
            is_valid = False
            print("Alguno de los valores no son numéricos.")

    if is_valid:
        for number in numbers_list:
            max_number = number if number > max_number else max_number
        print(f"El número mayor de la lista es: {max_number}")

def ejercicio2():
    print("Programa que acepta una lista y elimina sus elementos duplicados.")
    elements = ["this", "this", "is", "a", "real", "real", "real", "story"]
    
    if len(elements) > 0:
        new_elements = []
        for element in elements:
            if element not in new_elements:
                new_elements.append(element) 
        print(f"Lista de elementos: {new_elements}")
    else:
        print("La lista está vacia.")

def ejerciico3():
    lists = [0, 10, [20, 30], 40, 50, [60, 70, 80], [90, 100, 110, 120]]
    planned_list =  []
    for element in lists:
        if type(element) == list:
            for subelement in element:
                if type(subelement) == list:
                    print("Solo se permite un nivel de anidamiento")
                    return
                planned_list.append(subelement)
        else:
            planned_list.append(element)
    print(f"La lista aplanada es: {planned_list}")

def ejercicio4():
    print("Programa que acepta una lista y elimina sus elementos duplicados consecutivos.")
    elements = [0, 0, 1, 2, 3, 4, 4, 5, 6, 6, 6, 7, 8, 9, 4, 4]
    new_elements = []

    if len(elements) > 0:
        for index, element in enumerate(elements):
            try:
                if elements[index + 1] != element:
                    new_elements.append(element)
            except:
                pass

        print(f"Lista de elementos: {new_elements}")
    else:
        print("La lista está vacia.")

def validate_matriz(matriz):
    length = len(matriz)
    for element in matriz:
        if type(element) != list:
            return False
        if len(element) != length:
            return False
    return True

def ejercicio5():
    print('Programa que acepta una lista de listas representando una matriz numérica y computa la suma de los elementos de la diagonal principal')
    matriz = [[4, 6, 1], [2, 9, 3], [1, 7, 7]]
    
    if len(matriz) > 0:
        if validate_matriz(matriz):
            plus = 0
            for list_number in range(len(matriz)):
                plus += matriz[list_number][list_number]
            print(F"La suma de la diagonal principal es: {plus}")
        else:
            print("La matriz debe de ser cuadrada. Ej. [[1,1,1], [2,2,2], [3,3,3]]")
    
    else:
        print("La lista está vacia.")

def main():
    print("Ejercicio 1:")
    ejercicio1()
    print("\n")
    print("Ejercicio 2:")
    ejercicio2()
    print("\n")
    print("Ejercicio 3:")
    ejerciico3()
    print("\n")
    print("Ejercicio 4:")
    ejercicio4()
    print("\n")
    print("Ejercicio 5:")
    ejercicio5()

if __name__ == '__main__':
    main()