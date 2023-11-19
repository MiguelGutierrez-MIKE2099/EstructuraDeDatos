package tarea14.Grafos;

/**
 * Representa un nodo en un árbol de búsqueda binario.
 *
 * @param <T> Tipo de valores almacenados en el árbol.
 */
public class Nodo<T extends Comparable<T>> {
    public T value;
    public Nodo<T> left;
    public Nodo<T> right;

    public Nodo(T item) {
        value = item;
        left = right = null;
    }
}