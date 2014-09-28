package org.utnrepasa.net.request;

import org.utnrepasa.net.Connection;
import org.utnrepasa.net.RequestAction;

/**
 *
 * @author Parisi Germán
 * @version 1.0
 */
public class SearchUsersRequestAction implements RequestAction{

    private static final long serialVersionUID = 5;
    private int id;
    private int n;
    private String nombre;
    public SearchUsersRequestAction(int id, int n, String nombre){
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
