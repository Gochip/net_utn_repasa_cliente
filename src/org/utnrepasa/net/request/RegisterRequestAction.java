package org.utnrepasa.net.request;

import org.utnrepasa.net.RequestAction;
import org.utnrepasa.net.Connection;

/**
 * Solicita un registro de usuario.
 * 
 * Envía al servidor el nombre de usuario y la clave encriptada.
 * @author Parisi Germán
 * @version 1.0
 */
public class RegisterRequestAction implements RequestAction {

    private static final long serialVersionUID = 1;
    private String userName;
    private String password;

    public RegisterRequestAction(String userName, String password) {
        this.userName = userName;
        this.password = encrypt(password);
    }

    private String encrypt(String clave) {
        return clave;
    }
    
    private String decrypt(String clave){
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
