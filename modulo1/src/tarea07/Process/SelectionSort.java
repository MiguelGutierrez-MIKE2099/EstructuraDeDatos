package tarea07.Process;

import tarea07.MOrdenamiento.Metricas;

public class SelectionSort {
    public static void selectionSort(int[] array, Metricas Versificacion) {

        //En este aso se requiere un par de ciclos anidados que sirvan para iterar en la lista de datos.
        for (int i = 0; i < array.length - 1; i++) {

            //Seguiremos el paso del valor min en las posiciones.

            int min = i;

            //El segundo ciclo funciona para leer los datos que aun no han sido leidos.
            for (int j = i + 1; j < array.length; j++) {
                //En este punto se agrega a la cola el dato leido.
                Versificacion.masComparativa();

                //Aquí establecemos un ciclo comparativo con el fin de identificar un elemento
                // que sea menor que el valor actualmente almacenado en la variable "min".
                // En caso de que el número contenido en la variable "j" sea menor que el valor de "min", "min" se actualizará con el valor de "j".
                if (array[min] > array[j]) {
                    min = j;
                }
            }

            //Realizar el cambio de posiciones entre arreglos.
            int tem = array[i];
            array[i] = array[min];
            array[min] = tem;
            //Realizar conteo de movimientos.
            Versificacion.masMovimientos();
        }

    }

}
