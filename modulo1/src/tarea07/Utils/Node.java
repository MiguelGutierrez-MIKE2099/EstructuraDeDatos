package tarea07.Utils;

import java.util.Optional;

public class Node <E>{
    E data;
    Optional<Node<E>> next;
    public Node(E data) {
        this.data = data;
        next = Optional.empty();
    }
}
