import java.util.ArrayList;
import java.util.Arrays;

public class Busqueda {

    public static void main(String[] args) {
        // Se puede definir un arreglo estático y buscar con el metodo
        // contains de la clase Arrays
        int[] datos = { 2, 9, 21, 12, 15, 56 };
        int datoABuscar = 9;
        System.out.println(Arrays.binarySearch(datos, datoABuscar)); // Retorna true 1. Ha sido encontrado.

        // También se puede definir un ArryLis y acceder directamente
        // a su método de búsqueda.
        ArrayList<Integer> datos2 = new ArrayList<>();
        datos2.add(2);
        datos2.add(9);
        datos2.add(21);
        datos2.add(12);
        datos2.add(15);
        datos2.add(56);
        System.out.println(datos2.contains(datoABuscar)); // Retorna true. Ha sido encontrado.
    }
}
