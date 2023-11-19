package tarea14.utils;

import tarea14.Grafos.Nodo;

/**
 * Implementación del árbol dde busqueda:
 *
 * @param <T> Tipo de valores almacenados en el árbol.
 */
public class ArbolBusquedaBinaria<T extends Comparable<T>> {
    Nodo<T> root;

    public ArbolBusquedaBinaria() {
        root = null;
    }

    /**
     * Inserta un nuevo valor en el arbol.
     *
     * @param value El valor a insertar.
     */
    public void add(T value) {
        root = addInSubTree(root, value);
    }

    private Nodo<T> addInSubTree(Nodo<T> root, T value) {
        if (root == null) {
            return new Nodo<>(value);
        }

        if (value.compareTo(root.value) < 0) {
            root.left = addInSubTree(root.left, value);
        } else if (value.compareTo(root.value) > 0) {
            root.right = addInSubTree(root.right, value);
        }

        return root;
    }

    /**
     * Eliminando un valor del arbol.
     *
     * @param value El valor que se procede a eliminar..
     */
    public void delete(T value) {
        root = deleteOnSubtree(root, value);
    }

    private Nodo<T> deleteOnSubtree(Nodo<T> root, T value) {
        if (root == null) {
            return root;
        }

        if (value.compareTo(root.value) < 0) {
            root.left = deleteOnSubtree(root.left, value);
        } else if (value.compareTo(root.value) > 0) {
            root.right = deleteOnSubtree(root.right, value);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            root.value = findMin(root.right);
            root.right = deleteOnSubtree(root.right, root.value);
        }

        return root;
    }

    /**
     * Realiza un recorrido en orden del árbol e imprime los valores.
     */
    public void inOrderTraversal() {
        inOrderTraversalRec(root);
        System.out.println();
    }

    private void inOrderTraversalRec(Nodo<T> root) {
        if (root != null) {
            inOrderTraversalRec(root.left);
            System.out.print(root.value + " ");
            inOrderTraversalRec(root.right);
        }
    }

    /**
     * Buscando un vaor dentro del arbol...
     *
     * @param value El valor a buscar.
     * @return Verdadero si se encuentra el valor; de lo contrario, falso.
     */
    public boolean search(T value) {
        return searchInSubtree(root, value);
    }

    private boolean searchInSubtree(Nodo<T> root, T value) {
        if (root == null) {
            return false;
        }

        if (root.value.equals(value)) {
            return true;
        }

        if (value.compareTo(root.value) < 0) {
            return searchInSubtree(root.left, value);
        } else {
            return searchInSubtree(root.right, value);
        }
    }

    private T findMin(Nodo<T> root) {
        T min = root.value;
        while (root.left != null) {
            min = root.left.value;
            root = root.left;
        }
        return min;
    }
}