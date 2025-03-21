package individuos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
        // Valor de retorno
        ArrayList<Individuo> individuos = new ArrayList<>();
        String sql = "select * from individuos where " + column + " = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, value);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            // Añadimos cada individuo recuperado a la lista
            individuos.add(mapResultSetToIndividuo(rs));
        }
        return individuos;
    }

    @Override
    public ArrayList<Individuo> query(String column, long value) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'query'");
    }

    @Override
    public ArrayList<Individuo> requestAll(String sortedBy, String direction) throws SQLException {
        // Valor de retorno
        ArrayList<Individuo> individuos = new ArrayList<>();
        String sql = "select * from individuos order by " + sortedBy + " " + direction;
        
        // Preparamos la query en forma de Prepared Statement (precompilada)
        PreparedStatement ps = conn.prepareStatement(sql);

        // Ejecutamos la query
        ResultSet rs = ps.executeQuery();
        
        // Recorremos el conjunto de resultados de la query (ResultSet) y asignamos los valores de las columnas
        // a un individuo en cada iteración
        while(rs.next()){
            // Añadimos cada individuo recuperado a la lista
            individuos.add(mapResultSetToIndividuo(rs));
        }
        
        return individuos;
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
    
    private Individuo mapResultSetToIndividuo(ResultSet rs) throws SQLException {
        // Valor de retorno
        Individuo individuo = new Individuo();
        
        individuo.setId(rs.getInt("id"));
        individuo.setNombre(rs.getString("nombre"));
        individuo.setApellido1(rs.getString("apellido1"));
        individuo.setApellido2(rs.getString("apellido2"));
        individuo.setProgenitor1(rs.getInt("progenitor1"));
        individuo.setProgenitor2(rs.getInt("progenitor2"));
        
        return individuo;
    }
}
