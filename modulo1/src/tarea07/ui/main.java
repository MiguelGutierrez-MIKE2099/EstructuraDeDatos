package tarea07.ui;

import tarea07.MOrdenamiento.Metricas;
import tarea07.Process.BubbleSort;
import tarea07.Process.InsertionSort;
import tarea07.Process.SelectionSort;
import tarea07.Utils.Vectores;

public class main {
    public static void main(String[] args) {

        int[] vectorRandom = Vectores.vectorRandom(200, 1, 500);

        System.out.println("Presentando arreglo en su estado original: ");
        Vectores.imprimirVector(vectorRandom);

        Metricas MetricaBubbleSort = new Metricas();
        BubbleSort.bubbleSort(vectorRandom.clone(), MetricaBubbleSort);
        System.out.println("\nRealizando comparativa del Sorteo de Burbuja: " + MetricaBubbleSort.getComparativa());
        System.out.println("Total de movimientos en este sorteo: " + MetricaBubbleSort.getMovimientos());

        Metricas MetricaSelectionSort = new Metricas();
        SelectionSort.selectionSort(vectorRandom.clone(), MetricaSelectionSort);
        System.out.println("\nRealizando comparativa del sorteo de seleccion: " + MetricaSelectionSort.getComparativa());
        System.out.println("Total de movimientos en este sorteo:" + MetricaSelectionSort.getMovimientos());

        Metricas MetricasInsertionSort = new Metricas();
        InsertionSort.insertionSort(vectorRandom.clone(), MetricasInsertionSort);
        System.out.println("\nRealizando comparativa del sorteo de insercion: " + MetricasInsertionSort.getComparativa());
        System.out.println("Total de movimientos en este sorteo: " + MetricasInsertionSort.getMovimientos());

        System.out.println("\nArreglo final ordenado correctamente.");
        Vectores.imprimirVector(vectorRandom);
    }
}
