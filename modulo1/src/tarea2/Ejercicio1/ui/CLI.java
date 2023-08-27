/**
 * @author Miguel Gutiérrez
 */
package tarea2.Ejercicio1.ui;

import tarea2.Ejercicio1.proccess.Pasajero;
import tarea2.utils.cList;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Esta clase maneja la información acerca de los pasajeros;
 * Define los detalles que usuario que se ejecutan en el menú.
 */

public class CLI {
   private static cList<Pasajero> pasajeros = new cList<>();

   /**
    * Menú de usuarios.
    */
   private static Menu menu = new Menu();

   /**
    *  Opciones del menú.
    */
   private static String AGREGAR_PASAJEROS = "Agregar pasajero.";
   private static String ELIMINAR_PASAJEROS = "Eliminar pasajero.";
   private static String OBTENER_PASAJERO_POR = "Visualizar información de un pasajero.";

   /**
    * Otras opciones.
    */
   private static String INGRESAR_DATOS = "Ingrese la información del pasajero a agregar;";
   private static String INGRESAR_DATOS_A_ELIMINAR = "Ingrese la información del pasajero a eliminar;";
   private static String INGRESAR_NOMBRE_DEL_PASAJERO = "Ingrese el nombre del pasajero:";
   private static String SI_EL_PASAJERO_YA_COMPRO_BOLETO = "¿El pasajero ya compró su ticket?\na) Sí.\nb) No.";
   private static String INGRESAR_NUMERO_DE_BOLETO = "Ingrese el número del ticket del pasajero:";
   private static String INGRESAR_INDICE_DE_PASAJERO = "Ingrese el índice del pasajero:";
   private static String ERROR_DE_TIPO_DE_DATO = "El valor ingresado no posee un formato numérico. Intente de nuevo: ";

   /**
    * Menú de acción.
    */
   /**
    * Definir la acción para agregar nuevos pasajeros.
    */
   private static MenuAccion agregar_pasajero = () -> {
      String nombrePasajero = new String();
      char boletoComprado = ' ';
      int numeroBoleto;
      Scanner input = new Scanner(System.in);

      System.out.println(INGRESAR_DATOS);

      System.out.println(INGRESAR_NOMBRE_DEL_PASAJERO);
      nombrePasajero = input.next();

      while(boletoComprado != 'a' && boletoComprado != 'b'){
         System.out.println(SI_EL_PASAJERO_YA_COMPRO_BOLETO);
         boletoComprado = input.next().charAt(0);
      }
      if(boletoComprado == 'a'){
         System.out.println(INGRESAR_NUMERO_DE_BOLETO);
         while (true) {
            try {
               numeroBoleto = input.nextInt();
               input.nextLine();
               break;
            } catch (InputMismatchException e) {
               input.nextLine();
               System.out.print(ERROR_DE_TIPO_DE_DATO);
            }
         }
         pasajeros.add(new Pasajero(nombrePasajero, numeroBoleto));
      }
      else if(boletoComprado == 'b'){
         pasajeros.add(new Pasajero(nombrePasajero));
      }
   };

   /**
    * Definir accion para eliminar pasajeros.
    */
   private static MenuAccion eliminar_usuario_por_boleto = () -> {
      try {
         String nombrePasajero = new String();
         char boletoComprado = ' ';
         int numeroBoleto;
         Scanner input = new Scanner(System.in);
         Pasajero p = null;

         System.out.println(INGRESAR_DATOS_A_ELIMINAR);

         System.out.println(INGRESAR_NOMBRE_DEL_PASAJERO);
         nombrePasajero = input.next();

         while (boletoComprado != 'a' && boletoComprado != 'b') {
            System.out.println(SI_EL_PASAJERO_YA_COMPRO_BOLETO);
            boletoComprado = input.next().charAt(0);
         }
         if (boletoComprado == 'a') {
            System.out.println(INGRESAR_NUMERO_DE_BOLETO);
            while (true) {
               try {
                  numeroBoleto = input.nextInt();
                  input.nextLine();
                  break;
               } catch (InputMismatchException e) {
                  input.nextLine();
                  System.out.print(ERROR_DE_TIPO_DE_DATO);
               }
            }
            p = new Pasajero(nombrePasajero, numeroBoleto);
         } else if (boletoComprado == 'b') {
            p = new Pasajero(nombrePasajero);
         }

         pasajeros.remove(p);
      }
      catch (NoSuchElementException e){
         System.out.println("Ha ocurrido un problema durante el procedimiento: " + e);
      }
   };

   /**
    * Definir la accion de nivel de dificultad durante el juego.
    */
   private static MenuAccion obtener_pasajero_por = () -> {
      try {
         int index;
         Scanner input = new Scanner(System.in);

         System.out.println(INGRESAR_INDICE_DE_PASAJERO);
         while (true) {
            try {
               index = input.nextInt();
               input.nextLine();
               break;
            } catch (InputMismatchException e) {
               input.nextLine();
               System.out.print(ERROR_DE_TIPO_DE_DATO);
            }
         }

         System.out.println(pasajeros.get(index));
      }
      catch (IndexOutOfBoundsException e){
         System.out.println("Ha ocurrido un problema durante el procedimiento:" + e);
      }
   };

   /**
    * Adding the menu options and actions.
    */
   static {
      menu
              .addOption(AGREGAR_PASAJEROS, agregar_pasajero)
              .addOption(ELIMINAR_PASAJEROS, eliminar_usuario_por_boleto)
              .addOption(OBTENER_PASAJERO_POR, obtener_pasajero_por)
              .addExitOption();
   }

   /**
    * Showing the menu and executing the actions associated to each option.
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
