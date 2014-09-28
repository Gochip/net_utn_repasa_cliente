package org.utnrepasa.net.request;

import org.utnrepasa.net.Connection;
import org.utnrepasa.net.RequestAction;

/**
 *
 * @author Parisi Germán
 * @version 1.0
 */
public class AcceptInvitationRequestAction implements RequestAction{

    private static final long serialVersionUID = 7;
    private int id;
    private int idPartida;
    public AcceptInvitationRequestAction(int id, int idPartida){
        this.id = id;
        this.idPartida = idPartida;
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
