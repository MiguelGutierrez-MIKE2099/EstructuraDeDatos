package tarea09.utils;

import java.util.Set;
import java.util.HashSet;
import java.util.Optional;

/**
 * Representa un gráfico dirigido ponderado.
 *
 * @param <T> Tipo de datos almacenados en los nodos del gráfico.
 */
public class Graph<T> {
    private Set<GraphNode<T>> nodes;

    /**
     * Inicializa un gráfico vacío.
     */
    public Graph() {
        nodes = new HashSet<>();
    }

    /**
     * Añade un nodo al gráfico si no existe.
     *
     * @param newNode El nodo a agregar.
     */
    public void addNode(GraphNode<T> newNode) {
        if (newNode != null && !nodes.contains(newNode)) {
            nodes.add(newNode);
        }
    }

    /**
     * Añade un borde entre dos nodos con un peso asociado.
     *
     * @param from el nodo de origen.
     * @param to nodo de destino.
     * @param weight El peso del borde.
     */
    public void addEdge(GraphNode<T> from, GraphNode<T> to, int weight) {
        if (from != null && to != null) {
            from = getNode(from.getData());
            from.addEdge(to, weight);
            addNode(from);
            addNode(to);
        }
    }

    /**
     * Buscar metodos.
     */


    /**
     * Realice una búsqueda en profundidad (DFS) para determinar si hay una ruta desde el nodo de origen al nodo de destino.
     *
     * @param source El nodo de origen.
     * @param destination El nodo de destino.
     * @return True si hay una ruta, falsa de lo contrario.
     */
    public boolean isPathExistsDFS(GraphNode<T> source, GraphNode<T> destination) {
        System.out.println("Depht First Search");

        if (source == null || destination == null) {
            return false;
        }

        Set<GraphNode<T>> visited = new HashSet<>();
        Stack<GraphNode<T>> stack = new Stack<>();

        stack.push(source);
        visited.add(source);

        while (!stack.isEmpty()) {
            GraphNode<T> currentNode = stack.pop().get();
            System.out.println("Current node: \n" + currentNode);

            if (currentNode.equals(destination)) {
                return true;
            }

            for (GraphNode<T> neighbor : currentNode.getEdges().keySet()) {
                if (!visited.contains(neighbor)) {
                    stack.push(neighbor);
                    visited.add(neighbor);
                }
            }
        }

        return false;
    }

    /**
     * Realice una primera búsqueda (BFS) para determinar si hay una ruta desde el nodo de origen al nodo de destino.
     *
     * @param source El nodo de origen.
     * @param destination El nodo de destino.
     * @return True si hay una ruta, false de lo contrario.
     */
    public boolean isPathExistsBFS(GraphNode<T> source, GraphNode<T> destination) {
        System.out.println("Breadth-First Search");

        if (source == null || destination == null) {
            return false;
        }

        Set<GraphNode<T>> visited = new HashSet<>();
        Queue<GraphNode<T>> queue = new Queue<>();

        queue.push(source);
        visited.add(source);

        while (!queue.isEmpty()) {
            GraphNode<T> currentNode = queue.peek().get();
            System.out.println("Current node:\n" + currentNode);

            if (currentNode.equals(destination)) {
                return true;
            }

            for (GraphNode<T> neighbor : currentNode.getEdges().keySet()) {
                if (!visited.contains(neighbor)) {
                    queue.push(neighbor);
                    visited.add(neighbor);
                }
            }

            queue.pop();
        }

        return false;
    }

    /**
     * Recupera un nodo por su valor de datos.
     *
     * @param data El valor de datos del nodo deseado.
     * @return El nodo con el valor de datos especificado, o nulo si no se encuentra.
     */
    public GraphNode<T> getNode(T data) {
        Optional<GraphNode<T>> foundNode = nodes.stream()
                .filter(node -> data.equals(node.getData()))
                .findFirst();
        return foundNode.orElse(null);
    }

    /**
     * Obtiene el conjunto de nodos en el gráfico.
     *
     * @return The set of nodes.
     */
    public Set<GraphNode<T>> getNodes() {
        return nodes;
    }
}
