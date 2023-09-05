package exercise2.controllers

import exercise2.models.Department
import exercise2.services.AdminService
import utils.printUI

class AdminController: BaseController {

    private val adminService: AdminService = AdminService()

    fun showOptions() {
        val message: String = "¿Qué desea administrar?"
        val options: Map<String, () -> Unit> = mapOf(
            "Obtener nómina total" to { getPayroll() },
            "Obtener nómina de departamento" to { getDepartmentPayroll() }
        );
        printUI(message, options);
    }

    private fun getPayroll(): Unit {
        println("La nóminca de la empresa es ${adminService.getPayroll()}")
    }

    private fun getDepartmentPayroll(): Unit {
        val department = requestSingleEntity<Department>(adminService.getDepartments(), "el departamento");
        println("La nóminca del departamento ${department.name} es ${adminService.getDepartmentPayroll(department)}")
    }

}