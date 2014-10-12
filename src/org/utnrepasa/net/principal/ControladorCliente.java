package org.utnrepasa.net.principal;

import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.utnrepasa.net.Client;
import org.utnrepasa.net.clases.PartidaEnJuego;
import org.utnrepasa.net.request.AcceptInvitationRequestAction;
import org.utnrepasa.net.request.AnswerRequestAction;
import org.utnrepasa.net.request.CreateMultiPlayerRequestAction;
import org.utnrepasa.net.request.CreationDataRequestAction;
import org.utnrepasa.net.request.GameRequestAction;
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
    private JFrame actual;
    private User usuario;
    private HashMap<Integer, PartidaEnJuego> partidasEnJuego;

    private ControladorCliente() {
        this.partidasEnJuego = new HashMap<>();
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
            vmp.setNombreUsuario(us.getName());
            vmp.setVisible(true);
        } else {
            VentanaIniciarSesion.getInstancia().establecerMensajeError("El inicio de sesión falló.");
        }
    }

    public void abrirMenuPrincipal(JFrame anterior) {
        anterior.setVisible(false);
        VentanaMenuPrincipal vmp = VentanaMenuPrincipal.getInstancia();
        vmp.setNombreUsuario(this.usuario.getName());
        vmp.setVisible(true);
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

    public void recibirPartidas(ArrayList<MultiplayerGame> partidas) {
        VentanaMenuPrincipal.getInstancia().setVisible(false);
        VentanaListaPartidas vlp = VentanaListaPartidas.getInstancia();
        vlp.setNombreUsuario(usuario.getName());
        vlp.recibirPartidasEnJuego(partidas);
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

    // OBTENER USUARIOS Y CREACIÓN PARTIDA
    public void establecerConfiguracionCreacionPartida(ArrayList<Course> config, int cantidadRondas) {
        CreandoPartida.configuracionPartida = config;
        CreandoPartida.cantidadRondas = cantidadRondas;
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
            vcp.setVisible(false);
            vi.recibirUsuarios(usuarios);
            vi.setVisible(true);
        } else if (vi.isVisible()) {
            vi.recibirUsuarios(usuarios);
        }
    }

    // CREAR PARTIDA
    public void solicitudCreacionPartida(ArrayList<User> invitados) {
        Client client = new Client();
        client.send(new CreateMultiPlayerRequestAction(usuario.getId(), invitados, CreandoPartida.cantidadRondas, CreandoPartida.preguntasPorRondas, CreandoPartida.configuracionPartida));
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
            PartidaEnJuego partida = new PartidaEnJuego();
            partidasEnJuego.put(idPartida, partida);
            solicitarPreguntas(idPartida);
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo aceptar la invitación.");
        }
    }

    // SOLICITAR PREGUNTAS
    public void solicitarPreguntas(int idPartida) {
        int cantidadPreguntas = 5;
        Client client = new Client();
        PartidaEnJuego partida = new PartidaEnJuego();
        partida.setCantidadRondas(5);
        partida.setNumeroPreguntaContestando(0);
        partida.setPreguntasPorRondas(cantidadPreguntas);
        partidasEnJuego.put(idPartida, partida);
        client.send(new QuestionsRequestAction(usuario.getId(), cantidadPreguntas, idPartida));
    }

    public void recibirPreguntas(ArrayList<Question> preguntas, int idPartida) {
        PartidaEnJuego partida = this.partidasEnJuego.get(idPartida);
        if (partida != null) {
            if (partida.getPreguntasPorRondas() == preguntas.size()) {
                partida.setNumeroPreguntaContestando(partida.getNumeroPreguntaContestando() + 1);
                partida.setPreguntas(preguntas);
                VentanaPregunta vp = VentanaPregunta.getInstancia();
                vp.setIdPartida(idPartida);
                vp.setNumeroPreguntasContestando(partida.getNumeroPreguntaContestando());
                vp.setPregunta(preguntas.get(partida.getNumeroPreguntaContestando() - 1));
                vp.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Lo siento pero no quedan preguntas en el servidor");
            }
        }
    }

    public void registrarRespuesta(int idPartida, int pregunta, int respuesta) {
        PartidaEnJuego partida = this.partidasEnJuego.get(idPartida);
        if (partida != null) {
            partida.addRespuesta(respuesta);
            partida.addCalificaciones(1);
        } else {
            System.out.println("partida nula en el met registrarRespuesta");
        }
    }

    public void siguientePregunta(int idPartida) {
        PartidaEnJuego partida = this.partidasEnJuego.get(idPartida);
        if (partida.getPreguntasPorRondas() > partida.getNumeroPreguntaContestando()) {
            partida.setNumeroPreguntaContestando(partida.getNumeroPreguntaContestando() + 1);
            ArrayList<Question> preguntas = partida.getPreguntas();
            VentanaPregunta vp = VentanaPregunta.getInstancia();
            vp.setIdPartida(idPartida);
            vp.setNumeroPreguntasContestando(partida.getNumeroPreguntaContestando());
            vp.setPregunta(preguntas.get(partida.getNumeroPreguntaContestando() - 1));
            vp.setVisible(true);
        } else {
            VentanaPregunta vp = VentanaPregunta.getInstancia();
            vp.setVisible(false);
            JOptionPane.showMessageDialog(null, "Ronda finalizada");
            Client client = new Client();
            MultiplayerGame mg = partida.getMultiplayerGame();
            if (mg != null) {
                client.send(new AnswerRequestAction(usuario.getId(), idPartida, partida.getMultiplayerGame().getCurrentRound(), partida.getPreguntas(), partida.getRespuestas(), partida.getCalificaciones()));
            } else {
                client.send(new AnswerRequestAction(usuario.getId(), idPartida, 1, partida.getPreguntas(), partida.getRespuestas(), partida.getCalificaciones()));
            }
        }
    }

    public void mostrarResumenPartida(MultiplayerGame mg) {
        VentanaMostrarResumenPartida vmp = VentanaMostrarResumenPartida.getInstancia(mg);
        PartidaEnJuego pj = this.partidasEnJuego.get(mg.getId());
        if (pj != null) {
            pj.setMultiplayerGame(mg);
            vmp.cambiarPartida(mg);
            vmp.setVisible(true);
        } else {
            vmp.cambiarPartida(mg);
            vmp.setVisible(true);
        }
    }

    public void solicitarDatosPartida(int idPartida) {
        Client client = new Client();
        client.send(new GameRequestAction(this.usuario.getId(), idPartida));
    }

    public void recibirDatosPartida(MultiplayerGame mg) {
        VentanaListaPartidas vlp = VentanaListaPartidas.getInstancia();
        vlp.setVisible(false);
        mostrarResumenPartida(mg);
    }

    public void iniciar() {
        boolean saltarRegistro = true;
        if (!saltarRegistro) {
            VentanaRegistrar vr = VentanaRegistrar.getInstancia();
            this.actual = vr;
            vr.setVisible(true);
        } else {
            VentanaIniciarSesion vis = VentanaIniciarSesion.getInstancia();
            this.actual = vis;
            vis.setVisible(true);
        }
    }

    public static void main(String args[]) {
        ControladorCliente controlador = ControladorCliente.getInstancia();
        controlador.iniciar();
    }

}

class CreandoPartida {

    public static int cantidadRondas;
    public static int preguntasPorRondas = 5;
    public static ArrayList<Course> configuracionPartida;
}
