package exercise2.services

import exercise2.models.Department
import exercise2.models.Employee
import exercise2.models.Position
import exercise2.repositories.EmployeeRepository

private val employees: MutableList<Employee> = mutableListOf();

class EmployeeService: EmployeeRepository {

    private val departmentService: DepartmentService = DepartmentService()
    private val positionService: PositionService = PositionService();

    override fun upsert(
        id: String,
        fullname: String,
        email: String,
        salary: Double,
        department: Department,
        subordinates: List<String>,
        position: Position
    ): Employee {
        var employee: Employee? = employees.find { it.id == id }
        if (employee == null) {
            employee = Employee(id, fullname, email, salary, department, mutableListOf(), position);
            employees.add(employee)
            departmentService.addEmpployee(department, employee);
            println("Se ha creado el empleado.")
        }
        else {
            employee.id = id
            employee.email = email;
            employee.salary = salary;
            employee.position = position;
            employee.department = department;
            employee.fullname = fullname;
            departmentService.updateEmpployee(department, employee);
            println("Se ha actualizado el empleado.")
        }
        val index = employees.indexOf(employee)
        subordinates.forEach {subordinateId ->
            val subordinateIsValid: Boolean = validateSubordinate(subordinateId, employee);
            if (subordinateIsValid) employee.subordinates.add(subordinateId);
        }
        employees[index] = employee;
        return employee;
    }

    override fun delete(id: String): Unit {
        val employee = getEmployee(id);
        if (employee == null) {
            println("El empleado con identificación $id no existe.")
            return;
        };
        if (employees.size == 1) {
            println("La empresa no se puede quedar sin empleados")
            return
        }
        employees.remove(employee);
        println("Se ha eliminado el empleado con id $id satisfactoriamente.")
    }

    override fun getEmployee(id: String): Employee? = employees.find { it.id == id };

    override fun getAvailableSubordinates(id: String, position: Position): MutableList<Employee> {
        return employees.filter { it.id != id && it.position.importance > position.importance }.toMutableList()
    }

    override fun getEmployees(): MutableList<Employee> = employees;

    override fun getDepartments(): MutableList<Department> = departmentService.getDepartments();

    override fun getPositions(): MutableList<Position> = positionService.getPositions();

    private fun validateSubordinate(subordinateId: String, employee: Employee): Boolean {
        val subordinateEmployee = getEmployee(subordinateId);
        val alredyIsSubordinate: Boolean = employee.subordinates.contains(subordinateId);
        val subordinateIsTheSamePerson: Boolean = employee.id == subordinateId;
        val employeePositionIsSuperior: Boolean = subordinateEmployee?.position?.importance!! >= employee.position.importance
        return !alredyIsSubordinate &&
                !subordinateIsTheSamePerson &&
                employeePositionIsSuperior
    }

}