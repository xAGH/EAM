package exercise2.services

import exercise2.models.Department
import exercise2.repositories.AdminRepository

class AdminService: AdminRepository {

    val employeeService: EmployeeService = EmployeeService();
    val departmentService: DepartmentService = DepartmentService()

    override fun getPayroll(): Double = employeeService.getEmployees().sumOf { it.salary }

    override fun getDepartmentPayroll(department: Department): Double = departmentService.getPayroll(department);

    override fun getDepartments(): MutableList<Department> = departmentService.getDepartments();

}