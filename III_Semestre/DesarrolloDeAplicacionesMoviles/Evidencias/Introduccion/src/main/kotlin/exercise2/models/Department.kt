package exercise2.models

data class Department(
    val name: String,
    var employees: MutableList<Employee> = mutableListOf()
) {
    override fun toString(): String = this.name;
};
