package org.utnrepasa.net.request;

import org.utnrepasa.net.Connection;
import org.utnrepasa.net.RequestAction;

/**
 * Esta clase solicita los juegos o partidas actuales para el jugador.
 * 
 * @author Parisi Germán
 * @version 1.0
 */
public class GamesRequestAction implements RequestAction {

    private static final long serialVersionUID = 6;
    private int id;

    public GamesRequestAction(int id) {
        this.id = id;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void execute(Connection connection) {
        /*Este método será implementado en el servidor*/
    }
}
