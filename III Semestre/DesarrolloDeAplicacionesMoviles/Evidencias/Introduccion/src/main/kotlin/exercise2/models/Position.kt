package exercise2.models

data class Position(
    val name: String,
    val importance: Int,
){
    override fun toString(): String = "${this.name}"
}