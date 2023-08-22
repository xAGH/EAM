package exercise2.controllers

import exercise2.models.Department
import exercise2.models.Employee
import exercise2.models.Position
import exercise2.services.EmployeeService
import utils.printUI

class EmployeeController: BaseController {

    private val employeeService: EmployeeService = EmployeeService();

    fun showOptions() {
        val message: String = "¿Qué desea hacer con los empleados?"
        val options: Map<String, () -> Unit> = mapOf(
            "Crear / Actualizar" to { upsert() },
            "Consultar" to { list(employeeService.getEmployees()) },
            "Eliminar" to { delete() },
        );
        printUI(message, options);
    }

    private fun upsert(): Unit {
        val id = requestString("identificación");
        val fullname = requestString("nombre completo");
        val email = requestString("correo electrónico");
        val salary = requestDouble("salario(punto (.) como decimal)");
        val department = requestSingleEntity<Department>(employeeService.getDepartments(), "el departamento");
        val position = requestSingleEntity<Position>(employeeService.getPositions(), "la posición");
        val subordinates = requestMultipleEntity<Employee>(
            employeeService.getAvailableSubordinates(id, position),
            "los empleados subordinados"
        ).map { it.id }
        employeeService.upsert(id, fullname, email, salary, department, subordinates, position);
    }

    private fun delete() = employeeService.delete(requestString("identificación"));

}