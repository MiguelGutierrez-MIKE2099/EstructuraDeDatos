package tarea11.utils;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Una implementación básica de un HashMap genérico.
 * @param <Key> El tipo de claves.
 * @param <Value> El tipo de valores.
 */
public class HashMap<Key, Value> {
    private static final int INITIAL_CAPACITY = 16;
    private ArrayList<LinkedList<Entry<Key, Value>>> buckets;
    private int size;

    /**
     * Aqui se construye un nuevo HashMap con la capacidad definida en un principio:
     */
    public HashMap() {
        buckets = new ArrayList<>(INITIAL_CAPACITY);
        for (int i = 0; i < INITIAL_CAPACITY; i++) {
            buckets.add(new LinkedList<>());
        }
        size = 0;
    }

    private int calculateIndex(Key key) {
        int hash = key.hashCode();
        return Math.abs(hash) % buckets.size();
    }

    /**
     * Asocia el valor especificado con la clave especificada en este mapa.
     * @param key La clave con la que se debe asociar el valor especificado.
     * @param value El valor que se asocia con la clave especificada.
     */
    public void add(Key key, Value value) {
        int index = calculateIndex(key);
        LinkedList<Entry<Key, Value>> bucket = buckets.get(index);

        for (Entry<Key, Value> entry : bucket) {
            if (entry.getKey().equals(key)) {
                entry.setValue(value);
                return;
            }
        }
        bucket.add(new Entry<>(key, value));
        size++;
    }

    /**
     * Devuelve el valor al que se asigna la clave que se especifica en este mapa,
     * o es nulo si el mapa no cuenta con asignación para la clave.
     * @param key La clave del valor asociado que va a devolver.
     * @return El valor asignado a la clave especificada,
     * o null si este mapa no contiene asignación para dicha clave.
     */
    public Value get(Key key) {
        int index = calculateIndex(key);
        LinkedList<Entry<Key, Value>> bucket = buckets.get(index);

        for (Entry<Key, Value> entry : bucket) {
            if (entry.getKey().equals(key)) {
                return entry.getValue();
            }
        }

        return null;
    }

    /**
     * Aqui se devuelve una lista de claves en el HashMap.
     * @return la lista de claves.
     */
    public ArrayList<Key> getKeys() {
        ArrayList<Key> outputValues = new ArrayList<>();

        for (LinkedList<Entry<Key, Value>> bucket : buckets) {
            for (Entry<Key, Value> entry : bucket) {
                outputValues.add(entry.getKey());
            }
        }

        return outputValues;
    }

    /**
     * Aqui se devuelve una lista de valores en el HashMap.
     * @return La lista de valores.
     */
    public ArrayList<Value> getValues() {
        ArrayList<Value> outputValues = new ArrayList<>();

        for (LinkedList<Entry<Key, Value>> bucket : buckets) {
            for (Entry<Key, Value> entry : bucket) {
                outputValues.add(entry.getValue());
            }
        }

        return outputValues;
    }

    /**
     * Devuelve valor verdadero si el mapa cuenta con asignación a la clave especificada.
     * @param key La clave que verifica.
     * @return Es verdadero si:El mapa contiene una asignación para la clave especificada,
     * es falso de tratarse de lo contrario.
     */
    public boolean containsKey(Key key) {
        int index = calculateIndex(key);
        LinkedList<Entry<Key, Value>> bucket = buckets.get(index);

        for (Entry<Key, Value> entry : bucket) {
            if (entry.getKey().equals(key)) {
                return true;
            }
        }

        return false;
    }

    /**
     * Aqui se elimina la asignación para la clave especificada de el mapa si está presente.
     * @param key La clave donde la asignación debe eliminarse del mapa.
     */
    public void remove(Key key) {
        int index = calculateIndex(key);
        LinkedList<Entry<Key, Value>> bucket = buckets.get(index);
        Entry<Key, Value> toRemove = null;

        for (Entry<Key, Value> entry : bucket) {
            if (entry.getKey().equals(key)) {
                toRemove = entry;
                break;
            }
        }
        if (toRemove != null) {
            bucket.remove(toRemove);
            size--;
        }
    }

    /**
     * Devuelve la cantidad de asignaciones de valor de clave para el mapa.
     * @return devuelve el número de asignaciones de valor de clave en el mapa.
     */
    public int size() {
        return size;
    }

    /**
     * Devuelve el estado del hashmap.
     * @devuelve si el hashmap está vacío o no.
     */
    public boolean isEmpty() {
        return (size() > 0) ? false : true;
    }

    /**
     * Eliminando las asignaciones del mapa.
     */
    public void clear() {
        for (LinkedList<Entry<Key, Value>> bucket : buckets) {
            bucket.clear();
        }
        size = 0;
    }
}