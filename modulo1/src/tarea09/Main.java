package tarea09;

import tarea09.utils.Graph;
import tarea09.utils.GraphNode;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        //Creating graph.
        Graph<String> graph = new Graph();

        //Agregar los nodos al gráfico.
        GraphNode<String> nodeA = new GraphNode<>("AAA");
        GraphNode<String> nodeB = new GraphNode<>("BBB");
        GraphNode<String> nodeC = new GraphNode<>("CCC");

        graph.addNode(nodeA);
        graph.addNode(nodeB);
        graph.addNode(nodeC);

        //Nodos gráficos de conexión.
        graph.addEdge(nodeA, nodeB, 10);
        graph.addEdge(nodeA, nodeC, 20);

        graph.addEdge(nodeB, nodeA, 30);
        graph.addEdge(nodeB, new GraphNode<String>("EEE"), 30);
        graph.addEdge(nodeB, new GraphNode<String>("EEE"), 40);

        //Mostrando nodos de gráfico.
        for (GraphNode<String> nodo : graph.getNodes()) {
            System.out.println(nodo);
        }

        //Realizar DFS.
        System.out.println("Los nodos AAA y CCC " + ((graph.isPathExistsDFS(nodeA, nodeC))? "sí" : "no") + " están conectados");
        System.out.println("Los nodos CCC y AAA " + ((graph.isPathExistsDFS(nodeC, nodeA))? "sí" : "no") + " están conectados");

        //Realizar BFS.
        System.out.println("Los nodos AAA y CCC " + ((graph.isPathExistsBFS(nodeA, nodeC))? "sí" : "no") + " están conectados");
        System.out.println("Los nodos CCC y AAA " + ((graph.isPathExistsBFS(nodeC, nodeA))? "sí" : "no") + " están conectados");
    }
}
