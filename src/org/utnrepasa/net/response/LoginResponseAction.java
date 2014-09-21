package org.utnrepasa.net.response;

import org.utnrepasa.net.Connection;
import org.utnrepasa.net.ResponseAction;
import org.utnrepasa.net.principal.ControladorCliente;
import org.utnrepasa.net.util.User;

/**
 * @author Parisi Germán
 * @version 1.0
 */
public class LoginResponseAction implements ResponseAction {

    private static final long serialVersionUID = 102;
    private User user;
    private boolean correct;

    public LoginResponseAction(User user, boolean correct) {
        this.user = user;
        this.correct = correct;
    }

    @Override
    public void execute(Connection connection) {
        ControladorCliente controlador = ControladorCliente.getInstancia();
        controlador.respuestaIniciarSesion(correct, user);
        connection.close();
    }
}
