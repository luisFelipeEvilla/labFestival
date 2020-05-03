package festival;

import static java.lang.System.out;
import nodos.Banda;
import nodos.Escenario;
import personas.Patrocinador;
import graficos.Home;
public class Festival {

    private Escenario escenarios;
    private String nombre;

    public Festival(Escenario escenarios, String nombre) {
        this.escenarios = escenarios;
        this.nombre = nombre;
    }
    
    /*
        Solamente añade nuevos escenarios por cada iteracion del ciclo for
        su uso, es solo para probar que el método de añadir escenario funciona
    **/
    public void populate() {
        int numero = 1;
        boolean creado = false;
        float presupuesto = 10000;

        for (int i = 0; i < 6; i++) {
            Patrocinador p = new Patrocinador("Pepito", numero);
            creado = addEscenario(new Escenario(numero, presupuesto, p, null, null));
            if (creado) {
                out.println("Escenario creado Exitosamente");
            }
            numero ++;
        }
    }

    public boolean addEscenario(Escenario nuevo) {
        boolean creado = false;
        boolean repetido = false;
        Escenario e = escenarios;
        

        if (escenarios != null) {
            if (escenarios.getNumero() < 5) {
                while (e != null) {         
                    int id = e.getPatrocinador().getIdentificacion();
                    int idNuevo = nuevo.getPatrocinador().getIdentificacion();
                    if (id == idNuevo) {
                        repetido = true;
                        out.println("Error, dos escenarios no pueden tener el mismo patrocinador");
                        break;
                    }
                    e = e.getLink();
                } 
                
                if (!repetido) {
                    nuevo.setLink(escenarios);
                    escenarios = nuevo;
                    creado = true;
                }
            }  else {
                out.println("Error, no se pueden crear más de 5 escenarios");
            }
        } else {
            creado = true;
            escenarios = nuevo;
        }

        return creado;
    }

    public Escenario getUltimoEscenario() {
        Escenario ultimo = escenarios;

        if (ultimo != null) {
            while (ultimo.getLink() != null) {
                ultimo = ultimo.getLink();
            }
        }

        return ultimo;
    }
    
    public float calCostosTotales() {
        int acum = 0;
        Escenario e = escenarios;
        
        while (e != null) {
           acum += e.getPresupuestoInicial() - e.getPresupuestoActual();
           e = e.getLink();
        }
        
        return acum;
    }

    public static void main(String[] args) {
        Home app = new Home();
        app.setVisible(true);
        
        /*
        app.populate();
        Escenario e = app.escenarios;
        
        // Imprime el número de cada uno de los escenarios
        while (e != null) {
            out.println("Escenario " + e.getNumero());
            e = e.getLink();
        }
        **/
        
        /*Añadiendo nuevas bandas, falta probar casos, como que el escenario
          haya alcanzado el número máximo de bandas
        **/
        /*
        if(app.) {
            out.println("Banda creada exitosamente");
        }
        if(app.) {
            out.println("Banda creada exitosamente");
        }
        if(app.escenarios.addbanda(new Banda("Los del este", 600, 2, (float) 100))) {
            out.println("Banda creada exitosamente");
        }
        if(app.escenarios.addbanda(new Banda("Los del oeste", 100, 2, (float) 10))) {
            out.println("Banda creada exitosamente");
        }
        app.escenarios.ordenarBandasDescente();
        
        Banda b = app.escenarios.getBandas();
        
        while (b != null) {
            out.println(b.getNombre() + ", con " +b.getNumFans() + " fans");
            b = b.getLink();
        }
        
        out.println("El costo total del evento fue: " + app.calCostosTotales());
        **/
    }

}
