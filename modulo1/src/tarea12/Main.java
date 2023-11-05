package tarea12;

import tarea12.utils.ProcesosMatematicos.Factorial;
import tarea12.utils.ProcesosMatematicos.Fibonacci;
import tarea12.utils.Busquedas.BusquedaBinaria;
public class Main {
    public static void main(String[] args) {
        // Fibonacci.
        System.out.println(Fibonacci.getFibonacciOfRecursive(5));
        System.out.println(Fibonacci.getFibonacciOfIterative(5));

        // Factorial.
        System.out.println(Factorial.getFactorialOfRecursive(5));
        System.out.println(Factorial.getFactorialOfIterative(5));

        // Busqueda Binaria.
        int[] arr = new int[] {1, 2, 3, 4, 5};
        System.out.println(BusquedaBinaria.findElementRecursive(arr, 10, 0, arr.length - 1));
        System.out.println(BusquedaBinaria.findElementIterative(arr, 10));

    }
}