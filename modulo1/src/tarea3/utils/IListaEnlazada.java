package tarea3.utils;
import java.util.Optional;

/**
 * Base interface for the implementation of linked lists
 * */
public interface IListaEnlazada {
    void add(E e);
    void remove(E e);
    Optional<E> get(int index);
    void update(E oldValue, E newValue);
    int getSize();
    boolean contains(E t);
}
