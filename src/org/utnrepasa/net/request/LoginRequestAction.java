package org.utnrepasa.net.request;

import org.utnrepasa.net.Connection;
import org.utnrepasa.net.RequestAction;

/**
 * Esta clase solicita el inicio de sesión.
 * @author Parisi Germán
 * @version 1.0
 */
public class LoginRequestAction implements RequestAction {

    private static final long serialVersionUID = 2;
    private String userName;
    private String password;

    public LoginRequestAction(String userName, String password) {
        this.userName = userName;
        this.password = password;
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
