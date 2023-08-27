package tarea2.Ejercicio2.ui;

import tarea2.Ejercicio2.proccess.JugadorFutbol;
import tarea2.util.cList;
import java.util.*;
public class CLI {
    private static cList<JugadorFutbol> capitan = new cList<>();
    private static cList<JugadorFutbol> jugadorFutbol = new cList<>();
    private static LinkedList<cList<JugadorFutbol>> equipos = new LinkedList<>();

    /**
     * Generacion del menu de usuario.
     */
    private static Menu menu = new Menu();

    /**
     *  Opciones del menú.
     */
    private static String AGREGAR_CAPITAN = "Agregar capitanes.";
    private static String AGREGAR_JUGADORES = "Agregar jugadores.";
    private static String HACER_EQUIPOS = "Hacer equipos.";
    private static String MOSTRAR_EQUIPOS = "Mostrar equipos.";

    /**
     * Otras funcionalidades.
     */
    private static String INFORMACION_CAPITANES = "Ingrese la información de los capitanes:";
    private static String AGREGAR_CAPITANES = "¿Qué desea hacer?\na) Agregar un nuevo capitan.\nb) Terminar de agregar capitanes:";
    private static String INGRESAR_DATOS_CAPITAN = "Ingrese la información del capitán a agregar:";
    private static String INGRESAR_NOMBRE_DE_CAPITAN = "Ingrese el nombre del capitan:";
    private static String INGRESAR_NUMERO_DE_CAPITAN = "Ingrese el número de la camisa del capitan:";
    private static String INFORMACION_DE_JUGADOR = "Ingrese la información de los jugadores:";
    private static String AGREGAR_JUGARDOR = "¿Qué desea hacer?\na) Agregar un nuevo jugador.\nb) Terminar de agregar jugadores:";
    private static String INGRESAR_DATOS_JUGADORES = "Ingrese la información del jugador a agregar:";
    private static String INGRESAR_NOMBRE_JUGADOR = "Ingrese el nombre del jugador:";
    private static String INGRESAR_NUMERO_JUGADOR = "Ingrese el número de la camisa del jugador:";
    private static String INGRESAR_EQUIPO = "Haga al equipo %d:\n";
    private static String INGRESAR_EQUIPO_CAPITAN = "Indique el índice del capitan del equipo %d:\n";
    private static String INGRESAR_EQUIPO_JUGADOR = "Indique el índice del jugador del equipo %d:\n";
    private static String ERROR_DE_JUGADOR = "El jugador ingresado ya está en otro equipo. Intente de nuevo.";
    private static String ERROR_NUMERICO = "El valor ingresado no posee un formato numérico. Intente de nuevo: ";

    /**
     * Menu de acciones.
     */
    /**
     * Definir acciones para agregar capitanes a la lista.
     */
    private static MenuAccion agregar_capitan = () -> {
        while(true) {
            char option = ' ';
            String nombreCapitan = " ";
            int numeroCapitan = -1;
            Scanner input = new Scanner(System.in);

            System.out.println(INFORMACION_CAPITANES);
            while (option != 'a' && option != 'b') {
                System.out.println(AGREGAR_CAPITAN);
                option = input.next().charAt(0);
            }

            if (option == 'a') {
                System.out.println(INGRESAR_DATOS_CAPITAN);
                System.out.println(INGRESAR_NOMBRE_DE_CAPITAN);
                nombreCapitan = input.next();

                System.out.println(INGRESAR_NUMERO_DE_CAPITAN);
                while (true) {
                    try {
                        numeroCapitan = input.nextInt();
                        input.nextLine();
                        break;
                    } catch (InputMismatchException e) {
                        input.nextLine();
                        System.out.print(ERROR_NUMERICO);
                    }
                }

                capitan.add(new JugadorFutbol(nombreCapitan, numeroCapitan, true));
            } else {
                break;
            }
        }
    };

    /**
     * Definir acciones para ingresar jugadores a la lista.
     */
    private static MenuAccion agregar_jugadores = () -> {
        while(true) {
            char option = ' ';
            String nombreJugador = " ";
            int numeroJugador = -1;
            Scanner input = new Scanner(System.in);

            System.out.println(INFORMACION_DE_JUGADOR);
            while (option != 'a' && option != 'b') {
                System.out.println(AGREGAR_JUGADORES);
                option = input.next().charAt(0);
            }

            if (option == 'a') {
                System.out.println(AGREGAR_JUGADORES);
                System.out.println(INGRESAR_NOMBRE_JUGADOR);
                playerName = input.next();
                System.out.println(INGRESAR_NUMERO_JUGADOR);
                numeroJugador = input.nextInt();

                jugadorFutbol.add(new JugadorFutbol(nombreJugador, numeroJugador, false));
            } else {
                break;
            }
        }
    };

    /**
     * Definir acciones para hacer equipos.
     */
    private static MenuAccion hacer_equipos = () -> {
        int index;
        char option = ' ';
        Scanner input = new Scanner(System.in);

        for(int i = 0; i < capitan.size(); ++i){
            System.out.printf(INGRESAR_EQUIPO, i);
            equipos.add(new cList<>());

            //Adding capitain.
            while(true) {
                try {
                    System.out.printf(AGREGAR_CAPITAN, i);
                    while (true) {
                        try {
                            index = input.nextInt();
                            input.nextLine();
                            break;
                        } catch (InputMismatchException e) {
                            input.nextLine();
                            System.out.print(ERROR_NUMERICO);
                        }
                    }

                    JugadorFutbol soccerCapitain = capitan.get(index).get();
                    if (!soccerCapitain.obtEquipo();) {
                        soccerCapitain.obtEquipo(true);

                        equipos.get(i).add(soccerCapitain);
                        break;
                    } else {
                        System.out.println(ERROR_NUMERICO);
                    }

                } catch (IndexOutOfBoundsException e) {
                    System.out.println("Ha ocurrido un problema al ejecutar el procedimiento: " + e);
                }
            }

            //Agregar jugadores.
            while(true){
                while (option != 'a' && option != 'b') {
                    System.out.println(AGREGAR_JUGADORES);
                    option = input.next().charAt(0);
                }
                if (option == 'a') {
                    try {
                        System.out.printf(INGRESAR_EQUIPO, i);
                        while (true) {
                            try {
                                index = input.nextInt();
                                input.nextLine();
                                break;
                            } catch (InputMismatchException e) {
                                input.nextLine();
                                System.out.print(ERROR_NUMERICO);
                            }
                        }

                        JugadorFutbol soccerPlayer = jugadorFutbol.get(index).get();
                        if (!soccerPlayer.obtEsCapitan()) {
                            soccerPlayer.obtEquipo(true);
                            equipos.get(i).add(jugadorFutbol);
                            option = ' ';
                        } else {
                            System.out.println(ERROR_NUMERICO);
                        }
                    }
                    catch (IndexOutOfBoundsException e){
                        System.out.println("Ha ocurrido un problema al ejecutar el procedimiento: " + e);
                    }
                } else {
                    break;
                }
            }
        }
    };

    private static MenuAccion mostrarEquipos = () -> {
        for (int i = 0; i < equipos.size(); ++i) {
            System.out.println("Equipo " + i);
            for (int j = 0; j < equipos.get(i).size(); j++) {
                Optional<JugadorFutbol> sc = jugadorFutbol.get(i).get(j);
                System.out.println(sc);
            }
        }
    };

    /**
     * Agregar opciones de menu.
     */
    static {
        menu
                .addOption(AGREGAR_CAPITAN, agregar_capitan)
                .addOption(AGREGAR_JUGADORES, agregar_jugadores)
                .addOption(HACER_EQUIPOS, hacer_equipos)
                .addOption(MOSTRAR_EQUIPOS, mostrarEquipos)
                .addExitOption();
    }

    /**
     * Mostrar menu y sus opciones relacionadas.
     */
    public static void launchApp() {
        do {
            menu.showMenu();
            menu.requestOption();
            int option = menu.readOption();
            menu.executeOption(option);
        } while (menu.isAlive());
    }
}
