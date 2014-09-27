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
public class UsersResponseAction implements ResponseAction{

    private static final long serialVersionUID = 104;
    private ArrayList<User> usuarios;
    public UsersResponseAction(ArrayList<User> usuarios){
        this.usuarios = usuarios;
    }
    
    @Override
    public void execute(Connection connection) {
        ControladorCliente controlador = ControladorCliente.getInstancia();
        controlador.recibirUsuarios(usuarios);
    }

}
