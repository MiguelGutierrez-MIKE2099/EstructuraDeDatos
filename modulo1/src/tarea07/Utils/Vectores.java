package tarea07.Utils;

import java.util.Random;
public class Vectores {
    public static int[] vectorRandom(int longitud, int min, int max) {
        int[] vectorRandom = new int[longitud];
        Random random = new Random();

        //En el contexto de este ciclo, continuaremos generando números aleatorios hasta que se cumplan todas las condiciones requeridas.
        for (int i = 0; i < longitud; i++) {
            vectorRandom[i] = random.nextInt(max - min + 1) + min;
        }

        return vectorRandom;
    }

    public static void imprimirVector(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);

            //Esto sirve para imprimir una coma por cada numero generado.
            if (i < array.length - 1) {
                System.out.print(", ");
            }

            //Imprimiendo la lista de los datos en filas de 10.
            if ((i + 1) % 10 == 0) {
                System.out.println();
            }
        }

    }
}
