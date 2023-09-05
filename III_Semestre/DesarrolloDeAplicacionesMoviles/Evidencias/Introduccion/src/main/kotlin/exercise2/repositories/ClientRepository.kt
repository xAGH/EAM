package exercise2.repositories

import exercise2.models.Client

interface ClientRepository {

    fun upsert(
        id: String,
        fullname: String,
        email: String,
        address: String,
        phone: String ,
    ): Client;

    fun delete(id: String): Unit;

    fun getClients(): MutableList<Client>;

    fun getClient(id: String): Client?;

}