

/** App
 * Programa que gestiona individuos.
 */
public class App implements Personify{
    public static void main(String[] args) throws Exception {
        int opcion = -1;
        do {
            Personify.mostrarMenu();
            opcion = Personify.leerOpcion();
            switch (opcion) {
                case 1:
                    Personify.listarIndividuos();
                    break;
                case 2:
                    Personify.listarDescendencia();
                    break;
                case 3:
                    Personify.listarAscendencia();
                    break;
                case 4:
                    Personify.anadirIndividuo();
                    break;
                case 5:
                    Personify.importarIndividuos();
                    break;
                case 6:
                    Personify.exportarIndividuos();
                    break;
                case 7:
                    break;
                default:
                    System.out.println("Opcion incorrecta");
                    break;
            }
        } while (opcion!=7);
    }
}
