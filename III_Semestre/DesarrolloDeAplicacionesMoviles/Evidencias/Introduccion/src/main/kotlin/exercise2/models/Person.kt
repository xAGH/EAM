package exercise2.models

abstract class Person protected constructor(
    open var id: String,
    open var fullname: String,
    open var email: String);