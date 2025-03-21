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

        // Código SQL de la consulta
        String sql = "SELECT * FROM individuos WHERE " + column + " = ?";

        // Precompila el PreparedStatement
        PreparedStatement stmt = conn.prepareStatement(sql);

        // Asigna argumentos de la query
        stmt.setString(1, value);

        // Ejecuta la query
        ResultSet rs = stmt.executeQuery();

        // Recorro los resultados de la query y relleno la lista a devolver
        while(rs.next()){
            individuos.add(mapResultSetToIndividuo(rs));
        }

        return individuos;
    }

    @Override
    public ArrayList<Individuo> query(String column, long value) throws SQLException {
        // Valor de retorno
        ArrayList<Individuo> individuos = new ArrayList<>();

        // Código SQL de la consulta
        String sql = "SELECT * FROM individuos WHERE " + column + " = ?";

        // Precompila el PreparedStatement
        PreparedStatement stmt = conn.prepareStatement(sql);

        // Asigna argumentos de la query
        stmt.setLong(1, value);

        // Ejecuta la query
        ResultSet rs = stmt.executeQuery();

        // Recorro los resultados de la query y relleno la lista a devolver
        while(rs.next()){
            individuos.add(mapResultSetToIndividuo(rs));
        }

        return individuos;
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
        // Valor de retorno
        return this.query("id", id).get(0);

// FORMA ALTERNATIVA REPLICANDO CÓDIGO:
//////////////////////////////////////////
//        Individuo individuo = null;
//
//        // Código SQL de la consulta
//        String sql = "SELECT * FROM individuos WHERE id = ?";
//
//        // Precompila el PreparedStatement
//        PreparedStatement stmt = conn.prepareStatement(sql);
//
//        // Asigna argumentos de la query
//        stmt.setLong(1, id);
//
//        // Ejecuta la query
//        ResultSet rs = stmt.executeQuery();
//
//        // Recorro los resultados de la query y relleno la lista a devolver
//        if (rs.next()) {
//            individuo = mapResultSetToIndividuo(rs);
//        }
//
//        return individuo;
    }

    @Override
    public long createOrUpdate(Individuo model) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createOrUpdate'");
    }

    @Override
    public long create(Individuo individuo) throws SQLException {
        // Valor de retorno
        Long newPk = -1l;
        // Código SQL de la query
        String sql = "INSERT INTO individuos VALUES(?,?,?,?,?,?)";

        // Precompila
        PreparedStatement stmt = conn.prepareStatement(sql);

        // Asigna parámetros
        stmt.setString(1, individuo.getNombre());
        stmt.setString(2, individuo.getApellido1());
        stmt.setString(3, individuo.getApellido2());
        stmt.setLong(4, individuo.getProgenitor1());
        stmt.setLong(5, individuo.getProgenitor2());

        // Ejecutamos la operación de escritura
        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();

        // Recuperamos la clave primaria generada.
        if (rs.next()) {
            newPk = rs.getLong(1);
        }

        return newPk;
    }

    @Override
    public int update(Individuo individuo) throws SQLException {
        // Código SQL de la query
        String sql = "UPDATE individuos SET nombre = ?, apellido1 = ?, apellido2 = ?, progenitor1 = ?, progenitor2 = ? WHERE id = ?";

        // Precompila
        PreparedStatement stmt = conn.prepareStatement(sql);

        // Asigna parámetros
        stmt.setString(1, individuo.getNombre());
        stmt.setString(2, individuo.getApellido1());
        stmt.setString(3, individuo.getApellido2());
        stmt.setLong(4, individuo.getProgenitor1());
        stmt.setLong(5, individuo.getProgenitor2());

        // Ejecutamos la operación de escritura y devuelve el número de tuplas modificadas
        return stmt.executeUpdate();
    }

    @Override
    public boolean delete(long id) throws SQLException {
        // Código SQL de la query
        String sql = "DELETE FROM individuos WHERE id = ?";

        // Precompila
        PreparedStatement stmt = conn.prepareStatement(sql);

        // Asigna valores
        stmt.setLong(1, id);

        return stmt.executeUpdate() > 0;
    }
    
    private Individuo mapResultSetToIndividuo(ResultSet rs) throws SQLException {
        // Valor de retorno
        Individuo individuo = new Individuo();
        
        individuo.setId(rs.getLong("id"));
        individuo.setNombre(rs.getString("nombre"));
        individuo.setApellido1(rs.getString("apellido1"));
        individuo.setApellido2(rs.getString("apellido2"));
        individuo.setProgenitor1(rs.getLong("progenitor1"));
        individuo.setProgenitor2(rs.getLong("progenitor2"));
        
        return individuo;
    }
}
