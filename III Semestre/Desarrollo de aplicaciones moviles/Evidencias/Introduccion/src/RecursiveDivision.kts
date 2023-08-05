/**
 * Escribir en kotlin una función recursiva que divida dos números enteros por medio de
 * restas sucesivas. Ejemplo: 12/3 es lo mismo que decir: 12 - 3 = 9, 9 - 3 = 6, 6 - 3 = 3, 3 - 3
 * = 0. Hubo 4 restas hasta que dio 0, por lo tanto 12/3 = 4.
 */

fun division(dividend: Int, divisor: Int): Int {
    if (dividend < divisor) return 0;
    return 1 + division(dividend - divisor, divisor);
}

val dividend: Int = 12;
val divisor: Int = 3;
val divisionResult: Int = division(dividend, divisor);
println("El resultado de dividir $dividend entre $divisor es $divisionResult")