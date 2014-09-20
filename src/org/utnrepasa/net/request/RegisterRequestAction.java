package org.utnrepasa.net.request;

import org.utnrepasa.net.RequestAction;
import org.utnrepasa.net.Connection;

/**
 *
 * @author Parisi Germán
 */
public class RegisterRequestAction implements RequestAction{

    private static final long serialVersionUID = 1;
    
    @Override
    public int getId() {
        return -1;
    }

    @Override
    public void execute(Connection connection) {
        /*Este método se implementará en el servidor.*/
    }
}
