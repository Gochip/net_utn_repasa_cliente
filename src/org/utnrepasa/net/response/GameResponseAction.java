package org.utnrepasa.net.response;

import org.utnrepasa.net.Connection;
import org.utnrepasa.net.ResponseAction;
import org.utnrepasa.net.principal.ControladorCliente;
import org.utnrepasa.net.util.MultiplayerGame;

/**
 *
 * @author Parisi Germán
 */
public class GameResponseAction implements ResponseAction{

    private static final long serialVersionUID = 113;
    private final MultiplayerGame partida;
    public GameResponseAction(MultiplayerGame partida){
        this.partida = partida;
    }
    
    @Override
    public void execute(Connection connection) {
        ControladorCliente controlador = ControladorCliente.getInstancia();
        controlador.recibirDatosPartida(partida);
        connection.close();
    }

}
