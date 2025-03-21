//TODO: Añadir imports
//...

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import connectionpool.ConnectionPool;
import individuos.Individuo;
import individuos.IndividuoService;

/** Personify
 * TODO: Implementa los métodos estáticos que se usan en la aplicación
 */
public interface Personify {
    //Escaner para solicitar datos
    static Scanner sc = new Scanner(System.in);
    //Usuario de la base de datos
    static String user = "javier";
    //Contraseña de la base de datos
    static String password = "javier123";
    //Pool de conexiones a la base de datos
    static ConnectionPool pool = new ConnectionPool("jdbc:mysql://localhost:3306/personify", user, password);
    //Servicio de acceso a la base de datos para los individuos
    static IndividuoService service = new IndividuoService(pool.getConnection());
    
    /** TODO: mostrarMenu
     * Muestra el menú en la consola
     */
    public static void mostrarMenu(){
        
    }
 
    /** TODO: leerOpcion
     * Obtiene una opción de menú desde teclado
     * @return devuelve el valor introducido
     */
    public static int leerOpcion(){
        System.out.print("Seleccione una opcion: ");
        int opcion = sc.nextInt();
        return opcion;
    }

    /** TODO: listarIndividuos
     * Lista los individuos de la base de datos
     */
    public static void listarIndividuos(){
        try {
            ArrayList<Individuo> individuos = service.requestAll("apellido1", "asc");
            System.out.println("******* Listado de individuos *********");
            System.out.println();

            // Vamos imprimiendo los individuos
            for (Individuo individuo : individuos) {
                System.out.println(individuo);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /** TODO: anadirIndividuo
     * Añade un individuo a la base de datos
     */
    public static void anadirIndividuo(){
        
    }

    /** TODO: listarDescendencia 
     * Lista la descendencia de un individuo
    */
    public static void listarDescendencia(){
        
    }

    /** TODO: listarAscendencia
     * Lista la ascendencia de un individuo6
     */
    public static void listarAscendencia(){
        
    }
    

    /** TODO: importarIndividuos
     * Importa los individuos desde un fichero de texto en la base de datos
     */
    public static void importarIndividuos(){
        
    }

    /** TODO: exportarIndividuos
     * Exporta los individuos de la base de datos a un fichero de texto
     */
    public static void exportarIndividuos(){
        
    }
    
}
