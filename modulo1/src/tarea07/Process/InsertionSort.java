package tarea07.Process;

import tarea07.MOrdenamiento.Metricas;
public class InsertionSort {
    public static void insertionSort(int[] vector, Metricas Versificacion) {

        for (int i = 1; i < vector.length; i++) {
            int tem = vector[i];

            // El indice comienza que compara el presente elemento.
            int j = i - 1;

            while (j >= 0 && vector[j] > tem) {
                //Agregar a la cuenta el valor comparado.
                Versificacion.masComparativa();

                // Se traslada el elemento al lado derecho.
                  vector[j + 1] = vector[j];
                j--;
            }

            // Trasladar el elemento a su posición correcta.
            vector[j + 1] = tem;
            Versificacion.masComparativa();
        }

    }
}
