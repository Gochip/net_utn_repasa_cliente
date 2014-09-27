package org.utnrepasa.net.request;

import org.utnrepasa.net.Connection;
import org.utnrepasa.net.RequestAction;

/**
 *
 * @author Parisi Germán
 * @version 1.0
 */
public class UsersRequestAction implements RequestAction{

    private static final long serialVersionUID = 4;
    /**
     * Cantidad de usuarios
     */
    private int cantidad;
    /**
     * Id del jugador
     */
    private int id;
    public UsersRequestAction(int id, int cantidad){
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
