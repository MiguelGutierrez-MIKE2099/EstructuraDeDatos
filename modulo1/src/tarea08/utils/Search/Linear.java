package tarea08.utils.Search;

import tarea08.utils.Sorting.Sorting;

public class Linear {

    public static int linearSearch(int[] arreglo, int elementoBuscado) {
        for (int i = 0; i < arreglo.length; i++) {
            ++Sorting.COMPARACIONES;
            if (arreglo[i] == elementoBuscado) {
                return i;
            }
        }
        return -1;
    }
}
