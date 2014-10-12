package org.utnrepasa.net.request;

import org.utnrepasa.net.Connection;
import org.utnrepasa.net.RequestAction;

/**
 *
 * @author Parisi Germán
 */
public class GameRequestAction implements RequestAction {

    private static final long serialVersionUID = 13;
    private int idPartida;
    private int idUsuario;

    public GameRequestAction(int idUsuario, int idPartida) {
        this.idPartida = idPartida;
        this.idUsuario = idUsuario;
    }

    @Override
    public int getId() {
        return this.idUsuario;
    }

    @Override
    public void execute(Connection connection) {
    }

}
