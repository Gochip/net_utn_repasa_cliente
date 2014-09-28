package org.utnrepasa.net.request;

import org.utnrepasa.net.Connection;
import org.utnrepasa.net.RequestAction;

/**
 * Es una solicitud del cliente de preguntas. Esta acción la solicita el cliente
 * y el servidor la ejecuta.
 *
 * @author Parisi Germán
 * @version 1.0
 */
public class QuestionsRequestAction implements RequestAction {

    private static final long serialVersionUID = 8;
    private int cantidad;
    private int id;
    private int idPartida;

    /**
     *
     * @param count Es la cantidad de preguntas que solicita.
     */
    public QuestionsRequestAction(int id, int count, int idPartida) {
        if (count > 0) {
            this.cantidad = count;
            this.id = id;
            this.idPartida = idPartida;
        } else {
            throw new RuntimeException("Argumento count inválido: " + count);
        }
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
