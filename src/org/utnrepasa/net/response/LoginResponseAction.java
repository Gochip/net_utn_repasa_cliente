package org.utnrepasa.net.response;

import org.utnrepasa.net.Connection;
import org.utnrepasa.net.ResponseAction;
import org.utnrepasa.net.principal.ControladorCliente;
import org.utnrepasa.net.util.User;

/**
 * Respuesta de un inicio de sesión. Contiene el elemento User mandado por el
 * servidor y una bandera indicando si se puedo iniciar sesión exitosamente.
 *
 * @author Parisi Germán
 * @version 1.0
 */
public class LoginResponseAction implements ResponseAction {

    private static final long serialVersionUID = 102;
    private User user;
    private boolean iniciadoSesionExitosamente;

    public LoginResponseAction(User user, boolean iniciadoSesionExitosamente) {
        this.user = user;
        this.iniciadoSesionExitosamente = iniciadoSesionExitosamente;
    }

    @Override
    public void execute(Connection connection) {
        ControladorCliente controlador = ControladorCliente.getInstancia();
        controlador.respuestaIniciarSesion(iniciadoSesionExitosamente, user);
        connection.close();
    }
}
