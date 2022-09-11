try:
    start = int(input("Valor de inicio: "))
    number = int(input("Número de valores: "))
except:
    print("Número no válido")

fibonacci = [start, start + 1]

for _ in range(start, number - 2):
    fibonacci.append(fibonacci[-1] + fibonacci[-2])

print(f"Serie fibonacci: {fibonacci}")
