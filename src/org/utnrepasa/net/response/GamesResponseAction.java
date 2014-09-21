package org.utnrepasa.net.response;

import java.util.ArrayList;
import org.utnrepasa.net.Connection;
import org.utnrepasa.net.ResponseAction;
import org.utnrepasa.net.principal.ControladorCliente;
import org.utnrepasa.net.util.MultiplayerGame;

/**
 * Respuesta del servidor con las partidas del jugador.
 *
 * Partidas en juego, creadas, invitaciones y finalizadas.
 *
 * @author Parisi Germán
 * @author 1.0
 */
public class GamesResponseAction implements ResponseAction {

    private static final long serialVersionUID = 106;
    private ArrayList<MultiplayerGame> games;

    public GamesResponseAction() {
        this.games = new ArrayList<>();
    }

    public GamesResponseAction(ArrayList<MultiplayerGame> games) {
        this.games = games;
    }

    public void addGame(MultiplayerGame game) {
        this.games.add(game);
    }

    @Override
    public void execute(Connection connection) {
        ControladorCliente controlador = ControladorCliente.getInstancia();
        controlador.recibirPartidas(games);
        connection.close();
    }
}
