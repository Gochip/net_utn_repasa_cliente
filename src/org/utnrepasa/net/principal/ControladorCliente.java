package org.utnrepasa.net.principal;

import org.utnrepasa.net.Client;
import org.utnrepasa.net.request.RegisterRequestAction;

/**
 *
 * @author Parisi Germán
 */
public class ControladorCliente {
    public static void main(String args[]){
        Client client = new Client();
        client.send(new RegisterRequestAction());
    }
}
