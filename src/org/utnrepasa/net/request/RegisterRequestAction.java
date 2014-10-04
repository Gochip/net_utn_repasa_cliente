package org.utnrepasa.net.request;

import org.utnrepasa.net.RequestAction;
import org.utnrepasa.net.Connection;

/**
 * Solicita un registro de usuario a partir de su nombre de usuario y la clave
 * encriptada.
 *
 * @author Parisi Germán
 * @version 1.0
 */
public class RegisterRequestAction implements RequestAction {

    private static final long serialVersionUID = 1;
    private String nombreUsuario;
    private String clave;

    public RegisterRequestAction(String nombreUsuario, String clave) {
        this.nombreUsuario = nombreUsuario;
        this.clave = encriptar(clave);
    }

    private String encriptar(String clave) {
        return clave;
    }

    private String desencriptar(String clave) {
        return clave;
    }

    @Override
    public int getId() {
        return -1;
    }

    @Override
    public void execute(Connection connection) {
        /*Este método se implementará en el servidor.*/
    }
}
