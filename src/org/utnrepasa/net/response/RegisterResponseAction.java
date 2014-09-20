package org.utnrepasa.net.response;

import org.utnrepasa.net.Connection;
import org.utnrepasa.net.ResponseAction;

/**
 *
 * @author Parisi Germán
 */
public class RegisterResponseAction implements ResponseAction{

    private static final long serialVersionUID = 101;
    @Override
    public void execute(Connection connection) {
        System.out.println("El servidor respondió!!!");
        connection.setListening(false);
        System.out.println("FIN CLIENTE!");
    }

}
