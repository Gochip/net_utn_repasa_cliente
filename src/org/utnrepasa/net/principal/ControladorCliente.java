package org.utnrepasa.net.principal;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import org.utnrepasa.net.Client;
import org.utnrepasa.net.request.AcceptInvitationRequestAction;
import org.utnrepasa.net.request.CreateMultiPlayerRequestAction;
import org.utnrepasa.net.request.CreationDataRequestAction;
import org.utnrepasa.net.request.GamesRequestAction;
import org.utnrepasa.net.request.LoginRequestAction;
import org.utnrepasa.net.request.QuestionsRequestAction;
import org.utnrepasa.net.request.RegisterRequestAction;
import org.utnrepasa.net.request.SearchUsersRequestAction;
import org.utnrepasa.net.request.UsersRequestAction;
import org.utnrepasa.net.util.Course;
import org.utnrepasa.net.util.MultiplayerGame;
import org.utnrepasa.net.util.Question;
import org.utnrepasa.net.util.User;

/**
 *
 * @author Parisi Germán
 */
public class ControladorCliente {

    private static ControladorCliente me;
    private VentanaRegistrar vr;
    private User usuario;
    private int cantidadRondas;
    private int preguntasPorRondas = 5;
    private ArrayList<Course> configuracionPartida;

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

    public void recibirDatosCreacionPartida(ArrayList<Course> materias) {
        VentanaListaPartidas.getInstancia().setVisible(false);
        VentanaConfiguracionPartida vcp = VentanaConfiguracionPartida.getInstancia();
        for (Course mat : materias) {
            vcp.agregarMateria(mat);
        }
        vcp.refrescarListaMaterias();
        vcp.setVisible(true);
    }

    // OBTENER USUARIOS
    public void establecerConfigracionCreacionPartida(ArrayList<Course> config, int cantidadRondas) {
        this.configuracionPartida = config;
        this.cantidadRondas = cantidadRondas;
    }

    public void solicitarUsuarios() {
        Client client = new Client();
        client.send(new UsersRequestAction(this.usuario.getId(), 4));
    }

    public void solicitarUsuarios(String patron) {
        Client client = new Client();
        client.send(new SearchUsersRequestAction(this.usuario.getId(), 4, patron));
    }

    public void recibirUsuarios(ArrayList<User> usuarios) {
        VentanaConfiguracionPartida vcp = VentanaConfiguracionPartida.getInstancia();
        VentanaInvitaciones vi = VentanaInvitaciones.getInstancia();
        if (vcp.isVisible()) {
            VentanaConfiguracionPartida.getInstancia().setVisible(false);
            vi.recibirUsuarios(usuarios);
            vi.setVisible(true);
        } else if (vi.isVisible()) {
            vi.recibirUsuarios(usuarios);
        }
    }

    // CREAR PARTIDA
    public void solicitudCreacionPartida(ArrayList<User> invitados) {
        Client client = new Client();
        client.send(new CreateMultiPlayerRequestAction(usuario.getId(), invitados, cantidadRondas, preguntasPorRondas, configuracionPartida));
    }

    public void respuestaCreacionPartida(boolean creacionCorrecta) {
        VentanaInvitaciones.getInstancia().setVisible(false);
        if (creacionCorrecta) {
            JOptionPane.showMessageDialog(null, "Se ha creado la partida con éxito");
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo crear la partida");
        }
        Client client = new Client();
        client.send(new GamesRequestAction(this.usuario.getId()));
    }

    // ACEPTAR INVITACIÓN
    public void aceptarInvitación(int idPartida) {
        Client client = new Client();
        client.send(new AcceptInvitationRequestAction(this.usuario.getId(), idPartida));
    }

    public void recibirRespuestaAceptarInvitacion(boolean aceptado, int idPartida) {
        if (aceptado) {
            solicitarPreguntas(idPartida);
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo aceptar la invitación.");
        }
    }

    // SOLICITAR PREGUNTAS
    public void solicitarPreguntas(int idPartida) {
        int cantidad = 5;
        Client client = new Client();
        client.send(new QuestionsRequestAction(usuario.getId(), cantidad, idPartida));
    }

    public void recibirPreguntas(ArrayList<Question> preguntas, int idPartida) {
        VentanaPregunta vp = VentanaPregunta.getInstancia();
        vp.setPregunta(preguntas.get(0));
        vp.setVisible(true);
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
