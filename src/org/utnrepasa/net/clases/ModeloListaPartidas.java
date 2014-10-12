package org.utnrepasa.net.clases;

import java.util.ArrayList;
import javax.swing.AbstractListModel;
import org.utnrepasa.net.principal.ControladorCliente;
import org.utnrepasa.net.util.Game;
import org.utnrepasa.net.util.MultiplayerGame;
import org.utnrepasa.net.util.User;

/**
 *
 * @author Parisi Germán
 */
public class ModeloListaPartidas extends AbstractListModel<String> {

    private ArrayList<MultiplayerGame> partidas;

    public ModeloListaPartidas() {
        this.partidas = new ArrayList<>();
    }

    public void agregarPartida(MultiplayerGame partida) {
        this.partidas.add(partida);
    }

    public MultiplayerGame getMultiplayerGame(int i) {
        return this.partidas.get(i);
    }

    @Override
    public int getSize() {
        return this.partidas.size();
    }

    @Override
    public String getElementAt(int i) {
        MultiplayerGame mg = this.partidas.get(i);
        ControladorCliente controlador = ControladorCliente.getInstancia();
        User yo = controlador.getUsuario();
        if (mg.getState() == Game.STATE.STARTED) {
            if (yo.equals(mg.getPlayerTurn())) {
                return this.partidas.get(i).toString() + " (Tu turno)";
            } else {
                return this.partidas.get(i).toString() + " (Esperando)";
            }
        } else {
            return this.partidas.get(i).toString();
        }
    }

    public void clear() {
        this.partidas.clear();
    }

}
