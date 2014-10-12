package org.utnrepasa.net.response;

import org.utnrepasa.net.Connection;
import org.utnrepasa.net.ResponseAction;
import org.utnrepasa.net.principal.ControladorCliente;
import org.utnrepasa.net.util.MultiplayerGame;

/**
 *
 * @author Parisi Germán
 */
public class AnswerResponseAction implements ResponseAction {

    private static final long serialVersionUID = 109;

    /**
     * Retorna el mismo id de usuario.
     */
    private int id;

    /**
     * Una bandera que indica si se pudo guardar con éxito.
     */
    private boolean exito;

    /**
     * Una bandera que indica si la partida está finalizada.
     */
    private boolean partidaFinalizada;

    /**
     * Datos del estado de la partida.
     */
    private MultiplayerGame partida;

    public AnswerResponseAction(int id, boolean exito, boolean partidaFinalizada, MultiplayerGame partida) {
        this.id = id;
        this.exito = exito;
        this.partidaFinalizada = partidaFinalizada;
        this.partida = partida;
    }
    @Override
    public void execute(Connection connection) {
        ControladorCliente controlador = ControladorCliente.getInstancia();
        controlador.mostrarResumenPartida(partida);
        connection.close();
    }
}
