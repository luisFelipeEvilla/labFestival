package festival;

import nodos.Banda;
import nodos.Escenario;
import personas.Patrocinador;

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
                System.out.println("Escenario creado Exitosamente");
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
                        System.out.println("Error, dos escenarios no pueden tener el mismo patrocinador");
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
                System.out.println("Error, no se pueden crear más de 5 escenarios");
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

    public static void main(String[] args) {
        Festival app = new Festival(null, "Musica");

        app.populate();
        Escenario e = app.escenarios;
        
        // Imprime el número de cada uno de los escenarios
        while (e != null) {
            System.out.println("Escenario " + e.getNumero());
            e = e.getLink();
        }
        
        
        /*Añadiendo nuevas bandas, falta probar casos, como que el escenario
          haya alcanzado el número máximo de bandas
        **/
        if(app.escenarios.addbanda(new Banda("Los del Norte", 200, 5, (float) 350.3))) {
            System.out.println("Banda creada exitosamente");
        }
        if(app.escenarios.addbanda(new Banda("Los del sur", 400, 6, (float) 800.3))) {
            System.out.println("Banda creada exitosamente");
        }
        if(app.escenarios.addbanda(new Banda("Los del este", 100, 2, (float) 100000))) {
            System.out.println("Banda creada exitosamente");
        }
        
    }

}
