package org.utnrepasa.net.request;

import org.utnrepasa.net.Connection;
import org.utnrepasa.net.RequestAction;

/**
 * Esta clase solicita el inicio de sesión.
 * Se envía como parámetro al nombre de usuario y a la clave.
 * La clave viaja en texto plano.
 *
 * @author Parisi Germán
 * @version 1.0
 */
public class LoginRequestAction implements RequestAction {

    private static final long serialVersionUID = 2;
    private String nombreUsuario;
    private String clave;

    public LoginRequestAction(String nombreUsuario, String clave) {
        this.nombreUsuario = nombreUsuario;
        this.clave = clave;
    }

    @Override
    public int getId() {
        return -1;
    }

    @Override
    public void execute(Connection connection) {
        /*Este método será implementado en el servidor*/
    }
}
