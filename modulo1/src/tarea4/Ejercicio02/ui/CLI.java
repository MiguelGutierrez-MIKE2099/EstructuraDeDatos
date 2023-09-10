/*
@author Miguel Gutierrez
 */

package tarea4.Ejercicio02.ui;

import tarea4.utils.Cola;

import java.util.Scanner;

/**
 * CLI contiene todos los datos que serán procesados por la clase Pasajeros.
 * CLI define los detalles del menú de usuario y lo ejecuta.
 */
public class CLI {
    /**
     * Datos utilizados por el paquete de procesos.
     */
    private static Cola<Integer> queue = new Cola<>();
    private static Scanner input = new Scanner(System.in);
    /**
     *  Menu.
     */
    private static String PUSH = "Agregar un nuevo elemento al final de la cola";
    private static String POP = "Eliminar el primer elemento de la cola";
    private static String PEEK = "Devolver el primer elemento de la cola";
    private static String SIZE = "Conocer el número de elementos almacenados en la cola";
    private static String IS_EMPTY = "Conocer si la cola está vacía";
    private static String INVERSE = "Invertir de posición de todos los elementos de la cola.";

    /**
     * Otros textos de utilidad.
     */
    private static String QUEUE_PUSH = "Ingrese el valor del elemento a agregar al final de la cola:";
    private static String QUEUE_PEEK = "El valor del elemento almacenado el principio de la cola es: %s\n";
    private static String QUEUE_SIZE = "El número de elementos almacenados en la cola es: %d\n";
    private static String QUEUE_IS_EMPTY = "La cola está vacía.\n";
    private static String QUEUE_IS_NOT_EMPTY = "La cola no está vacía.\n";

    /**
     * Define la acción que añade los capitanes a una lista.
     */
    private static MenuAccion queuePush = () -> {
        int newElmnt;

        System.out.println(QUEUE_PUSH);
        newElmnt = input.nextInt();

        queue.push(newElmnt);
    };

    private static MenuAccion queuePop = () -> {
        queue.pop();
    };

    private static MenuAccion queuePeek = () -> {
        System.out.printf(QUEUE_PEEK, queue.peek().get());
    };

    private static MenuAccion queueSize = () -> {
        System.out.printf(QUEUE_SIZE, queue.size());
    };

    private static MenuAccion queueIsEmpty = () -> {
        if(queue.isEmpty()){
            System.out.printf(QUEUE_IS_EMPTY);
        }
        else{
            System.out.printf(QUEUE_IS_NOT_EMPTY);
        }
    };

    private static MenuAccion queueInverse = () -> {
        queue = queue.inverse();
    };
    /**
     * Añadir las opciones y acciones del menú.
     */
    static {
        menu
                .addOption(PUSH, queuePush)
                .addOption(POP, queuePop)
                .addOption(PEEK, queuePeek)
                .addOption(SIZE, queueSize)
                .addOption(IS_EMPTY, queueIsEmpty)
                .addOption(INVERSE, queueInverse)
                .addExitOption();
    }
    /**
     * Mostrar el menú y ejecutar las acciones asociadas a cada opción.
     */
    public static void launchApp() {
        do {
            menu.showMenu();
            menu.requestOption();
            int option = menu.readOption();
            menu.executeOption(option);
        } while (menu.isAlive());
    }
}
