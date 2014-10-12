package org.utnrepasa.net.clases;

import javax.swing.table.AbstractTableModel;
import org.utnrepasa.net.principal.ControladorCliente;
import org.utnrepasa.net.util.MultiplayerGame;
import org.utnrepasa.net.util.Player;
import org.utnrepasa.net.util.User;

/**
 *
 * @author Parisi Germán
 */
public class ModeloTablaResumenPartida extends AbstractTableModel {

    private MultiplayerGame mp;
    private String[] cabeceras;
    private User yo;

    public ModeloTablaResumenPartida(MultiplayerGame mp) {
        ControladorCliente controlador = ControladorCliente.getInstancia();
        yo = controlador.getUsuario();
        this.mp = mp;
        this.cabeceras = new String[]{"Posición", "Usuario", "Rondas ganadas", "Correctas", "Incorrectas"};
    }

    @Override
    public int getRowCount() {
        return mp.getPlayers().size();
    }

    @Override
    public int getColumnCount() {
        return this.cabeceras.length;
    }

    @Override
    public Object getValueAt(int r, int c) {
        Player jug = mp.getPlayers().get(r);
        switch (c) {
            case 0:
                return (r + 1) + "";
            case 1:
                return jug;
            case 2:
                return jug.getRoundsWon();
            case 3:
                return jug.getCountQuestionsAnsweredCorrectly();
            case 4:
                return jug.getCountQuestionsAnswered() - jug.getCountQuestionsAnsweredCorrectly();
        }
        return "---";
    }

    @Override
    public String getColumnName(int c) {
        return this.cabeceras[c];
    }

}
