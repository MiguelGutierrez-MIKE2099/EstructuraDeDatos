package tarea3.utils;

import java.util.NoSuchElementException;
import java.util.Optional;
/**
 * Esta clase representa una implementación de lista enlazada individualmente.
 * @param <E> Tipo de elementos almacenados en la lista vinculada.
 */
public class ListaEnlazada<E> implements IListaEnlazada<E> {
    private Optional<Node<E>> root;
    private int size;

    /**
     * Construye una lista vinculada vacía.
     */
    public ListaEnlazada() {
        root = Optional.empty();
        size = 0;
    }
    /**
     * Recupera el elemento en el índice especificado en la lista vinculada.
     *
     * @param index El índice del elemento a recuperar.
     * @return Un Opcional que contiene el elemento en el índice dado, o un Opcional vacío si el índice está fuera de límites.
     * @lanza IndexOutOfBoundsException Si el índice es negativo o mayor o igual al tamaño de la lista.
     */
    @Override
    public Optional<E> get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        int currentIndex = 0;
        Optional<Node<E>> currentNode = root;

        while (currentIndex != index) {
            currentNode = currentNode.get().next;
            ++currentIndex;
        }

        return Optional.of(currentNode.get().data);
    }
    /**
     * Añade un elemento al final de la lista vinculada.
     *
     * @param e El elemento a agregar.
     */
    @Override
    public void add(E e) {
        Node<E> newNode = new Node<>(e);

        if (root.isEmpty()) {
            root = Optional.of(newNode);
        } else {
            Optional<Node<E>> currentNode = root;

            while (currentNode.get().next.isPresent()) {
                currentNode = currentNode.get().next;
            }

            currentNode.get().next = Optional.of(newNode);
        }

        increaseSize();
    }
    /**
     * Añade un elemento al principio de la lista vinculada.
     *
     * @param e El elemento a agregar.
     */
    public void addFirst(E e) {
        Node<E> newNode = new Node<>(e);

        if (root.isEmpty()) {
            root = Optional.of(newNode);
        } else {
            newNode.next = root;
            root = Optional.of(newNode);
        }

        increaseSize();
    }
    /**
     * Actualiza el valor de un elemento de la lista vinculada.
     *
     * @param oldValue El valor a actualizar.
     * @param newValue El nuevo valor para reemplazar el valor antiguo.
     * @lanza NoSuchElementException Si el valor anterior no se encuentra en la lista vinculada.
     */
    @Override
    public void update(E oldValue, E newValue) {
        Optional<Node<E>> currentNode = root;

        while (currentNode.isPresent() && !currentNode.get().data.equals(oldValue)) {
            currentNode = currentNode.get().next;
        }

        if (currentNode.isPresent()) {
            currentNode.get().data = newValue;
        } else {
            throw new NoSuchElementException();
        }
    }
    /**
     * Elimina un elemento de la lista vinculada.
     *
     * @param e El elemento a eliminar.
     * @lanza NoSuchElementException Si el elemento no se encuentra en la lista de enlaces.
     */
    @Override
    public void remove(E e) {
        if (root.isEmpty()) {
            throw new NoSuchElementException();
        }

        if (root.get().data.equals(e)) {
            root = root.get().next;
            decreaseSize();
            return;
        }

        Optional<Node<E>> currentNode = root;
        Optional<Node<E>> prevNode = Optional.empty();

        while (currentNode.isPresent()) {
            if (currentNode.get().data.equals(e)) {
                prevNode.get().next = currentNode.get().next;
                decreaseSize();
                return;
            }
            prevNode = currentNode;
            currentNode = currentNode.get().next;
        }

        throw new NoSuchElementException();
    }
    /**
     * Recupera el número de elementos de la lista vinculada.
     *
     * @return El número de elementos de la lista vinculada.
     */
    @Override
    public int getSize() {
        return size;
    }

    private void increaseSize() {
        ++size;
    }

    private void decreaseSize() {
        --size;
    }
    /**
     * Comprueba si la lista vinculada contiene un elemento específico.
     *
     * @param t El elemento a verificar.
     * @return True si el elemento se encuentra en la lista vinculada, de lo contrario false.
     */
    @Override
    public boolean contains(E t) {
        Optional<Node<E>> currentNode = root;

        while (!currentNode.get().data.equals(t) && currentNode.get().next.isPresent()) {
            currentNode = currentNode.get().next;
        }

        if (currentNode.get().data.equals(t)) {
            return true;
        }
        return false;
    }
}
