package org.utnrepasa.net.request;

import java.util.ArrayList;
import org.utnrepasa.net.Connection;
import org.utnrepasa.net.RequestAction;
import org.utnrepasa.net.util.Course;
import org.utnrepasa.net.util.User;

/**
 * El cliente solicita al servidor crear una partida multijugador con los
 * siguientes datos: invitados, cantidad de rondas, cantidad de preguntas por
 * cada ronda y las materias de la partida.
 *
 * @author Parisi Germán
 * @version 1.1
 */
public class CreateMultiPlayerRequestAction implements RequestAction {

    private static final long serialVersionUID = 3;
    private final int id;
    private final ArrayList<User> invitados;
    private final int cantidadRondas;
    private final int preguntasPorRondas;
    private final ArrayList<Course> materias;

    public CreateMultiPlayerRequestAction(int id, ArrayList<User> invitados, int cantidadRondas, int preguntasPorRondas, ArrayList<Course> materias) {
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
