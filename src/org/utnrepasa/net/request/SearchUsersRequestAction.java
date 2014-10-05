package org.utnrepasa.net.request;

import org.utnrepasa.net.Connection;
import org.utnrepasa.net.RequestAction;

/**
 * Solicita una cantidad n de usuarios a partir del nombre de usuario dado
 * como un patrón.
 *
 * @author Parisi Germán
 * @version 1.0
 */
public class SearchUsersRequestAction implements RequestAction {

    private static final long serialVersionUID = 5;
    /**
     * Id del jugador solicitante.
     */
    private int id;
    /**
     * Es la cantidad máxima de usuarios solicitados.
     */
    private int n;
    /**
     * Es el nombre de usuario por el cual buscar. En el servidor se lo
     * interpreta como un patrón, por ejemplo, el patrón J traerá a todos los
     * usuarios que tengan una J en su nombre de usuario.
     */
    private String nombre;

    public SearchUsersRequestAction(int id, int n, String nombre) {
        this.id = id;
        this.n = n;
        this.nombre = nombre;
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public void execute(Connection connection) {
        /*Este método se implementará en el servidor.*/
    }

}
