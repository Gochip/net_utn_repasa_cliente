package org.utnrepasa.net.response;

import org.utnrepasa.net.Connection;
import org.utnrepasa.net.ResponseAction;
import org.utnrepasa.net.principal.ControladorCliente;

/**
 *
 * @author Parisi Germán
 * @version 1.0
 */
public class RegisterResponseAction implements ResponseAction {

    private static final long serialVersionUID = 101;
    private boolean correct;

    public RegisterResponseAction(boolean correct) {
        this.correct = correct;
    }

    @Override
    public void execute(Connection connection) {
        ControladorCliente.getInstancia().respuestaRegistro(correct);
        connection.close();
    }
}
