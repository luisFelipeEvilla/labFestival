
package personas;

public abstract class Persona {
    private String nombre;
    private int identificacion;

    public Persona(String nombre, int identificacion) {
        this.nombre = nombre;
        this.identificacion = identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    private void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdentificacion() {
        return identificacion;
    }

    private void setIdentificacion(int identificacion) {
        this.identificacion = identificacion;
    }
}
