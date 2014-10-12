package org.utnrepasa.net.principal;

import java.util.ArrayList;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import org.utnrepasa.net.clases.ModeloListaPartidas;
import org.utnrepasa.net.util.Game;
import org.utnrepasa.net.util.MultiplayerGame;
import org.utnrepasa.net.util.Player;
import org.utnrepasa.net.util.User;

/**
 *
 * @author Parisi Germán
 */
public class VentanaListaPartidas extends javax.swing.JFrame {

    private static VentanaListaPartidas yo;
    private ModeloListaPartidas modeloPartidasEnJuego, modeloPartidasFinalizadas, modeloPartidasInvitadas, modeloPartidasCreadas;

    private VentanaListaPartidas() {
        initComponents();
        modeloPartidasEnJuego = new ModeloListaPartidas();
        modeloPartidasFinalizadas = new ModeloListaPartidas();
        modeloPartidasInvitadas = new ModeloListaPartidas();
        modeloPartidasCreadas = new ModeloListaPartidas();
    }

    public static VentanaListaPartidas getInstancia() {
        if (yo == null) {
            yo = new VentanaListaPartidas();
        }
        return yo;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.lblNombreUsuario.setText(nombreUsuario);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstPartidasEnJuego = new javax.swing.JList();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstInvitaciones = new javax.swing.JList();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        lstCreadas = new javax.swing.JList();
        jScrollPane4 = new javax.swing.JScrollPane();
        lstFinalizadas = new javax.swing.JList();
        jLabel5 = new javax.swing.JLabel();
        btnCrearPartida = new javax.swing.JButton();
        btnAceptarInvitacion = new javax.swing.JButton();
        btnJugar = new javax.swing.JButton();
        lblNombreUsuario = new javax.swing.JLabel();
        btnVer = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Partidas");

        lstPartidasEnJuego.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lstPartidasEnJuego.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstPartidasEnJuegoValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(lstPartidasEnJuego);

        jLabel2.setText("En juego");

        lstInvitaciones.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lstInvitaciones.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstInvitacionesValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(lstInvitaciones);

        jLabel3.setText("Invitaciones");

        jLabel4.setText("Creadas");

        lstCreadas.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane3.setViewportView(lstCreadas);

        lstFinalizadas.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lstFinalizadas.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstFinalizadasValueChanged(evt);
            }
        });
        jScrollPane4.setViewportView(lstFinalizadas);

        jLabel5.setText("Finalizadas");

        btnCrearPartida.setText("Crear partida");
        btnCrearPartida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearPartidaActionPerformed(evt);
            }
        });

        btnAceptarInvitacion.setText("Aceptar invitación");
        btnAceptarInvitacion.setEnabled(false);
        btnAceptarInvitacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarInvitacionActionPerformed(evt);
            }
        });

        btnJugar.setText("Jugar");
        btnJugar.setEnabled(false);
        btnJugar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJugarActionPerformed(evt);
            }
        });

        lblNombreUsuario.setText("jLabel6");

        btnVer.setText("Ver");
        btnVer.setEnabled(false);
        btnVer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblNombreUsuario)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addGap(105, 105, 105)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnVer)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnJugar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAceptarInvitacion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCrearPartida)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(lblNombreUsuario))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnJugar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnVer))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnCrearPartida)
                        .addComponent(btnAceptarInvitacion)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCrearPartidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearPartidaActionPerformed
        ControladorCliente controlador = ControladorCliente.getInstancia();
        controlador.abrirVentanaCrearPartida();
    }//GEN-LAST:event_btnCrearPartidaActionPerformed

    private void lstInvitacionesValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstInvitacionesValueChanged
        int indice = lstInvitaciones.getSelectedIndex();
        if (indice != -1) {
            btnAceptarInvitacion.setEnabled(true);
        }
    }//GEN-LAST:event_lstInvitacionesValueChanged

    private void btnAceptarInvitacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarInvitacionActionPerformed
        int indice = lstInvitaciones.getSelectedIndex();
        if (indice != -1) {
            MultiplayerGame mg = modeloPartidasEnJuego.getMultiplayerGame(indice);
            int id = mg.getId();
            ControladorCliente.getInstancia().aceptarInvitación(id);
        }
    }//GEN-LAST:event_btnAceptarInvitacionActionPerformed

    private void lstPartidasEnJuegoValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstPartidasEnJuegoValueChanged
        int indice = lstPartidasEnJuego.getSelectedIndex();
        if (indice != -1) {
            btnJugar.setEnabled(true);
        }
    }//GEN-LAST:event_lstPartidasEnJuegoValueChanged

    private void btnJugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnJugarActionPerformed
        int indice = lstPartidasEnJuego.getSelectedIndex();
        if (indice != -1) {
            ControladorCliente controlador = ControladorCliente.getInstancia();
            User yo = controlador.getUsuario();
            MultiplayerGame partida = modeloPartidasEnJuego.getMultiplayerGame(indice);
            Player jugador = partida.getPlayerTurn();
            if (jugador.equals(yo)) {
                controlador.solicitarPreguntas(partida.getId());
            } else {
                JOptionPane.showMessageDialog(this, "No es tu turno");
            }
        }
    }//GEN-LAST:event_btnJugarActionPerformed

    private void lstFinalizadasValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstFinalizadasValueChanged
        int indiceSeleccionado = lstFinalizadas.getSelectedIndex();
        if(indiceSeleccionado >= 0){
            btnVer.setEnabled(true);
        }else{
            btnVer.setEnabled(false);
        }
    }//GEN-LAST:event_lstFinalizadasValueChanged

    private void btnVerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerActionPerformed
        ControladorCliente controlador = ControladorCliente.getInstancia();
        System.out.println(lstFinalizadas.getSelectedIndex());
        MultiplayerGame mg = modeloPartidasFinalizadas.getMultiplayerGame(lstFinalizadas.getSelectedIndex());
        controlador.solicitarDatosPartida(mg.getId());
    }//GEN-LAST:event_btnVerActionPerformed

    public void recibirPartidasEnJuego(ArrayList<MultiplayerGame> partidasEnJuego) {
        modeloPartidasCreadas.clear();
        modeloPartidasEnJuego.clear();
        modeloPartidasFinalizadas.clear();
        modeloPartidasInvitadas.clear();
        ControladorCliente controlador = ControladorCliente.getInstancia();
        User yo = controlador.getUsuario();
        for (MultiplayerGame partida : partidasEnJuego) {
            if (partida.getState() == Game.STATE.STARTED) {
                Player jugador = partida.getPlayerTurn();
                if (jugador.equals(yo)) {
                    modeloPartidasEnJuego.agregarPartida(partida);
                    System.out.println("ES MI TURNO");
                } else {
                    modeloPartidasEnJuego.agregarPartida(partida);
                    System.out.println("NO ES MI TURNO");
                }
            } else if (partida.getState() == Game.STATE.FINALIZED) {
                modeloPartidasFinalizadas.agregarPartida(partida);
            } else if (partida.getState() == Game.STATE.WAITING) {
                if (partida.getCreator().equals(yo)) {
                    modeloPartidasCreadas.agregarPartida(partida);
                } else {
                    modeloPartidasInvitadas.agregarPartida(partida);
                }
            }
        }
        lstPartidasEnJuego.setModel(modeloPartidasEnJuego);
        lstFinalizadas.setModel(modeloPartidasFinalizadas);
        lstInvitaciones.setModel(modeloPartidasInvitadas);
        lstCreadas.setModel(modeloPartidasCreadas);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptarInvitacion;
    private javax.swing.JButton btnCrearPartida;
    private javax.swing.JButton btnJugar;
    private javax.swing.JButton btnVer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lblNombreUsuario;
    private javax.swing.JList lstCreadas;
    private javax.swing.JList lstFinalizadas;
    private javax.swing.JList lstInvitaciones;
    private javax.swing.JList lstPartidasEnJuego;
    // End of variables declaration//GEN-END:variables
}
