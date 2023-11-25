package tarea15.EstructuraDatos;


public class Nodo<T> {

    /**
     * Valores almacenados en el nodo.
     */
    public T valor1;
    public T valor2;

    /**
     * Referencias a los nodos secundarios.
     */
    public Nodo<T> izq;
    public Nodo<T> centro;
    public Nodo<T> der;

    /**
     * Construye un nodo con un valor y sin hijos.
     *
     * @param valor1 El primer valor a almacenar en el nodo.
     */
    public Nodo(T valor1) {
        this.valor1 = valor1;
        this.valor2 = null;
        this.izq = this.centro = this.der = null;
    }

    /**
     * Construye un nodo con dos valores y sin hijos.
     *
     * @param valor1 El primer valor a almacenar en el nodo.
     * @param valor2 El segundo valor a almacenar en el nodo.
     */
    Nodo(T valor1, T valor2) {
        this.valor1 = valor1;
        this.valor2 = valor2;
        this.izq = this.centro = this.der = null;
    }
}
