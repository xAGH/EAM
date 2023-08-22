package exercise2;

import exercise2.controllers.AdminController
import exercise2.controllers.EmployeeController
import exercise2.controllers.ClientController
import utils.printUI

fun run() {
    val messgae: String = "Ingrese el número correspondiente al módulo de interés:";
    val options: Map<String, () -> Unit> = mapOf(
        "Empleados" to { EmployeeController().showOptions() },
        "Clientes" to { ClientController().showOptions() },
        "Administrativo" to { AdminController().showOptions() },
    );
    printUI(messgae, options);
}