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
    /**
     * Es una lista de usuarios. Puede ser null en caso que los parámetros
     * hayan generado algún problema en el lado del servidor. Por ejemplo:
     * que la cantidad solicitada sea <= 0.
     */
    private ArrayList<User> usuarios;
    public UsersResponseAction(ArrayList<User> usuarios){
        this.usuarios = usuarios;
    }
    
    @Override
    public void execute(Connection connection) {
        ControladorCliente controlador = ControladorCliente.getInstancia();
        controlador.recibirUsuarios(usuarios);
        connection.close();
    }

}
