package tarea09.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Representa un nodo en un gráfico.
 *
 * @param <T> Tipo de datos almacenados en el nodo.
 */
public class GraphNode<T> {
    private T data;

    private Map<GraphNode<T>, Integer> edgeWeights;

    @Override
    public String toString() {
        String strOut = "Nodo: " + this.getData();

        for (Map.Entry<GraphNode<T>, Integer> entry : this.getEdges().entrySet()) {
            strOut += "\n\tVecino: " + entry.getKey().getData() + ", Peso: " + entry.getValue();
        }

        return strOut;
    }

    /**
     * Anula el método equals para comparar nodos según sus valores de datos.
     *
     * @param o El nodo con el que comparar.
     * @return True si los nodos tienen los mismos valores de datos, de lo contrario false.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GraphNode<?> node = (GraphNode<?>) o;
        return Objects.equals(data, node.data);
    }

    /**
     * Anula el método hashCode para generar un código hash basado en el valor de datos del nodo.
     *
     * @return El código hash calculado en función del valor de los datos.
     */
    @Override
    public int hashCode() {
        return Objects.hash(data);
    }

    /**
     * Construye un nuevo nodo con los datos especificados.
     *
     * @param data Los datos a almacenar en el nodo.
     */
    public GraphNode(T data) {
        setData(data);
        edgeWeights = new HashMap<>();
    }

    /**
     * Añade un nodo adyacente con un peso de borde asociado.
     *
     * @param adjacentNode El nodo vecino.
     * @param edgeWeight El peso del borde al nodo vecino.
     */
    public void addEdge(GraphNode<T> adjacentNode, int edgeWeight) {
        edgeWeights.put(adjacentNode, edgeWeight);
    }

    /**
     * Establece los datos del nodo.
     *
     * @param data Los datos a establecer para el nodo.
     */
    public void setData(T data) {
        this.data = data;
    }

    /**
     * Obtiene los datos almacenados en el nodo.
     *
     * @return Los datos almacenados en el nodo.
     */
    public T getData() {
        return data;
    }

    /**
     * Obtiene un mapa de los nodos vecinos y sus pesos de borde asociados.
     *
     * @return Un mapa de los nodos adyacentes y sus pesos de borde.
     */
    public Map<GraphNode<T>, Integer> getEdges() {
        return edgeWeights;
    }
}
