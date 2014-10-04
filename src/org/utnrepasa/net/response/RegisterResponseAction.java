package org.utnrepasa.net.response;

import org.utnrepasa.net.Connection;
import org.utnrepasa.net.ResponseAction;
import org.utnrepasa.net.principal.ControladorCliente;

/**
 * Representa la respuesta del servidor.
 * @author Parisi Germán
 * @version 1.0
 */
public class RegisterResponseAction implements ResponseAction {

    private static final long serialVersionUID = 101;
    /**
     * Si esta variable es true entonces el registro fue exitoso.
     * También puede ser false si ya existe un usuario con el mismo nombre de
     * usuario o bien si el nombre de usuario es demasiado largo,
     * (mayor a 50 caracteres).
     */
    private boolean registroCorrecto;

    public RegisterResponseAction(boolean registroCorrecto) {
        this.registroCorrecto = registroCorrecto;
    }

    @Override
    public void execute(Connection connection) {
        ControladorCliente.getInstancia().respuestaRegistro(registroCorrecto);
        connection.close();
    }
}
