import java.util.ArrayList;
import java.util.Arrays;

// Explicación de métodos que proporciona Java para el ordenamiento de datos.
public class Ordenar {

    public static void main(String[] args) {
        // Se puede definir un arreglo estático y ordenarlo con el metodo
        // sort de la clase Arrays
        int[] datos = { 2, 9, 21, 12, 15, 56 };
        Arrays.sort(datos);
        String datosOrdenados = Arrays.toString(datos);
        System.out.println("Datos ordenados del array estático: " + datosOrdenados); // Retorna [2, 9, 12, 15, 21, 56]

        // O directamente se puede definir un Arraylist y acceder al
        // método sort de la clase ArrayList
        ArrayList<Integer> datos2 = new ArrayList<>();
        datos2.add(2);
        datos2.add(9);
        datos2.add(21);
        datos2.add(12);
        datos2.add(15);
        datos2.add(56);
        datos2.sort(null);
        System.out.println("Datos ordenados del array dinámico: " + datos2); // Retorna [2, 9, 12, 15, 21, 56]
    }

}