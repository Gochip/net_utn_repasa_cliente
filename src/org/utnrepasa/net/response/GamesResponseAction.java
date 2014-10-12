package org.utnrepasa.net.response;

import java.util.ArrayList;
import org.utnrepasa.net.Connection;
import org.utnrepasa.net.ResponseAction;
import org.utnrepasa.net.principal.ControladorCliente;
import org.utnrepasa.net.util.MultiplayerGame;

/**
 * Respuesta del servidor con las partidas del jugador.
 *
 * Partidas en estado "esperando", "en juego" y finalizadas.
 *
 * @author Parisi Germán
 * @author 1.0
 */
public class GamesResponseAction implements ResponseAction {

    private static final long serialVersionUID = 106;
    private ArrayList<MultiplayerGame> partidas;

    public GamesResponseAction() {
        this.partidas = new ArrayList<>();
    }

    public GamesResponseAction(ArrayList<MultiplayerGame> games) {
        this.partidas = games;
    }

    public void addGame(MultiplayerGame game) {
        this.partidas.add(game);
    }

    @Override
    public void execute(Connection connection) {
        ControladorCliente controlador = ControladorCliente.getInstancia();
        controlador.respuestaSolicitarPartidas(partidas);
        connection.close();
    }
}
