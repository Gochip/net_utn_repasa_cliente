package org.utnrepasa.net.principal;

import java.util.ArrayList;
import org.utnrepasa.net.Client;
import org.utnrepasa.net.request.CreationDataRequestAction;
import org.utnrepasa.net.request.GamesRequestAction;
import org.utnrepasa.net.request.LoginRequestAction;
import org.utnrepasa.net.request.RegisterRequestAction;
import org.utnrepasa.net.request.UsersRequestAction;
import org.utnrepasa.net.util.Matter;
import org.utnrepasa.net.util.MultiplayerGame;
import org.utnrepasa.net.util.User;

/**
 *
 * @author Parisi Germán
 */
public class ControladorCliente {

    private static ControladorCliente me;
    private VentanaRegistrar vr;
    private User usuario;

    private ControladorCliente() {
    }

    public static ControladorCliente getInstancia() {
        if (me == null) {
            me = new ControladorCliente();
        }
        return me;
    }

    // PARTIDAS
    public void registrarse(String nombreUsuario, String clave) {
        Client client = new Client();
        client.send(new RegisterRequestAction(nombreUsuario, clave));
    }

    public void respuestaRegistro(boolean correcto) {
        VentanaRegistrar vr = VentanaRegistrar.getInstancia();
        if (correcto) {
            vr.setVisible(false);
            VentanaIniciarSesion vis = VentanaIniciarSesion.getInstancia();
            vis.setVisible(true);
        } else {
            vr.establecerMensajeError("Ese usuario ya existe.");
        }
    }

    // INICIO DE SESIÓN
    public void iniciarSesion(String nombreUsuario, String clave) {
        Client client = new Client();
        client.send(new LoginRequestAction(nombreUsuario, clave));
    }

    public void respuestaIniciarSesion(boolean correcto, User us) {
        if (correcto) {
            VentanaIniciarSesion.getInstancia().setVisible(false);
            setUsuario(us);
            VentanaMenuPrincipal vmp = VentanaMenuPrincipal.getInstancia();
            vmp.setVisible(true);
        } else {
            VentanaIniciarSesion.getInstancia().establecerMensajeError("El inicio de sesión falló.");
        }
    }

    private void setUsuario(User us) {
        this.usuario = us;
    }

    public User getUsuario() {
        return this.usuario;
    }

    // PARTIDAS
    public void solicitarPartidas() {
        if (usuario != null) {
            Client client = new Client();
            client.send(new GamesRequestAction(usuario.getId()));
        } else {
            System.out.println("El usuario es nulo");
        }
    }

    public void recibirPartidas(ArrayList<MultiplayerGame> partidasEnJuego) {
        VentanaMenuPrincipal.getInstancia().setVisible(false);
        VentanaListaPartidas vlp = VentanaListaPartidas.getInstancia();
        vlp.recibirPartidasEnJuego(partidasEnJuego);
        vlp.setVisible(true);
    }

    // CREACIÓN PARTIDA
    public void abrirVentanaCrearPartida() {
        Client client = new Client();
        client.send(new CreationDataRequestAction(this.usuario.getId()));
    }
    
    public void recibirDatosCreacionPartida(ArrayList<Matter> materias){
        VentanaListaPartidas.getInstancia().setVisible(false);
        VentanaCreacionPartida vcp = VentanaCreacionPartida.getInstancia();
        for(Matter mat : materias){
            vcp.agregarMateria(mat);
        }
        vcp.refrescarListaMaterias();
        vcp.setVisible(true);
    }
    
    // OBTENER USUARIOS
    public void solicitarUsuarios(){
        Client client = new Client();
        client.send(new UsersRequestAction(this.usuario.getId(), 4));
    }
    
    public void recibirUsuarios(ArrayList<User> usuarios){
        VentanaCreacionPartida.getInstancia().setVisible(false);
        VentanaInvitaciones vi = VentanaInvitaciones.getInstancia();
        vi.recibirUsuarios(usuarios);
        vi.setVisible(true);
    }
    
    public static void main(String args[]) {
        boolean saltarRegistro = true;
        if (!saltarRegistro) {
            VentanaRegistrar vr = VentanaRegistrar.getInstancia();
            vr.setVisible(true);
        } else {
            VentanaIniciarSesion vis = VentanaIniciarSesion.getInstancia();
            vis.setVisible(true);
        }
    }
}
