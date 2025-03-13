package crud;

import java.sql.SQLException;
import java.util.ArrayList;

/** CRUD
 * Interfaz que contiene los métodos necesarios para
 * obtener y modificar información de Jugadores en la base de datos
 */
public interface CRUD<T> {

    /** query
     * Realiza una consulta filtrando por la columna cuyo valor coincida con el
     * suministrado
     * @param column Columna por la que filtrar
     * @param value Valor de la columna para filtrar
     * @return Devuelve una lista con los registros encontrados
     * @throws SQLException
     */
    public ArrayList<T> query(String column, String value) throws SQLException;

    /** query
     * Realiza una consulta filtrando por la columna cuyo valor coincida con el
     * suministrado
     * @param column Columna por la que filtrar
     * @param value Valor de la columna para filtrar
     * @return Devuelve una lista con los registros encontrados
     * @throws SQLException
     */
    public ArrayList<T> query(String column, long value) throws SQLException;

    /** requestAll
     * Obtiene todos los registros de un modelo de la 
     * base de datos
     * @param sortedBy columna por la que se ordenará la consulta
     * @param direction dirección de ordenación (ASC, DESC)
     * @return una lista con los registros encontrados
     * @throws SQLException
     */
    public ArrayList<T> requestAll(String sortedBy, String direction) throws SQLException;

    /** requestById
     * Obtiene un registro del modelo dado su clave primaria
     * @param id
     * @return
     * @throws SQLException
     */
    public T requestById(long id) throws SQLException;


    /** Create
     * Crear o actualiza un registro en la base de datos para el modelo en cuestión
     * @param model Objeto a insertar o modificar
     * @return Devuelve el id del registro insertado o actualizado
     * @throws SQLException
     */
    public long createOrUpdate(T model) throws SQLException;

    /** Create
     * Crear un registro en la base de datos para el modelo en cuestión
     * @param model
     * @return
     * @throws SQLException
     */
    public long create(T model) throws SQLException;

    /** update
     * Actualiza la información de un registro de la base de datos
     * para el modelo en cuestión
     * @param object
     * @return
     * @throws SQLException
     */
    public int update(T object) throws SQLException;

    /** delete
     * Elimina un registro del modelo dada su clave primaria
     * @param id
     * @return
     * @throws SQLException
     */
    public boolean delete(long id) throws SQLException;
}
