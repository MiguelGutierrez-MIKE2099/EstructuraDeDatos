package tarea13.proceso;

import java.util.Arrays;
public class Mediana {
    // Método para calcular la mediana de una lista de valores
    public double calculateMedian(double[] values) {
        // Verificar si la lista de valores está vacía
        if (values == null || values.length == 0) {
            throw new IllegalArgumentException("La lista de valores no puede estar vacía.");
        }

        // Clonar la lista y ordenarla
        double[] sortedValues = values.clone();
        Arrays.sort(sortedValues);

        // Obtener la longitud de la lista ordenada
        int length = sortedValues.length;

        // Calcular la mediana
        if (length % 2 == 0) {
            // Si la longitud es par, promediar los dos valores centrales
            int middleIndex1 = length / 2 - 1;
            int middleIndex2 = length / 2;
            return (sortedValues[middleIndex1] + sortedValues[middleIndex2]) / 2.0;
        } else {
            // Si la longitud es impar, devolver el valor central
            int middleIndex = length / 2;
            return sortedValues[middleIndex];
        }
    }
}
