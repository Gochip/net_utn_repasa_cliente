package org.utnrepasa.net.response;

import java.util.ArrayList;
import org.utnrepasa.net.Connection;
import org.utnrepasa.net.ResponseAction;
import org.utnrepasa.net.principal.ControladorCliente;
import org.utnrepasa.net.util.Course;

/**
 *
 * @author Parisi Germán
 * @version 1.0
 */
public class CreationDataResponseAction implements ResponseAction{
    private static final long serialVersionUID = 112;
    /**
     * Un array con las materias permitidas.
     */
    private final ArrayList<Course> materias;
    /**
     * Un array con las cantidades de rondas permitidas.
     */
    private final ArrayList<Integer> rondas;

    public CreationDataResponseAction(ArrayList<Course> materias, ArrayList<Integer> rondas){
        this.materias = materias;
        this.rondas = rondas;
    }
    @Override
    public void execute(Connection connection) {
        ControladorCliente.getInstancia().recibirDatosCreacionPartida(materias);
        connection.close();
    }
}
