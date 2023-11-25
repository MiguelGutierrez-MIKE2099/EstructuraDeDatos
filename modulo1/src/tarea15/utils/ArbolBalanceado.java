package tarea15.utils;

import tarea15.EstructuraDatos.Nodo;

import java.util.LinkedList;
import java.util.Queue;
public class ArbolBalanceado <T extends Comparable<T>>{
    private Nodo<T> root;

    /**
     * Construyendo un Arbol balanceado vacío:
     */
    public ArbolBalanceado() {
        this.root = null;
    }

    /**
     * Inserta un valor en el árbol.
     *
     * @param valor El valor a insertar.
     */
    public void insert(T valor) {
        System.out.println("***" + valor);
        if (root == null) {
            root = new Nodo<>(valor);
        } else {
            root = insert(root, valor);
        }
    }

    private Nodo<T> insert(Nodo<T> nodo, T valor) {
        System.out.println(valor);
        if (nodo == null) {
            return new Nodo<>(valor);
        }

        if (nodo.valor2 == null) {
            if (valor.compareTo(nodo.valor1) < 0) {
                nodo.valor2 = nodo.valor1;
                nodo.valor1 = valor;
            } else {
                nodo.valor2 = valor;
            }
        }

        else {
            if (valor.compareTo(nodo.valor1) < 0) {
                Nodo<T> newLeft = insert(nodo.izq, valor);
                return splitNode(newLeft, nodo.valor1, nodo, null);
            } else if (valor.compareTo(nodo.valor2) < 0) {
                Nodo<T> newMiddle = insert(nodo.centro, valor);
                return splitNode(nodo.izq, nodo.valor1, newMiddle, nodo.valor2);
            } else {
                Nodo<T> newRight = insert(nodo.der, valor);
                return splitNode(nodo, null, newRight, valor);
            }
        }

        return nodo;
    }

    private Nodo<T> splitNode(Nodo<T> left, T valor1, Nodo<T> middle, T valor2) {
        Nodo<T> newRoot = new Nodo<>(valor1);
        ((Nodo<T>) newRoot).izq = left;
        ((Nodo<T>) newRoot).centro = middle;
        ((Nodo<T>) newRoot).der = new Nodo<>(valor2);

        return newRoot;
    }

    /**
     * Busca un valor en el árbol.
     *
     * @param valor El valor a buscar.
     * @devuelve true si se encuentra el valor, false de lo contrario.
     */
    public boolean search(T valor) {
        return search(root, valor);
    }

    private boolean search(Nodo<T> nodo, T valor) {
        if (nodo == null) {
            return false;
        }

        if (nodo.valor1.equals(valor) || (nodo.valor2 != null && nodo.valor2.equals(valor))) {
            return true;
        }

        if (valor.compareTo(nodo.valor1) < 0) {
            return search(nodo.izq, valor);
        } else if (nodo.valor2 == null || valor.compareTo(nodo.valor2) < 0) {
            return search(nodo.centro, valor);
        } else {
            return search(nodo.der, valor);
        }
    }

    /**
     * Imprime los elementos del árbol en orden de nivel.
     */
    public void printLevelOrder() {
        if (root == null) {
            return;
        }

        Queue<Nodo<T>> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Nodo<T> tempNode = queue.poll();
            System.out.print(tempNode.valor1 + " ");
            if (tempNode.valor2 != null) {
                System.out.print(tempNode.valor2 + " ");
            }

            if (tempNode.izq != null) {
                queue.add(tempNode.izq);
            }

            if (tempNode.centro != null) {
                queue.add(tempNode.centro);
            }

            if (tempNode.der != null) {
                queue.add(tempNode.der);
            }
        }
    }
}
