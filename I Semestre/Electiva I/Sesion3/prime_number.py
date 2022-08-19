try:
    number = int(input("Número:"))
except:
    print("Número no válido")

multiplies = 0
for i in range(number, 0, -1):
    multiplies += 1 if number % i == 0 else 0

print((f"El número {number} no es primo" if multiplies > 2 else f"El número {number} es primo") + f" ya que tiene {multiplies} múltiplos.")