package exercise2.models

data class Client(
    override var id: String,
    override var fullname: String,
    override var email: String,
    var address: String,
    var phone: String ,
): Person(id, fullname, email);
