package tarea14;

import tarea14.utils.ArbolBusquedaBinaria;

public class Main {
    public static void main(String[] args) {
        ArbolBusquedaBinaria<Integer> tree = new ArbolBusquedaBinaria<>();

        /**
         * Inserta los valores en el arbol:
         */
        tree.add(50);
        tree.add(30);
        tree.add(70);
        tree.add(20);
        tree.add(40);
        tree.add(60);
        tree.add(80);

        /**
         *Realice los valores de recorrido e impresión en orden
         */
        System.out.println("En orden transaversal:");
        tree.inOrderTraversal();

        /**
         * Busca el valor en el arbol...
         */
        int valorBuscado = 40;
        System.out.println("Es " + valorBuscado + " en el arbol? " + tree.search(valorBuscado));

        /**
         * Elimina el valor almacenado en el arbol:
         */
        int valueToDelete = 30;
        tree.delete(valueToDelete);

        /**
         * Realizar el recorrido en orden después de la eliminación...
         */
        System.out.println("En orden Traversal después de eliminar " + valueToDelete + ":");
        tree.inOrderTraversal();
    }
}