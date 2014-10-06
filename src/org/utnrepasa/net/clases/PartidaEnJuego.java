package org.utnrepasa.net.clases;

import java.util.ArrayList;
import org.utnrepasa.net.util.Course;
import org.utnrepasa.net.util.MultiplayerGame;
import org.utnrepasa.net.util.Question;

/**
 *
 * @author Parisi Germán
 */
public class PartidaEnJuego {

    private MultiplayerGame partida;
    private ArrayList<Question> preguntas;
    private ArrayList<Integer> respuestas;
    private ArrayList<Integer> calificaciones;
    private int cantidadRondas;
    private int preguntasPorRondas;
    private ArrayList<Course> configuracionPartida;
    private int numeroPreguntaContestando;

    public PartidaEnJuego() {
        this.preguntas = new ArrayList<>();
        this.respuestas = new ArrayList<>();
        this.calificaciones = new ArrayList<>();
        this.configuracionPartida = new ArrayList<>();
    }

    public void addPregunta(Question pregunta) {
        this.preguntas.add(pregunta);
    }

    public void addRespuesta(int respuesta) {
        this.respuestas.add(respuesta);
    }

    public void addCalificaciones(int calificacion) {
        this.calificaciones.add(calificacion);
    }

    public void addConfiguracionPartida(Course config) {
        this.configuracionPartida.add(config);
    }

    public ArrayList<Question> getPreguntas() {
        return preguntas;
    }

    public ArrayList<Integer> getRespuestas() {
        return respuestas;
    }

    public ArrayList<Integer> getCalificaciones() {
        return calificaciones;
    }

    public int getCantidadRondas() {
        return cantidadRondas;
    }

    public int getPreguntasPorRondas() {
        return preguntasPorRondas;
    }

    public ArrayList<Course> getConfiguracionPartida() {
        return configuracionPartida;
    }

    public int getNumeroPreguntaContestando(){
        return this.numeroPreguntaContestando;
    }
    
    public void setPreguntas(ArrayList<Question> preguntas) {
        this.preguntas = preguntas;
    }

    public void setRespuestas(ArrayList<Integer> respuestas) {
        this.respuestas = respuestas;
    }

    public void setCalificaciones(ArrayList<Integer> calificaciones) {
        this.calificaciones = calificaciones;
    }

    public void setCantidadRondas(int cantidadRondas) {
        this.cantidadRondas = cantidadRondas;
    }

    public void setPreguntasPorRondas(int preguntasPorRondas) {
        this.preguntasPorRondas = preguntasPorRondas;
    }

    public void setConfiguracionPartida(ArrayList<Course> configuracionPartida) {
        this.configuracionPartida = configuracionPartida;
    }
    
    public void setNumeroPreguntaContestando(int n){
        this.numeroPreguntaContestando = n;
    }

}
