package org.utnrepasa.net.request;

import org.utnrepasa.net.Connection;
import org.utnrepasa.net.RequestAction;

/**
 * Solicita al servidor una cierta cantidad n de usuarios excluyendo al
 * solicitante.
 *
 * @author Parisi Germán
 * @version 1.0
 */
public class UsersRequestAction implements RequestAction {

    private static final long serialVersionUID = 4;
    /**
     * Cantidad de usuarios a solicitar
     */
    private final int cantidad;
    /**
     * Id del jugador
     */
    private final int id;

    public UsersRequestAction(int id, int cantidad) {
        this.cantidad = cantidad;
        this.id = id;
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public void execute(Connection connection) {
        /*Este método será implementado en el servidor*/
    }

}
