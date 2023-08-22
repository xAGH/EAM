package exercise2.services

import exercise2.models.Department
import exercise2.models.Employee
import exercise2.repositories.DepartmentRepository

private val departments: MutableList<Department> = mutableListOf(
    Department("Ventas"),
    Department("Recursos Humanos"),
    Department("Gerencia"),
    Department("Operativo"),
);

class DepartmentService: DepartmentRepository {

    override fun getDepartments(): MutableList<Department> = departments;

    override fun getPayroll(department: Department): Double {
        if (department.employees.size == 0) return 0.0;
        return department.employees.sumOf { it.salary }
    }

    override fun addEmpployee(department: Department, employee: Employee) {
        department.employees.add(employee);
    }

    override fun deleteEmpployee(department: Department, employee: Employee) {
        department.employees.removeIf{ it.id == employee.id }
    }

    override fun updateEmpployee(department: Department, employee: Employee) {
        this.deleteEmpployee(department, employee);
        this.addEmpployee(department, employee);
    }

}