/**
 * @Author Miguel Gutierrez
 */

package tarea4.Ejercicio03.ui;

import tarea3.ui.MenuAccion;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Menu proporciona un conjunto de variables y miembros que describen una
 * plantilla de un menú de usuario.
 */
public class Menu {
    /**
     * Textos que pueden aparecer al interactuar con el menú.
     */
    private String BIENVENIDA = "Menú";
    private String SOLICITUD_OPCION = "Digite el número correspondiente a la opción a elegir:\n";
    private String ERROR_DATO = "El valor ingresado no es de tipo numérico. Intente de nuevo: ";
    private String FUERA_RANGO = "Opción no disponible. Intente de nuevo: ";
    private String FIN = "Programa finalizado.";

    /**
     * optionList almacena las cadenas que corresponden a las opciones mostradas al usuario + una opción de salida.
     * menuActionPrototypeList almacena las funciones asociadas a cada opción mostrada al usuario excepto la opción de salida.
     */
    private ArrayList<String> optionList = new ArrayList<>();
    private ArrayList<MenuAccion> menuAccionLista = new ArrayList<>();

    /**
     * alive establece el estado de disponibilidad del menú para el usuario y ayuda a determinar si el menú debe mantenerse mostrado o no.
     */
    private boolean alive = true;
    /**
     * killMenu establece que el menú del usuario debe dejar de mostrarse al usuario.
     */
    public void killMenu() {
        alive = false;
    }
    /**
     * isAlive determina el estado de disponibilidad del menú para el usuario.
     */
    public boolean isAlive() {
        return alive;
    }
    /**
     * addOption un menú de usuario dado las opciones que debe proporcionarles y las acciones asociadas a cada uno de ellos.
     * @param option: un texto que contiene una de las opciones del menú.
     * @param menuActionPrototype: el método que debe ejecutarse al seleccionar la opción asociada a él.
     * @devolver esto: el menú actual con sus correspondientes modificaciones.
     */
    public Menu addOption(String option, MenuAccion menuActionPrototype) {
        optionList.add(option);
        menuAccionLista.add(menuActionPrototype);
        return this;
    }
    /**
     * createMenu añade un método de salida al final del menú.
     */
    public void addExitOption() {
        optionList.add("Salir");
    }
    /**
     * cleanMenu elimina todas las opciones y acciones asociadas a ellos del menú.
     */
    public void clearMenu() {
        optionList.clear();
        menuAccionLista.clear();
    }
    /**
     showMenu muestra las opciones dentro del menú
     */
    public void showMenu() {
        System.out.println(BIENVENIDA);
        for (int i = 0; i < optionList.size(); i++) {
            System.out.println(i + 1 + ") " + optionList.get(i));
        }
    }

    public void requestOption(){
        System.out.print(SOLICITUD_OPCION);
    }
    /**
     * readOption lee la entrada del usuario y la valida en el formato adecuado.
     * @return opción: un número que representa el índice de una opción específica.
     */
    public int readOption() {
        Scanner input = new Scanner(System.in);
        while (true) {
            try {
                int option = input.nextInt();
                input.nextLine();
                if (option < 0 || option > optionList.size()) {
                    System.out.print(FUERA_RANGO);
                    continue;
                }
                else if(option == 0){
                    killMenu();
                    option = optionList.size();
                }
                return option;
            } catch (InputMismatchException e) {
                input.nextLine();
                System.out.print(ERROR_DATO);
            }
        }
    }
    /**
     * selectAndRunOption ejecuta la función asociada a la opción seleccionada por el usuario
     * @param opción: el número que representa el índice de la opción seleccionada por el usuario.
     */
    public void executeOption(int option) {
        if (option == optionList.size()) {
            killMenu();
            System.out.println(FIN);
            return;
        }
        menuAccionLista.get(option - 1).definedAction();
    }
}
