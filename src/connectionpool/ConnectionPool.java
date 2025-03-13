package connectionpool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;

/** ConnectionPool
 * Mantiene un listado de conexiones a la base de datos
 * Dispone de un método para poder obtener una nueva conexión
 * Todas las conexiones que se devuelven se almacenan en un Array
 * Existe un método que cierra todas las conexiones establecidas
 */
public class ConnectionPool {
    ArrayList<Connection> conns = new ArrayList<Connection>();
    private String url;
    private String user;
    private String password;

    /** ConnectionPool (Constructor)
     * Construye la instancia del Pool de Conexiones
     * 
     * @param url url de conexión a la base de datos Ej: jdbc:mysql://localhost:3306/<base_de_datos>
     * @param user Usuario con el que realizar la conexión
     * @param password Contraseña del usuario
     */
    public ConnectionPool(String url, String user, String password){
        //Almacenamos los datos de conexión
        this.url = url;
        this.user = user;
        this.password = password;
    }

    /** getConnection
     * Establece una conexión a la base de datos y la devuelve
     * @return Devuelve la conexión establecida
     */
    public Connection getConnection(){
        Connection _conn = null;
        try {
            //Fuerza a que el conector se cargue en memoria
            Class.forName("com.mysql.cj.jdbc.Driver");
            //Obtiene una conexión con los parámetros de conexión dados
            _conn = DriverManager.getConnection(this.url, this.user, this.password);
            //Si obtenemos conexión la añadimos en el array de conexiones
            if(_conn!=null)
                this.conns.add(_conn);    
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        //Devolvemos la conexión establecida si se ha podido establecer
        return _conn; //Puede ser null si no hay conexión establecida
    }

    /** closeAll
     * Cierra todas las conexiones establecidas que tenemos en el Array
     */
    public void closeAll(){
        //Cerramos una a una las conexiones establecidas
        for(Connection conn: this.conns){
            try {
                if(conn!=null)
                    conn.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        //Limpiamos el array de conexiones
        this.conns.clear();
    }
}
