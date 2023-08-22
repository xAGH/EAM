import exercise1.divide;
import exercise2.run;
import utils.printUI;
import kotlin.system.exitProcess

fun main(args: Array<String>) {
    var message: String = "Ingrese el número correspondiente el ejericio que quiere ejecutar:";
    var options: Map<String, () -> Unit> = mapOf(
        "Restas suscesivas (división recursiva)" to { divide() },
        "CRUD empresa" to { run() }
    );
    printUI(message, options)
    print("Saliendo...");
    exitProcess(1);
}
