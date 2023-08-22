package exercise2.models

data class Company(
    val businessName: String,
    val nit: String,
    val address: String,
    val employees: MutableList<Employee>,
    val clients: MutableList<Client>? = null,
);
