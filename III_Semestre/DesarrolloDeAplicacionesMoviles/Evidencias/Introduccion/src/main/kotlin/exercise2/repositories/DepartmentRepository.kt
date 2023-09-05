package exercise2.repositories

import exercise2.models.Department
import exercise2.models.Employee

interface DepartmentRepository {

    fun getDepartments(): MutableList<Department>;

    fun getPayroll(department: Department): Double;

    fun addEmpployee(department: Department, employee: Employee)

    fun updateEmpployee(department: Department, employee: Employee)

    fun deleteEmpployee(department: Department, employee: Employee)

}