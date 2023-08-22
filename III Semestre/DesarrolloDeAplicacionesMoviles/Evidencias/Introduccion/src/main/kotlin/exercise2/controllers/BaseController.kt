package exercise2.controllers

import utils.printUI

interface BaseController {

    fun <T> list(entities: MutableList<T>): Unit {
        var message = "";
        if (entities.size == 0) {
            println("No hay datos para mostrar");
            return;
        }
        for (index in entities.indices) message += "${index + 1}. ${entities[index]}.\n"
        print(message)
    }

    fun requestString(field: String): String {
        print("${field.replaceFirstChar { it.uppercase() }}: ")
        val input = readln();
        if (!stringIsValid(input)) {
            println("El valor ingresado es inválido.");
            return requestString(field);
        }
        return input;
    }

    fun requestInt(field: String): Int {
        print("${field.replaceFirstChar { it.uppercase() }}: ")
        return try {
            readln().toInt();
        } catch (_: NumberFormatException) {
            println("El valor ingresado es inválido.");
            requestInt(field);
        };
    }

    fun requestDouble(field: String): Double {
        print("${field.replaceFirstChar { it.uppercase() }}: ")
        return try {
            readln().toDouble();
        } catch (_: NumberFormatException) {
            println("El valor ingresado es inválido.");
            requestDouble(field)
        };
    }

    fun <T> requestSingleEntity(entities: MutableList<T>, entityName: String): T {
        var message = "Seleccione $entityName: \n";
        val indices = entities.indices;
        for (index in indices) {
            message += "${index + 1}. ${entities[index].toString()}\n"
        }
        message += "> "
        do {
            print(message);
            val option = readln().toIntOrNull();
            if (option != null && option - 1 in indices) {
                return entities[option-1]
            }
            println("Índice inválido");
            continue
        } while(true);
    }

    fun <T> requestMultipleEntity(entities: MutableList<T>, entityname: String): MutableList<T> {
        if (entities.size == 0) return mutableListOf();
        var message: String = "Seleccione $entityname. Si son varios, separelos por coma (,). Enter para omitir.\n";
        for (index in entities.indices) {
            message += "${index + 1}. ${entities[index].toString()}\n"
        }
        message += "> "
        val selectedEntities = mutableListOf<T>();
        print(message);
        val options = readln();
        if (!options.isBlank()){
            val indices = options.replace(" ", "").split(",")
            for(i in indices) {
                val index = i.toIntOrNull();
                if (index != null && index - 1 in entities.indices){
                    selectedEntities.add(entities[index - 1])
                }
            }
        }
        return selectedEntities;
    }

    fun stringIsValid(value: String?): Boolean = !(value.isNullOrEmpty() && value.isNullOrBlank())

}