/*
@author Miguel Gutierrez
 */

package tarea4.Ejercicio03.ui;

import tarea4.Ejercicio03.process.ServerSimulation;
import tarea4.utils.Cola;
import java.util.Optional;
import java.util.Random;
import java.util.Scanner;

/**
 * CLI contiene todos los datos que serán procesados por la clase Pasajeros.
 * CLI define los detalles del menú de usuario y lo ejecuta.
 */
public class CLI {
    /**
     * Datos utilizados por el paquete de procesos.
     */
    private static Cola<Integer> serverA = new Cola<>();
    private static Cola<Integer> serverB = new Cola<>();
    private static Scanner input = new Scanner(System.in);
    /**
     * Creación del menú de usuario.
     */
    private static Menu menu = new Menu();
    /**
     opciones de menú.
     */
    private static String SIMULATE_SERVERS = "Simular trabajo simultáneo de dos servidores.";
    /**
     * Otros textos útiles.
     */
    private static String RUN_PROCESS_SERVER_A = "Corriendo proceso del servidor A.\n";
    private static String RUN_PROCESS_SERVER_B = "Corriendo proceso del servidor B.\n";
    private static String NO_PROCESS_IN_SERVER = "¡Ya no hay más procesos a correr en el servidor!.\n";
    /**
     * Acciones del menú.
     */
    /**
     * Define la acción que simula el trabajo simultáneo de dos servidores en ejecución diferentes.
     */
    private static MenuActionPrototype simulateServers = () -> {
        int i;
        double probability;
        Random random = new Random();
        Optional<Integer> result;

        for(i = 0; i < ServerSimulation.getNumberOfProcesses(); ++i){
            ServerSimulation.loadServer(serverA, i);
            ServerSimulation.loadServer(serverB, i);
        }


        while(!serverA.isEmpty() || !serverB.isEmpty()){
            probability = random.nextDouble();
            if(probability <= 0.3){
                System.out.printf(RUN_PROCESS_SERVER_A);
            }
            else{
                System.out.printf(RUN_PROCESS_SERVER_B);
            }

            result = ServerSimulation.processProcess(serverA, serverB, probability);
            if(result != null){
                System.out.println(result.get());
            }
            else{
                System.out.printf(NO_PROCESS_IN_SERVER);
            }
        }
    };

    static {
        menu
                .addOption(SIMULATE_SERVERS, simulateServers)
                .addExitOption();
    }
    /**
     * Mostrar el menú y ejecutar las acciones asociadas a cada opción.
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
