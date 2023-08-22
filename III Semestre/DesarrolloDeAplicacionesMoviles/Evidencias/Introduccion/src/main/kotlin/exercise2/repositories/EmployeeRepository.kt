package exercise2.repositories

import exercise2.models.Department
import exercise2.models.Employee
import exercise2.models.Position

interface EmployeeRepository {

    fun upsert(
        id: String,
        fullname: String,
        email: String,
        salary: Double,
        department: Department,
        subordinates: List<String>,
        position: Position,
    ): Employee;

    fun delete(id: String): Unit;

    fun getEmployee(id: String): Employee?;

    fun getAvailableSubordinates(id: String, position: Position): MutableList<Employee>;

    fun getEmployees(): MutableList<Employee>;

    fun getDepartments(): MutableList<Department>;

    fun getPositions(): MutableList<Position>;

}