package exercise1;

private fun division(dividend: Int, divisor: Int): Int {
    if (divisor == 0) { return 0 };
    if (dividend < divisor) return 0;
    return 1 + division(dividend - divisor, divisor);
}

private fun inputNumber(type: String): Int {
    print("Ingrese el $type: ")
    return try {
        readln().toInt();
    } catch (e: NumberFormatException) {
        println("Se ha ingresado un valor no numérico, se establece el $type como 1.")
        1;
    };
}

fun divide() {
    val dividend = inputNumber("dividendo");
    val divisor = inputNumber("divisor");
    println("El resultado de dividir $dividend entre $divisor es ${division(dividend, divisor)}");
}