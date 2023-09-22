try:
    number = int(input("Número base: "))
    times = int(input("Número de multiplicaciones: "))
except:
    print("Número no válido")

if times == 0:
    print("No se ha calculado nada.")

for time in range(1, times + 1):
    result = int(str(number) * time)
    print(f"{result} . {result} = {result * result}")