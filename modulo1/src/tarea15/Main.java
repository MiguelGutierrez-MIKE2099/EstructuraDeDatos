package tarea15;

import tarea15.utils.ArbolBalanceado;

public class Main {
    public static void main(String[] args) {
        ArbolBalanceado<Integer> tree = new ArbolBalanceado<>();

        tree.insert(5);
        tree.insert(3);
        tree.insert(7);
        tree.insert(1);
        tree.insert(4);

        System.out.println("Tree after insertion:");
        tree.printLevelOrder();

        System.out.println("\nIs 4 present in the tree? " + tree.search(4));
        System.out.println("Is 6 present in the tree? " + tree.search(6));
    }
}
