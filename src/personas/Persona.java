
package personas;

public abstract class Persona {
    private String nombre;
    private String identificacion;

    public Persona(String nombre, String identificacion) {
        this.nombre = nombre;
        this.identificacion = identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    private void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    private void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }
}
