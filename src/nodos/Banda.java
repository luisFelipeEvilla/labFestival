package nodos;

public class Banda {

    private String nombre;
    private int numFans;
    private int numCanciones;
    private float costo;
    private Banda link;

    public Banda(String nombre, int numFans, int numCanciones, float costo) {
        this.nombre = nombre;
        this.numFans = numFans;
        this.numCanciones = numCanciones;
        this.costo = costo;
    }

    public void setLink(Banda b) {
        this.link = b;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNumFans() {
        return numFans;
    }

    public int getNumCanciones() {
        return numCanciones;
    }

    public float getCosto() {
        return costo;
    }

    public Banda getLink() {
        return link;
    }

}
