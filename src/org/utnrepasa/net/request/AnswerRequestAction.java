package org.utnrepasa.net.request;

import java.util.ArrayList;
import org.utnrepasa.net.Connection;
import org.utnrepasa.net.RequestAction;
import org.utnrepasa.net.util.Question;

/**
 * Envía al servidor las respuestas y las calificaciones de las preguntas.
 *
 * @author Parisi Germán
 */
public class AnswerRequestAction implements RequestAction{

    private static final long serialVersionUID = 9;
    /**
     * Es el id del usuario que envía las respuestas.
     */
    private int id;
    
    /**
     * Es el id de la partida.
     */
    private int idPartida;
    
    /**
     * Son las preguntas que está respondiendo.
     */
    private ArrayList<Question> preguntas;
    /**
     * Son las respuestas
     */
    private ArrayList<Integer> respuestas;
    
    /**
     * Son las calificaciones de cada pregunta.
     */
    private ArrayList<Integer> calificaciones;
    public AnswerRequestAction(int idUsuario, int idPartida, ArrayList<Question> preguntas, ArrayList<Integer> respuestas, ArrayList<Integer> calificaciones){
        this.id = idUsuario;
        this.idPartida = idPartida;
        this.preguntas = preguntas;
        this.respuestas = respuestas;
        this.calificaciones = calificaciones;
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
