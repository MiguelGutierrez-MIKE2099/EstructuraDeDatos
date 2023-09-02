/**
 * @Author Miguel Gutierrez
 */
package tarea3.ui;

import tarea3.process.Notations;
import tarea3.utils.Pila;
import java.util.Scanner;
/**
 * CLI contiene todos los datos que serán procesados por la clase Pasajeros.
 * CLI define los detalles del menú de usuario y lo ejecuta.
 */
public class CLI {
    /**
     * Datos utilizados por el paquete de procesos.
     */

    /**
     * Creación del menú de usuario.
     */
    private static Menu menu = new Menu();
    /**
     opciones de menú.
     */
    private static String ENTRADA_SUFIJO = "Reescribir una expresión en notación infija a su equivalente en notación postfija.";
    /**
     * Otros textos útiles.
     */
    private static String ENTRADA_EXPRESION_INFIJA = "Ingrese una expresión matemática en notación infija:";
    private static String SALIDA_INFIJA = "La expresión matemática en notación infija ingresada es: %s\n";
    private static String SALIDA_SUFIJA = "La expresión equivalente en notación postfija es: %s\n";
    private static String ANS = "El resultado de evaluar la expresión dada es: %f\n";
    /**
     * Acciones del menú.
     */
    /**
     * Define la acción que añade los capitanes a una lista.
     */
    private static MenuAccion infixToPostfix = () -> {
        String strExpression;
        Pila<String> stackExpression;
        double ans;
        Scanner input = new Scanner(System.in);

        System.out.println(ENTRADA_EXPRESION_INFIJA);
        strExpression = input.next();
        System.out.printf(SALIDA_INFIJA, strExpression);
        stackExpression = Notations.strToStack(strExpression);

        strExpression = Notations.strInfixToPostfix(strExpression);
        stackExpression = Notations.stackInfixToPostfix(stackExpression);
        System.out.printf(SALIDA_SUFIJA, strExpression);

        ans = Notations.evaluatePostfixExpression(stackExpression);
        System.out.printf(ANS, ans);
    };
    /**
     * Añadir las opciones y acciones del menú.
     */
    static {
        menu
                .addOption(ENTRADA_SUFIJO, infixToPostfix)
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
