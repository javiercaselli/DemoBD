package individuos;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import crud.CRUD;
/** IndividuoService
 * Clase que implementa la interfaz CRUD para la tabla Individuo
 * Funciona como un servicio de acceso a datos para el model Individuo
 */
public class IndividuoService implements CRUD<Individuo>{
    // Conexión activa con la base de datos
    private Connection conn = null;

    //TODO: Implementar métodos CRUD

    
    /** IndividuoService (Constructor)
     * Constructor que crea la instancia del servicio y
     * almacena la conexión a la base de datos 
     * @param conn Conexión con la base de datos
     */
    public IndividuoService(Connection conn){
        this.conn = conn;
    }

    @Override
    public ArrayList<Individuo> query(String column, String value) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'query'");
    }

    @Override
    public ArrayList<Individuo> query(String column, long value) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'query'");
    }

    @Override
    public ArrayList<Individuo> requestAll(String sortedBy, String direction) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'requestAll'");
    }

    @Override
    public Individuo requestById(long id) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'requestById'");
    }

    @Override
    public long createOrUpdate(Individuo model) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createOrUpdate'");
    }

    @Override
    public long create(Individuo model) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public int update(Individuo object) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public boolean delete(long id) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }
}
