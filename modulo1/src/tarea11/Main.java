package tarea11;

import tarea11.utils.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMap<String, String> hm = new HashMap<>();

        hm.add("Clave 01", "Valor 'a'");
        hm.add("Clave 02", "Valor 'b'");
        hm.add("Clave 03", "Valor 'c'");
        hm.add("Clave 04", "Valor 'd'");

        System.out.println(hm.get("Clave 1"));
        System.out.println(hm.get("Clave 3"));
        System.out.println(hm.get("Esta clave no existe :( ..."));
    }
}
