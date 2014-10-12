package org.utnrepasa.net.response;

import org.utnrepasa.net.Connection;
import org.utnrepasa.net.ResponseAction;
import org.utnrepasa.net.principal.ControladorCliente;

/**
 *
 * @author Parisi Germán
 * @version 1.0
 */
public class AcceptInvitationResponseAction implements ResponseAction {

    private static final long serialVersionUID = 107;
    private final boolean correcto;
    private final int id;
    private final int idPartida;

    public AcceptInvitationResponseAction(int id, boolean correcto, int idPartida) {
        this.id = id;
        this.idPartida = idPartida;
        this.correcto = correcto;
    }

    @Override
    public void execute(Connection connection) {
        connection.close();
        ControladorCliente controlador = ControladorCliente.getInstancia();
        controlador.recibirRespuestaAceptarInvitacion(correcto, idPartida);
        
    }

}
