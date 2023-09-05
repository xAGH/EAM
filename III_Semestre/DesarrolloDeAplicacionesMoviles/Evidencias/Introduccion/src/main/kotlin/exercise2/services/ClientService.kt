package exercise2.services

import exercise2.models.Client
import exercise2.repositories.ClientRepository

class ClientService: ClientRepository {

    private val clients: MutableList<Client> = mutableListOf();

    override fun upsert(id: String, fullname: String, email: String, address: String, phone: String): Client {
        var client: Client? = clients.find { it.id == id }
        if (client == null) {
            client = Client(id, fullname, email, address, phone);
            clients.add(client)
            println("Se ha creado el cliente.")
        }
        else {
            client.id = id
            client.fullname = fullname;
            client.email = email;
            client.address = address;
            client.phone = phone;
            println("Se ha actualizado el cliente.")
        }
        val index = clients.indexOf(client)
        clients[index] = client;
        return client;
    }

    override fun delete(id: String): Unit {
        val client = getClient(id);
        if (client == null) {
            println("El cliente con identificación $id no existe.")
            return;
        };
        clients.remove(client);
        println("Se ha eliminado el cliente con id $id satisfactoriamente.")
    }

    override fun getClients(): MutableList<Client> = clients

    override fun getClient(id: String): Client? = clients.find { it.id == id };
}