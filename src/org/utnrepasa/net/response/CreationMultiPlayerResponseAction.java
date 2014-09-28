package org.utnrepasa.net.response;

import org.utnrepasa.net.Connection;
import org.utnrepasa.net.ResponseAction;
import org.utnrepasa.net.principal.ControladorCliente;

/**
 *
 * @author Parisi Germán
 * @version 1.0
 */
public class CreationMultiPlayerResponseAction implements ResponseAction {
    
    private static final long serialVersionUID = 103;
    private boolean creacionCorrecta;
    public CreationMultiPlayerResponseAction(boolean creacionCorrecta){
        this.creacionCorrecta = creacionCorrecta;
    }
    @Override
    public void execute(Connection connection) {
        ControladorCliente controlador = ControladorCliente.getInstancia();
        controlador.respuestaCreacionPartida(creacionCorrecta);
        connection.close();
    }
}
