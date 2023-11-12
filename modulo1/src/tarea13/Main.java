package tarea13;

import tarea13.proceso.Mediana;

// Clase principal que inicia el programa
public class Main {
    public static void main(String[] args) {
        // Lista de valores para calcular la mediana
        double[] values = {5, 2, 8, 1, 7, 3, 6, 4};

        // Instanciar la clase MedianFinder
        Mediana finder = new Mediana();

        // Calcular y mostrar la mediana
        double median = finder.calculateMedian(values);
        System.out.println("La mediana es: " + median);
    }
}
