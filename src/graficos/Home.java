package graficos;

import static java.awt.EventQueue.invokeLater;
import static java.lang.System.out;
import static java.util.logging.Level.SEVERE;
import static java.util.logging.Logger.getLogger;
import javax.swing.DefaultListModel;
import javax.swing.DefaultListSelectionModel;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;
import static javax.swing.JOptionPane.showMessageDialog;
import static javax.swing.JOptionPane.showMessageDialog;
import static javax.swing.JOptionPane.showMessageDialog;
import static javax.swing.SwingConstants.CENTER;
import static javax.swing.UIManager.getInstalledLookAndFeels;
import static javax.swing.UIManager.setLookAndFeel;
import nodos.Banda;
import nodos.Escenario;
import personas.Patrocinador;

/**
 *
 * @author @luisFE/ @gonzalezes
 */
public class Home extends javax.swing.JFrame {

    private Escenario escenarios;
    private String nombre;

    public Home() {

        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);

        escenariosL.setSelectionMode(DefaultListSelectionModel.SINGLE_SELECTION);

        populate();
        actualizarEscenarios();

    }

    private void actualizarEscenarios() {
        DefaultListModel model = new DefaultListModel();
        model.clear();
        Escenario e = escenarios;
        while (e != null) {
            model.addElement("Escenario " + e.getNumero());
            e = e.getLink();
        }
        escenariosL.setModel(model);
    }

    private void actualizarBandas(Escenario e) {
        DefaultListModel model = new DefaultListModel();
        model.clear();
        Banda b = e.getBandas();
        while (b != null) {
            model.addElement(b.getNombre() + ", " + b.getNumFans() + " fans, " + b.getNumCanciones() + " canciones");
            b = b.getLink();
        }

        bandasL.setModel(model);
    }

    /*
    Creo una instacia de Escenario e = new Escenario(); 
    Para obtener los métodos y hacer la creación no?
    Al igual para las Bandas b = new Bandas(); 
    private Escenario e = new Escenario();
    private Banda b = new Banda(banda,f,songs,precio);
    void showList(String banda,int f,int songs,float precio){
        DefaultListModel model = (DefaultListModel) bandasL.getModel();
        model.clear();
        model.addElement(banda+" | "+f+" | "+songs+" | "+precio);
    }
     */
    public void populate() {
        int numero = 1;
        boolean creado = false;
        float presupuesto = 10000;

        for (int i = 0; i < 4; i++) {
            Patrocinador p = new Patrocinador("Pepito", numero);
            creado = addEscenario(new Escenario(numero, presupuesto, p, null, null));
            if (creado) {
                out.println("Escenario creado Exitosamente");
            }
            numero++;
        }

        escenarios.addbanda(new Banda("Los del Norte", 200, 5, (float) 350.3));
        escenarios.addbanda(new Banda("Los del sur", 400, 6, (float) 800.3));
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
            } else {
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
            acum += e.getCostos();
            e = e.getLink();
        }

        return acum;
    }

    /* 
        Devuelve el escenario que está actualmente seleccionado en la lista de escenarios
    **/
    private Escenario getEscenarioSeleccionado() {
        int index = escenariosL.getSelectedIndex();
        Escenario e = escenarios;

        for (int x = 0; x < index; x++) {
            e = e.getLink();
        }

        return e;
    }

    private Banda copiarBanda(Banda b) {
        Banda copia = new Banda(b.getNombre(), b.getNumFans(), b.getNumCanciones(), b.getCosto());

        return copia;
    }

    private Banda buscarBanda(String nombre) {
        Escenario e = escenarios;
        Banda listaEncontradas = null;
        Banda aux = null;

        while (e != null) {
            Banda b = e.getBandas();
            while (b != null) {
                if (b.getNombre().equals(nombre)) {
                    if (listaEncontradas == null) {
                        listaEncontradas = copiarBanda(b);
                        listaEncontradas.setLink(null);
                        aux = listaEncontradas;
                    } else {
                        aux.setLink(copiarBanda(b));
                        aux = aux.getLink();
                    }
                }
                b = b.getLink();
            }
            e = e.getLink();
        }

        return listaEncontradas;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        escenariosL = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        bandasL = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        nomPatrocinador = new javax.swing.JTextField();
        presupuestoP = new javax.swing.JTextField();
        idP = new javax.swing.JTextField();
        agregarE = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        nomBanda = new javax.swing.JTextField();
        canciones = new javax.swing.JTextField();
        precioB = new javax.swing.JTextField();
        fans = new javax.swing.JTextField();
        agregarB = new javax.swing.JButton();
        buscar = new javax.swing.JButton();
        costo = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Festival");
        setBackground(new java.awt.Color(102, 102, 102));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        escenariosL.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                escenariosLValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(escenariosL);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 261, 150));

        jScrollPane2.setViewportView(bandasL);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 280, 250, 150));

        jLabel1.setFont(new java.awt.Font("Dubai", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 153));
        jLabel1.setText("Laboratorio Multilistas");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 20, -1, -1));

        jLabel2.setFont(new java.awt.Font("Dubai", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Nombre del Patrocinador:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 172, -1));

        jLabel3.setFont(new java.awt.Font("Dubai", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 153, 153));
        jLabel3.setText("Agregar Escenario");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, -1, -1));

        jLabel4.setFont(new java.awt.Font("Dubai", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Presupuesto del Patrocinador:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, -1, -1));

        jLabel5.setFont(new java.awt.Font("Dubai", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("ID del Patrocinador:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 172, -1));

        nomPatrocinador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomPatrocinadorActionPerformed(evt);
            }
        });
        getContentPane().add(nomPatrocinador, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 110, 77, -1));

        presupuestoP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                presupuestoPActionPerformed(evt);
            }
        });
        getContentPane().add(presupuestoP, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 140, 77, -1));

        idP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idPActionPerformed(evt);
            }
        });
        getContentPane().add(idP, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 170, 77, -1));

        agregarE.setBackground(new java.awt.Color(255, 255, 255));
        agregarE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/agregar.png"))); // NOI18N
        agregarE.setText("Agregar Escenario");
        agregarE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarEActionPerformed(evt);
            }
        });
        getContentPane().add(agregarE, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 230, -1, -1));

        jLabel6.setFont(new java.awt.Font("Dubai", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 153, 153));
        jLabel6.setText("Agregar Banda");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 50, -1, -1));

        jLabel8.setFont(new java.awt.Font("Dubai", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Nombre de la Banda:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 80, 132, -1));

        jLabel9.setFont(new java.awt.Font("Dubai", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Cantidad de Canciones:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 170, 129, -1));

        jLabel10.setFont(new java.awt.Font("Dubai", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Precio de la Banda:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 140, 132, -1));

        jLabel11.setFont(new java.awt.Font("Dubai", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Número de fans:");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 200, 129, -1));

        nomBanda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomBandaActionPerformed(evt);
            }
        });
        getContentPane().add(nomBanda, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 80, 77, -1));

        canciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancionesActionPerformed(evt);
            }
        });
        getContentPane().add(canciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 170, 77, -1));

        precioB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                precioBActionPerformed(evt);
            }
        });
        getContentPane().add(precioB, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 140, 77, -1));

        fans.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fansActionPerformed(evt);
            }
        });
        getContentPane().add(fans, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 200, 77, -1));

        agregarB.setBackground(new java.awt.Color(255, 255, 255));
        agregarB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/agregar.png"))); // NOI18N
        agregarB.setText("Agregar Banda");
        agregarB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarBActionPerformed(evt);
            }
        });
        getContentPane().add(agregarB, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 230, -1, -1));

        buscar.setBackground(new java.awt.Color(255, 255, 255));
        buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/buscar.png"))); // NOI18N
        buscar.setText("Buscar banda ");
        buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarActionPerformed(evt);
            }
        });
        getContentPane().add(buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 300, 170, 40));

        costo.setBackground(new java.awt.Color(255, 255, 255));
        costo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/costo.png"))); // NOI18N
        costo.setText("Generar reporte");
        costo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                costoActionPerformed(evt);
            }
        });
        getContentPane().add(costo, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 360, 170, -1));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/Fondo.png"))); // NOI18N
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 730, 451));

        getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void nomPatrocinadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomPatrocinadorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomPatrocinadorActionPerformed

    private void presupuestoPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_presupuestoPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_presupuestoPActionPerformed

    private void idPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idPActionPerformed

    private void nomBandaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomBandaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomBandaActionPerformed

    private void cancionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancionesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cancionesActionPerformed

    private void precioBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_precioBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_precioBActionPerformed

    private void fansActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fansActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fansActionPerformed

    private void agregarBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarBActionPerformed
        if (!nomBanda.getText().isEmpty() && !precioB.getText().isEmpty() && !canciones.getText().isEmpty() && !fans.getText().isEmpty()) {
            String n = nomBanda.getText();
            float p = Float.parseFloat(precioB.getText());
            int c = Integer.parseInt(canciones.getText());
            int f = Integer.parseInt(fans.getText());

            Escenario escenario = getEscenarioSeleccionado();
            escenario.addbanda(new Banda(n, f, c, p));
            escenario.ordenarBandasDescente();
            actualizarBandas(escenario);
            JOptionPane.showMessageDialog(null, "Banda añadida exitosamente");

        } else {
            JOptionPane.showMessageDialog(null, "Faltan campos por rellenar.", "ERROR", 0);
        }
        nomBanda.setText("");
        precioB.setText("");
        canciones.setText("");
        fans.setText("");
    }//GEN-LAST:event_agregarBActionPerformed

    private void agregarEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarEActionPerformed

        if (!nomPatrocinador.getText().isEmpty() && !presupuestoP.getText().isEmpty() && !idP.getText().isEmpty()) {
            Patrocinador p = new Patrocinador(nomPatrocinador.getText(), Integer.parseInt(idP.getText()));
            float pre = Float.parseFloat(presupuestoP.getText());
            boolean creado = false;

            if (escenarios == null) {
                creado = addEscenario(new Escenario(1, pre, p, null, null));
            } else {
                creado = addEscenario(new Escenario(escenarios.getNumero() + 1, pre, p, null, null));
            }

            if (creado) {
                JOptionPane.showMessageDialog(null, "Escenario creado exitosamente");
                actualizarEscenarios();
            } else {
                JOptionPane.showMessageDialog(null, "Error al crear el escenario");
            }

        } else {
            JOptionPane.showMessageDialog(null, "Faltan campos por rellenar.", "ERROR", 0);
        }
        nomPatrocinador.setText("");
        presupuestoP.setText("");
        idP.setText("");
    }//GEN-LAST:event_agregarEActionPerformed

    private void buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarActionPerformed
        if (!nomBanda.getText().isEmpty()) {
            Banda b = buscarBanda(nomBanda.getText());
            DefaultListModel model = new DefaultListModel();
            model.clear();

            if (b == null) {
                JOptionPane.showMessageDialog(null, "No se encontro ninguna banda, con ese nombre", "ERROR", 0);
            } else {
                while (b != null) {
                    model.addElement(b.getNombre() + ", " + b.getNumFans() + " fans, " + b.getNumCanciones() + " canciones");
                    b = b.getLink();
                }

                bandasL.setModel(model);
            }

        } else {
            JOptionPane.showMessageDialog(null, "Faltan campos por rellenar: Nombre de la Banda", "ERROR", 0);
        }
        nomBanda.setText("");

    }//GEN-LAST:event_buscarActionPerformed

    private void costoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_costoActionPerformed
        // Llamar a las funcion de costo del festival. Colocar ese número aquí
        float costo = calCostosTotales();

        JOptionPane.showMessageDialog(null, "El costo total del Festival es de $" + costo, "Reporte", 1);
    }//GEN-LAST:event_costoActionPerformed

    /* 
      Este método se llama cada que vez se selecciona un nuevo escenario, e inmediatamente imprime la lista
      de bandas de el escenario
    **/
    private void escenariosLValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_escenariosLValueChanged
        Escenario e = getEscenarioSeleccionado();

        actualizarBandas(e);
    }//GEN-LAST:event_escenariosLValueChanged

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregarB;
    private javax.swing.JButton agregarE;
    private javax.swing.JList<String> bandasL;
    private javax.swing.JButton buscar;
    private javax.swing.JTextField canciones;
    private javax.swing.JButton costo;
    private javax.swing.JList<String> escenariosL;
    private javax.swing.JTextField fans;
    private javax.swing.JTextField idP;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField nomBanda;
    private javax.swing.JTextField nomPatrocinador;
    private javax.swing.JTextField precioB;
    private javax.swing.JTextField presupuestoP;
    // End of variables declaration//GEN-END:variables
}
