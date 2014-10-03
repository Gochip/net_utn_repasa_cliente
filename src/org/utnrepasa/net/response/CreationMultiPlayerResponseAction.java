package org.utnrepasa.net.response;

import org.utnrepasa.net.Connection;
import org.utnrepasa.net.ResponseAction;
import org.utnrepasa.net.principal.ControladorCliente;

/**
 *
 * @author Parisi Germán
 * @version 1.0
 */
public class CreationMultiPlayerResponseAction implements ResponseAction {

    private static final long serialVersionUID = 103;
    /**
     * Este atributo indica si la partida fue creada con éxito.
     */
    private boolean creacionCorrecta;
    /**
     * Este atributo no es muy útil pero el servidor lo devuelve por seguridad.
     * Para saber que el que está recibiendo este objeto es realmente el jugador
     * correspondiente.
     */
    private int idUsuario;

    public CreationMultiPlayerResponseAction(int idUsuario, boolean creacionCorrecta) {
        this.idUsuario = idUsuario;
        this.creacionCorrecta = creacionCorrecta;
    }

    @Override
    public void execute(Connection connection) {
        ControladorCliente controlador = ControladorCliente.getInstancia();
        if (idUsuario == controlador.getUsuario().getId()) {
            controlador.respuestaCreacionPartida(creacionCorrecta);
        }else{
            // Algo pasó... El servidor me tiró un objeto que no me pertenece.
        }
        connection.close();
    }
}
