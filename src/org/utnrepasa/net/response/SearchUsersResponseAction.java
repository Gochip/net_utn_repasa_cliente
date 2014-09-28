package org.utnrepasa.net.response;

import java.util.ArrayList;
import org.utnrepasa.net.Connection;
import org.utnrepasa.net.ResponseAction;
import org.utnrepasa.net.principal.ControladorCliente;
import org.utnrepasa.net.util.User;

/**
 *
 * @author Parisi Germán
 * @version 1.0
 */
public class SearchUsersResponseAction implements ResponseAction{

    private static final long serialVersionUID = 105;
    private ArrayList<User> usuarios;
    public SearchUsersResponseAction(ArrayList<User> usuarios){
        this.usuarios = usuarios;
    }
    @Override
    public void execute(Connection connection) {
        ControladorCliente.getInstancia().recibirUsuarios(usuarios);
        connection.close();
    }
}