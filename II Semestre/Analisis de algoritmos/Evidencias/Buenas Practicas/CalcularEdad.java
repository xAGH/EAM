
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeParseException;
import javax.swing.JOptionPane;

/**
 * CalcularEdad -> Se requiere ingresar la fecha de nacimiento y que este
 * permita calcular la edad actual con años, meses y días.
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
        JOptionPane.showMessageDialog(
                null,
                calcularEdad(solicitarEdad()),
                "Resultado",
                JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Metodo para validar que la fecha de nacimiento sea valida.
     * 
     * @param date -> Fecha de nacimiento recibida por el usuario.
     * @return true si la fecha de nacimiento es válida, false en caso
     *         contrario.
     * @throws DateTimeParseException si la fecha de nacimiento no es válida.
     */
    private static Boolean validarEntrada(String date) throws DateTimeParseException {
        try {
            // Se valida si la fecha de nacimiento es menor a la fecha de hoy por medio de
            // números.
            if (LocalDate.parse(date).toEpochDay() < LocalDate.now().toEpochDay())
                return true; // Se retorna true si la fecha de nacimiento es menor a la fecha de hoy y tiene
                             // un formato aceptado.
                             // Error porque la fecha de nacimiento es mayor a hoy.
        } catch (DateTimeParseException e) {
        }
        // Error porque la fecha de nacimiento no es válida.
        errorNoValido();
        return false;
    }

    /**
     * Método para solicitar la fecha de nacimiento al usuario.
     * 
     * @see javax.swing.JOptionPane -> Cuadros de diálogo para mostrar mensajes.
     * @return La edad en tipo LocalDate si es válida, en caso contrario se utiliza
     *         recursión.
     */
    private static LocalDate solicitarEdad() {
        String edad = JOptionPane
                .showInputDialog("Ingrese su fecha de nacimiento en el formato aaaa-mm-dd, ejemplo: 1990-01-01: ");

        if (!validarEntrada(edad)) // Si la entrada no es válida, se llama de nuevo al método.
            return solicitarEdad();
        return LocalDate.parse(edad);
    }

    /**
     * Método para calcular la edad actual con años, meses y días.
     * 
     * @param fechaNacimiento -> Fecha de nacimiento recibida.
     * @return Mensaje indicando la edad actual en años, meses y días.
     */
    private static String calcularEdad(LocalDate fechaNacimiento) {
        // Utilidad pata ver la diferencia entre 2 fechas.
        Period diferencia = Period.between(fechaNacimiento, LocalDate.now());
        Integer anio = diferencia.getYears();
        Integer mes = diferencia.getMonths();
        Integer dia = diferencia.getDays();

        String edad = String.format(
                "Su edad es de %d año%s, %d mes%s y %d días.",
                anio,
                anio > 1 ? "s" : "", // Define si año es en plural o singular
                mes,
                mes > 1 ? "es" : "", // Define si mes es en plural o singular
                dia);

        return edad;
    }

    /**
     * Mensaje de error porque la fecha de nacimiento no es válida.
     */
    private static void errorNoValido() {
        JOptionPane.showMessageDialog(
                null,
                "La fecha ingresada no es válida",
                "Error en entrada de datos",
                JOptionPane.ERROR_MESSAGE);
    }
}