package tarea2.Ejercicio2.ui;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    /**
     * Texto mostrado sobre el menu.
     */
    private String BIENVENIDO = "Menú";
    private String SOLICITUD_OPCION = "Digite el número correspondiente a la opción a elegir: ";
    private String ERROR_NUMERICO = "El valor ingresado no posee un formato numérico. Intente de nuevo: ";
    private String FUER_DE_RANGO = "Opción no disponible. Intente de nuevo: ";
    private String FIN_PROGRAMA = "Programa finalizado.";

    /**
     optionList almacena las cadenas que corresponden a las opciones mostradas al usuario + una opción de salida.
     * menuActionPrototypeList almacena las funciones asociadas a cada opción mostrada al usuario excepto la opción de salida.
     */
    private ArrayList<String> optionList = new ArrayList<>();
    private ArrayList<MenuAccion> menuActionPrototypeList = new ArrayList<>();

    /**
     establece el estado de disponibilidad del menú para el usuario y ayuda a determinar si el menú debe mantenerse mostrado o no.     */
    private boolean alive = true;

    /**
     killMenu establece que el menú del usuario debe dejar de mostrarse al usuario.     */
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
     * @param opción: un texto que contiene una de las opciones del menú.
     * @param menuActionPrototype: el método que debe ejecutarse al seleccionar la opción asociada a él.
     * @devolver esto: el menú actual con sus correspondientes modificaciones.
     */
    public Menu addOption(String option, MenuAccion menuAccion) {
        optionList.add(option);
        menuActionPrototypeList.add(menuAccion);
        return this;
    }

    /**
     createMenu añade un método de salida al final del menú.     */
    public void addExitOption() {
        optionList.add("Salir");
    }

    /**
     * cleanMenu elimina todas las opciones y acciones asociadas a ellos del menú.
     */
    public void clearMenu() {
        optionList.clear();
        menuActionPrototypeList.clear();
    }

    /**
     showMenu muestra las opciones dentro del menú
     */
    public void showMenu() {
        System.out.println(BIENVENIDO);
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
                    System.out.print(FUER_DE_RANGO);
                    continue;
                }
                else if(option == 0){
                    killMenu();
                    option = optionList.size();
                }
                return option;
            } catch (InputMismatchException e) {
                input.nextLine();
                System.out.print(ERROR_NUMERICO);
            }
        }
    }

    /**
     * selectAndRunOption ejecuta la función asociada a la opción seleccionada por el usuario
     * @param option: el número que representa el índice de la opción seleccionada por el usuario.
     */
    public void executeOption(int option) {
        if (option == optionList.size()) {
            killMenu();
            System.out.println(FIN_PROGRAMA);
            return;
        }
        menuActionPrototypeList.get(option - 1).definedAction();
    }
}
