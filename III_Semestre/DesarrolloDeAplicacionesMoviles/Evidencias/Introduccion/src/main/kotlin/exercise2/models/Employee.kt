package exercise2.models

data class Employee (
    override var id: String,
    override var fullname: String,
    override var email: String,
    var salary: Double,
    var department: Department,
    val subordinates: MutableList<String> = mutableListOf(),
    var position: Position,
): Person(id, fullname, email);