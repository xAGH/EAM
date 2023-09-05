package exercise2.controllers

import exercise2.models.Client
import exercise2.models.Department
import exercise2.models.Employee
import exercise2.models.Position
import exercise2.services.ClientService
import utils.printUI

class ClientController: BaseController {

    private val clientService: ClientService = ClientService();

    fun showOptions() {
        val message: String = "¿Qué desea hacer con los clientes?"
        val options: Map<String, () -> Unit> = mapOf(
            "Crear / Actualizar" to { upsert() },
            "Consultar" to { list(clientService.getClients()) },
            "Eliminar" to { delete() },
        );
        printUI(message, options);
    }

    private fun upsert(): Unit {
        val id = requestString("identificación");
        val fullname = requestString("nombre completo");
        val email = requestString("correo electrónico");
        val address = requestString("dirección de resiodencia");
        val phone = requestString("número de teléfono");
        clientService.upsert(id, fullname, email, address, phone)
    }

    private fun delete() = clientService.delete(requestString("identificación"));

}