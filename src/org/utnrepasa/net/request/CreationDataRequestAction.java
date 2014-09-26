package org.utnrepasa.net.request;

import org.utnrepasa.net.Connection;
import org.utnrepasa.net.RequestAction;

/**
 *
 * @author Parisi Germán
 * @version 1.0
 */
public class CreationDataRequestAction implements RequestAction{

    private static final long serialVersionUID = 12;
    private int id;
    public CreationDataRequestAction(int id){
        this.id = id;
    }
    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public void execute(Connection connection) {
        /*Este método será implementado en el servidor*/
    }

}
