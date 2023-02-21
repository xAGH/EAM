import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeParseException;
import javax.swing.JOptionPane;

/**
 * PreparacionCafe -> Se requiere una receta paso a paso de cómo preparar café.
 * 
 * @author Alejandro Giraldo Herrera
 * @version 1.0
 */
public class CalcularEdad {

    /**
     * Método para inicializar la aplicación.
     * 
     * @param args -> Argumentos con los que inicializa la aplicación.
     */
    public static void main(String[] args) {
        receta();
    }

    private static void receta() {
        dialogo("Receta para preparar café paso a paso.");
        dialogo("Llene con agua al gusto algun recipiente que se pueda calentar");
        dialogo("Ponga el recipiente con agua en una estufa, quemador u otro utencilio que le permita calentar");
        dialogo("Caliente el agua hasta que empiece a hervir");

        // Se pregunta la presentación del café
        if (pregunta("¿Es café instantáneo?") == 0) { // 0 = Se ha seleccionado SI.
            dialogo("Vierta en una taza el agua caliente y agregue a gusto el café instantáneo");
        }

        else {
            // El café no es instantáneo, así que se pregunta si el café es molido o no
            if (pregunta("¿El café está molido?") == 1) { // 1 = Se ha seleccionado NO.
                dialogo("Muela el café");
            }

            // Se pregunta si el café se hará en cafetera o no
            if (pregunta("¿Lo hará en cafetera?") == 0) { // 0 = Se ha seleccionado SI.
                preparacionEnCafetera();
            } else {
                preparacionNormal();
            }

            dialogo("Sirva café en algún recipiente");
        }
        dialogo("Agrege azucar o endulzante al gusto");
        dialogo("Ha terminado, disfrute su café");
    }

    /**
     * Método para mostrar un mensaje.
     * 
     * @param msg -> Mensaje a mostrar.
     */
    private static void dialogo(String msg) {
        JOptionPane.showMessageDialog(null, msg);
    }

    /**
     * Método para preguntar al usuario.
     * 
     * @param msg -> Mensaje a mostrar.
     */
    private static Integer pregunta(String msg) {
        return JOptionPane.showConfirmDialog(null, msg); // Si es si retorna 0 de lo contrario retorna 1
    }

    /**
     * Método para mostrar la receta en cafetera.
     */
    private static void preparacionEnCafetera() {
        dialogo("Vierta el agua en el compartimento indicado");
        dialogo("Agruege café al gusto en el compartimento indicado");
        dialogo("Coloque el filtro de café en el compartimento que indique el modelo de la cafetera");
        dialogo("Encender la cafetera hasta que el recipiente donde echó el agua esté vacío");
        dialogo("Apague la cafetera");
    }

    /**
     * Método para mostrar la preparación manual.
     */
    private static void preparacionNormal() {
        dialogo("Agregue el café molido al gusto en el recipiente y apague la fuente de calor");
        dialogo("Espere unos minutos y filtre el café con un filtro para café ");
    }

}