# Defina una clase Fraction que represente una fracción con numerador y denominador enteros
# y utilice los métodos mágicos para poder sumar, restar, multiplicar y dividir estas fracciones.
# Además de esto, necesitaremos:
# • gcd(a, b) como método estático siguiendo el algoritmo de Euclides para calcular
# el máximo común divisor entre a y b.
# • __init__(self, num, den) para construir una fracción (incluyendo simplificación de
# sus términos mediante el método gcd().
# • __str__(self) para representar una fracción.

from decimal import DivisionByZero

class Fraction:

    num: int
    den: int

    @staticmethod
    def gcd(a: int, b: int) -> int:
        bigger, smaller = sorted([abs(a), abs(b)], reverse = True)
        module = bigger % smaller
        return smaller if module == 0 else Fraction.gcd(smaller, module)

    @staticmethod
    def only_integers(*nums):
        """
            Validates that the numbers received are integers.
            Raise TypeError if the type is diferent to int.
        """
        for num in nums:
            if type(num) != int: raise TypeError("El numerador y denominaodr deben de ser enteros.")

    @staticmethod
    def reduce_fraction(num: int, den:int):
        gcd = Fraction.gcd(num, den)
        return num // gcd, den // gcd


    def __init__(self, num: int, den: int) -> None:
        if den == 0: raise DivisionByZero("El denomidanor no puede ser 0")
        Fraction.only_integers(num, den)
        num, den = Fraction.reduce_fraction(num, den)
        self.num = num
        self.den = den

    def __str__(self) -> str:
        num = self.num
        den = self.den
        if (den < num < 0) or (num < den < 0): 
            num *= -1
            den *= -1
        num_len: int = len(str(num)) if num > 0 else len(str(num)) - 1
        den_len: int = len(str(den)) if den > 0 else len(str(den)) - 1
        largest: int = num_len if num > den else den_len
        num_len = num_len - largest if num_len > largest else largest - num_len
        den_len = den_len - largest if den_len > largest else largest - den_len
        num_spaces: str = " " * (num_len // 2)
        den_spaces: str = " " * (den_len // 2)
        return f"{num_spaces}{num}{num_spaces}\n{'‒' * largest}\n{den_spaces}{den}{den_spaces}"

    def __add__(self, fraction):
        num = (self.num * fraction.den) + (self.den * fraction.num )
        den = self.den * fraction.den
        return Fraction(num, den)

    def __sub__(self, fraction):
        num = (self.num * fraction.den) - (self.den * fraction.num )
        den = self.den * fraction.den
        return Fraction(num, den)

    def __mul__(self, fraction):
        num = self.num * fraction.num
        den = self.den * fraction.den
        return Fraction(num, den)

    def __truediv__(self, fraction):
        num = self.num * fraction.den
        den = self.den * fraction.num
        return Fraction(num, den)

    def __floordiv__(self, fraction):
        num = self.num * fraction.den
        den = self.den * fraction.num
        return Fraction(num, den)

    

fraccion = Fraction(25323232, 3)
fraccion2 = Fraction(40, 45) 
print("Suma:")
print(fraccion + fraccion2)
print("Resta:")
print(fraccion - fraccion2)
print("Multiplicación:")
print(fraccion * fraccion2)
print("División exacta:")
print(fraccion / fraccion2)
print("División redondeada:")
print(fraccion // fraccion2)