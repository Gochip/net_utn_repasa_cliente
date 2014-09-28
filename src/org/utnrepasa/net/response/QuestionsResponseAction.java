package org.utnrepasa.net.response;

import java.util.ArrayList;
import org.utnrepasa.net.Connection;
import org.utnrepasa.net.ResponseAction;
import org.utnrepasa.net.principal.ControladorCliente;
import org.utnrepasa.net.util.Question;

/**
 *
 * @author Parisi Germán
 * @version 1.0
 */
public class QuestionsResponseAction implements ResponseAction {

    private static final long serialVersionUID = 108;
    private ArrayList<Question> preguntas;
    private int idPartida;
    public QuestionsResponseAction(ArrayList<Question> preguntas, int idPartida) {
        this.preguntas = preguntas;
        this.idPartida = idPartida;
    }

    @Override
    public void execute(Connection connection) {
        connection.close();
        ControladorCliente.getInstancia().recibirPreguntas(preguntas, idPartida);
    }

}
