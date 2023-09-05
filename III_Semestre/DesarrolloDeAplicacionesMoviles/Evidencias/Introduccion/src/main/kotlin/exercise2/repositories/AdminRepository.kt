package exercise2.repositories

import exercise2.models.Department

interface AdminRepository {

    fun getPayroll(): Double

    fun getDepartmentPayroll(department: Department): Double

    fun getDepartments(): MutableList<Department>;

}