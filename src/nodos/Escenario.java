package nodos;

import static java.lang.System.out;
import javax.print.DocFlavor;
import personas.Patrocinador;

public class Escenario {

    private int numero;
    private float presupuestoInicial;
    private float presupuestoActual;
    private Patrocinador patrocinador;
    private Banda bandas;
    private Escenario link;

    public Escenario(int numero, float presupuesto, Patrocinador patrocinador, Banda bandas, Escenario link) {
        this.numero = numero;
        this.presupuestoInicial = presupuesto;
        this.presupuestoActual = presupuesto;
        this.patrocinador = patrocinador;
        this.bandas = bandas;
        this.link = link;
    }
    
    public float getCostos() {
        float acum = 0;
        Banda b = bandas;
        
        while (b != null) {
            acum += b.getCosto();
            b = b.getLink();
        }
        
        return acum;
    }

    /* 
        Agrega una nueva banda a la lista, y enseguida ordena la lista de forma descendente
        según el número de fans de cada banda
    */
    public void addbanda(Banda nueva) {

        int numBandas = contarBandas();

        if (presupuestoActual - nueva.getCosto() > 0) {
            if (numBandas < 10) {
                if (bandas != null) {
                    getUltimaBanda().setLink(nueva);
                } else {
                    this.bandas = nueva;
                }
                presupuestoActual = presupuestoActual - nueva.getCosto();
            } else {
                throw new RuntimeException("El escenario ya cuenta con el número máximo de bandas permitidas");
            }
        } else {
            throw new RuntimeException("El escenario no cuenta con el dinero suficiente para contratar a la banda");
        }
    }
    
    public void ordenarBandasDescente() {

        boolean cambio;
        do {
            Banda actual = bandas;
            Banda anterior = null;
            Banda siguiente = actual.getLink();
            cambio = false;
            while (siguiente != null) {
                if (actual.getNumFans() > siguiente.getNumFans()) {
                    cambio = true;
                    if (anterior != null) {
                        Banda aux = siguiente.getLink();
                        anterior.setLink(siguiente);
                        siguiente.setLink(actual);
                        actual.setLink(aux);
                    } else {
                        Banda aux = siguiente.getLink();
                        bandas = siguiente;
                        siguiente.setLink(actual);
                        actual.setLink(aux);
                    }

                    anterior = siguiente;
                    siguiente = siguiente.getLink();
                } else {
                    anterior = actual;
                    actual = siguiente;
                    siguiente = siguiente.getLink();
                }
            }
        } while (cambio);
    }
    
    public void ordenarBandasAscendente() {

        boolean cambio;
        do {
            Banda actual = bandas;
            Banda anterior = null;
            Banda siguiente = actual.getLink();
            cambio = false;
            while (siguiente != null) {
                if (actual.getNumFans() < siguiente.getNumFans()) {
                    cambio = true;
                    if (anterior != null) {
                        Banda aux = siguiente.getLink();
                        anterior.setLink(siguiente);
                        siguiente.setLink(actual);
                        actual.setLink(aux);
                    } else {
                        Banda aux = siguiente.getLink();
                        bandas = siguiente;
                        siguiente.setLink(actual);
                        actual.setLink(aux);
                    }

                    anterior = siguiente;
                    siguiente = siguiente.getLink();
                } else {
                    anterior = actual;
                    actual = siguiente;
                    siguiente = siguiente.getLink();
                }
            }
        } while (cambio);
    }
    
    public Banda getBanda(String nombre) {
        Banda b = bandas;
        Banda listaNueva = null;
        Banda index = listaNueva;
        while (b != null) {
            if (b.getNombre().equalsIgnoreCase(nombre)) {
                System.out.println("Cierto");
                if (listaNueva == null) {
                    listaNueva = b; 
                } else {
                    index.setLink(b);
                    index = index.getLink();
                }
            } else {
                b = b.getLink();
            }
        }
        return listaNueva;
    }

    public Escenario getUltimoEscenario() {
        Escenario e = this;

        while (e.getLink() != null) {
            e = e.getLink();
        }

        return e;
    }

    public Banda getUltimaBanda() {
        Banda b = bandas;

        while (b.getLink() != null) {
            b = b.getLink();
        }

        return b;
    }

    public int contarBandas() {
        int cont = 0;

        Banda b = bandas;
        while (b != null) {
            b = b.getLink();
            cont++;
        }

        return cont;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public float getPresupuestoInicial() {
        return presupuestoInicial;
    }

    public void setPresupuestoInicial(float presupuestoInicial) {
        this.presupuestoInicial = presupuestoInicial;
    }

    public float getPresupuestoActual() {
        return presupuestoActual;
    }

    public void setPresupuestoActual(float presupuestoActual) {
        this.presupuestoActual = presupuestoActual;
    }

    public Patrocinador getPatrocinador() {
        return patrocinador;
    }

    public void setPatrocinador(Patrocinador patrocinador) {
        this.patrocinador = patrocinador;
    }

    public Banda getBandas() {
        return bandas;
    }

    public void setBandas(Banda bandas) {
        this.bandas = bandas;
    }

    public Escenario getLink() {
        return link;
    }

    public void setLink(Escenario link) {
        this.link = link;
    }
    

}
