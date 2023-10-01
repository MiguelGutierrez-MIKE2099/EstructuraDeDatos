package tarea07.Process;

import tarea07.MOrdenamiento.Metricas;

public class BubbleSort {
    public static void bubbleSort(int[] vector, Metricas Versificacion) {

        int n = vector.length;
        boolean invertido;

        do {
            invertido = false;

            for (int i = 1; i < n; i++) {
                Versificacion.masComparativa();

                //Esta condicion revisa si el elemento dado en el array es mayor al elemento que le consecute, si es así entonces tienen que cambiar de lugar.
                if (vector[i - 1] > vector[i]) {

                    //Realizando cambio de posiciones
                    int tem = vector[i - 1];
                    vector[i - 1] = vector[i];
                    vector[i] = tem;

                    Versificacion.masMovimientos();

                    //Confirmacion del exito en el cambio de lugar entre los elementos.
                    invertido = true;
                }
            }
            //En este punto se reduce la cantidad de cambios de lugar, ya que uno o más elementos se empiezan a acomodar en su lugar.
            n--;
        } while (invertido);

    }

}
