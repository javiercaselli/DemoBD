package individuos;

/** Individuo
 * Mantiene los datos de un individuo
 * id: Identificado único del individuo coincide con su PK
 * nombre: Nombre del individuo
 * apellido1: Apellido1 del individuo
 * apellido2: Apellido2 del individuo
 * progenitor1: Id del progenitor1 del individuo
 * progenitor2: Id del progenitor2 del individuo
 */
public class Individuo {
    // Propiedades
    private Long id;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private Long progenitor1;
    private Long progenitor2;

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public Long getProgenitor1() {
        return progenitor1;
    }

    public void setProgenitor1(Long progenitor1) {
        this.progenitor1 = progenitor1;
    }

    public Long getProgenitor2() {
        return progenitor2;
    }

    public void setProgenitor2(Long progenitor2) {
        this.progenitor2 = progenitor2;
    }

    @Override
    public String toString() {
        return "Individuo{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido1='" + apellido1 + '\'' +
                ", apellido2='" + apellido2 + '\'' +
                ", progenitor1=" + progenitor1 +
                ", progenitor2=" + progenitor2 +
                '}';
    }
}
