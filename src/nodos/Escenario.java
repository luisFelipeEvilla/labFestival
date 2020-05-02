package nodos;

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

    
    public boolean addbanda(Banda nueva) {
        boolean creada = false;

        int numBandas = contarBandas();

        if (presupuestoActual - nueva.getCosto() > 0) {
            if (numBandas < 10) {
                if (bandas != null) {
                    getUltimaBanda().setLink(nueva);
                } else {
                    this.bandas = nueva;
                }
                presupuestoActual = presupuestoActual - nueva.getCosto();
                creada = true;
            } else {
                System.out.println("El escenario ya cuenta con el número máximo de bandas permitidas");
            }
        } else {
            System.out.println("El escenario no cuenta con el dinero suficiente para contratar a la banda");
        }

        return creada;
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
