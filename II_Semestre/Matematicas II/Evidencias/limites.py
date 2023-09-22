import os
import sympy

def clear() -> None:
    os.system('clear')

def limit_input() -> int:
    while True:
        clear()
        try:
            return int(input('El límite tiende a: '))

        except:
            continue

def main() -> None:
    clear()
    limit: int = limit_input()
    function: str = input('Ingrese la función. Ejemplo: (x**2 + 5) / 3\nf(x) = ')

    print(sympy.limit(function, 'x', limit, '+-'))

if __name__ == '__main__':
    main()
