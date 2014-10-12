package org.utnrepasa.net.clases;

import javax.swing.table.AbstractTableModel;
import org.utnrepasa.net.util.MultiplayerGame;

/**
 *
 * @author Parisi Germán
 */
public class ModeloTablaResumenPartida extends AbstractTableModel {

    private MultiplayerGame mp;
    private String[] cabeceras;

    public ModeloTablaResumenPartida(MultiplayerGame mp) {
        this.mp = mp;
        this.cabeceras = new String[]{"Posición", "Usuario", "Rondas ganadas"};
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
        switch (c) {
            case 0:
                return (r + 1) + "";
            case 1:
                return mp.getPlayers().get(r);
            case 2:
                return mp.getPlayers().get(r).getRoundsWon();
        }
        return "---";
    }

    @Override
    public String getColumnName(int c) {
        return this.cabeceras[c];
    }

}
