package nodos;

import personas.Patrocinador;

public class Escenario {

    private int numero;
    private float presupuesto;
    private Patrocinador patrocinador;
    private Banda bandas;
    private Escenario link;

    public Escenario(int numero, float presupuesto, Patrocinador patrocinador, Banda bandas, Escenario link) {
        this.numero = numero;
        this.presupuesto = presupuesto;
        this.patrocinador = patrocinador;
        this.bandas = bandas;
        this.link = link;
    }

    public boolean addbanda(Banda b) {
        boolean creada = false;
        
        int numBandas = contarBandas();
        
        if (numBandas < 5) {
            getUltimaBanda().setLink(b);
            creada = true;
        } else {
            creada = false;
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
        }
        
        return cont;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public float getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(float presupuesto) {
        this.presupuesto = presupuesto;
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
