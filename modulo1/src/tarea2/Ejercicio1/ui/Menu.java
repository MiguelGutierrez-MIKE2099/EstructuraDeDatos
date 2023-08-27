package tarea2.Ejercicio1.ui;

import tarea2.Ejercicio1.ui.MenuAccion;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Menu {
    private String BIENVENIDA = "Menú";
    private String OPCION_SOLICITUD = "Digite el número correspondiente a la opción a elegir: ";
    private String ERROR_DE_TIPO_DE_DATO = "El valor ingresado no posee un formato numérico. Intente de nuevo: ";
    private String FUERA_DE_RANGO = "Opción no disponible. Intente de nuevo: ";
    private String FIN_DEL_PROGRAMA = "Programa finalizado.";

    /**
     * Opciones disponibles para elección del usuario.
     */
    private ArrayList<String> optionList = new ArrayList<>();
    private ArrayList<MenuAccion> menuActionPrototypeList = new ArrayList<>();

    /**
     *  establece el estado de disponibilidad del menú para el usuario y ayuda a determinar si el menú debe mantenerse mostrado o no.
     */
    private boolean alive = true;

    /**
     * Deja de mostrar el menú.
     */
    public void killMenu() {
        alive = false;
    }

    /**
     * Determinar la disponibilidad para mostrar el menú al usuario.
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
    public Menu addOption(String option, MenuAccion menuActionPrototype) {
        optionList.add(option);
        menuActionPrototypeList.add(menuAccion);
        return this;
    }

    /**
     * Metodo para abandonar menu.
     */
    public void addExitOption() {
        optionList.add("Salir");
    }

    /**
     * cleanMenu metodo para limpiar el menu.
     */
    public void clearMenu() {
        optionList.clear();
        menuActionPrototypeList.clear();
    }

    /**
     * showMenu muestra las opciones dentro del menu.
     */
    public void showMenu() {
        System.out.println(BIENVENIDA);
        for (int i = 0; i < optionList.size(); i++) {
            System.out.println(i + 1 + ") " + optionList.get(i));
        }
    }

    public void requestOption(){
        System.out.print(OPCION_SOLICITUD);
    }

    /**
     * readOption lee la entrada del usuario y valida que fue dada en un formato apropiado.
     * @return opción: un número que representa el índice de una opción específica.
     */
    public int readOption() {
        Scanner input = new Scanner(System.in);
        while (true) {
            try {
                int option = input.nextInt();
                input.nextLine();
                if (option < 0 || option > optionList.size()) {
                    System.out.print(FUERA_DE_RANGO);
                    continue;
                }
                else if(option == 0){
                    killMenu();
                    option = optionList.size();
                }
                return option;
            } catch (InputMismatchException e) {
                input.nextLine();
                System.out.print(ERROR_DE_TIPO_DE_DATO);
            }
        }
    }

    /**
     * selectAndRunOption executes the function associated to the option selected by the user
     * @param option: the number that represents the index of the option selected by the user.
     */
    public void executeOption(int option) {
        if (option == optionList.size()) {
            killMenu();
            System.out.println(FIN_DEL_PROGRAMA);
            return;
        }
        menuActionPrototypeList.get(option - 1).definedAction();
    }
}
