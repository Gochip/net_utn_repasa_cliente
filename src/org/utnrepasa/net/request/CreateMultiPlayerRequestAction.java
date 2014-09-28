package org.utnrepasa.net.request;

import java.util.ArrayList;
import org.utnrepasa.net.Connection;
import org.utnrepasa.net.RequestAction;
import org.utnrepasa.net.util.Matter;
import org.utnrepasa.net.util.User;

/**
 *
 * @author Parisi Germán
 * @version 1.0
 */
public class CreateMultiPlayerRequestAction implements RequestAction{

    private static final long serialVersionUID = 3;
    private int id;
    private ArrayList<User> invitados;
    private int cantidadRondas;
    private int preguntasPorRondas;
    private ArrayList<Matter> materias;
    public CreateMultiPlayerRequestAction(int id, ArrayList<User> invitados, int cantidadRondas, int preguntasPorRondas, ArrayList<Matter> materias){
        this.id = id;
        this.invitados = invitados;
        this.cantidadRondas = cantidadRondas;
        this.preguntasPorRondas = preguntasPorRondas;
        this.materias = materias;
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