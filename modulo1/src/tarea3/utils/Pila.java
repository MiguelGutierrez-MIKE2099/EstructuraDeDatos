package tarea3.utils;

import java.util.Optional;
/**
 * Una estructura de datos de pila genérica implementada utilizando una lista vinculada.
 * @param <E> el tipo de elementos contenidos en esta pila
 */
public class Pila <E>{
    private ListaEnlazada<E> stack;
    /**
     * Construye una pila vacía.
     */
    public Pila() {
        stack = new ListaEnlazada<>();
    }
    /**
     * Empuja un elemento en la parte superior de esta pila.
     * @param elmtToPush el elemento a ser empujado a esta pila
     */
    public void push(E elmtToPush) {
        stack.addFirst(elmtToPush);
    }
    /**
     * Recupera, pero no elimina, el elemento en la parte superior de esta pila.
     * @devuelve un Opcional que contiene el elemento en la parte superior de la pila, o un vacío Opcional si la pila está vacía
     */
    public Optional<E> peek() {
        return stack.get(0);
    }
    /**
     * Elimina y devuelve el elemento en la parte superior de esta pila.
     * @devuelve un Opcional que contiene el elemento eliminado de la parte superior de la pila, o un vacío Opcional si la pila está vacía
     */
    public Optional<E> pop() {
        Optional<E> popped = stack.get(0);
        stack.remove(popped.get());
        return popped;
    }
    /**
     * Devuelve el número de elementos de esta pila.
     * @devuelve el número de elementos en esta pila
     */
    public int getSize() {
        return stack.getSize();
    }
    /**
     * Comprueba si esta pila está vacía.
     * @devuelve true si la pila está vacía, false de lo contrario
     */
    public boolean isEmpty() {
        return !(stack.getSize() > 0);
    }
    /**
     * Devuelve una nueva pila con elementos en orden inverso en comparación con esta pila.
     * @devuelve una nueva pila con elementos en orden inverso
     */
    public Pila<E> inverse() {
        Pila<E> inversed = new Pila<>();

        for (int i = 0; i < stack.getSize(); ++i) {
            inversed.push(stack.get(i).get());
        }

        return inversed;
    }
    /**
     * Devuelve una pila nueva con elementos alternados entre esta pila y otra pila.
     * @param stackB la otra pila para alternar elementos con
     * @devuelve una nueva pila con elementos alternados
     */
    public Pila<E> alternate(Pila<E> stackB) {
        Pila<E> alternated = new Pila<>();

        for (int i = 0; i < Math.max(stack.getSize(), stackB.getSize()); ++i) {
            try {
                alternated.push(stackB.stack.get(stack.getSize() - i - 1).get());
            } catch (IndexOutOfBoundsException e) {
            }
            try {
                alternated.push(stack.get(stack.getSize() - i - 1).get());
            } catch (IndexOutOfBoundsException e) {
            }
        }

        return alternated;
    }
}
