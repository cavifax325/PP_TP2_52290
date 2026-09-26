package Ejercicio1.com.modelo;

import java.time.LocalDate;
import Ejercicio1.com.modelo.Actividades.*;
public class Inscripcion {
    private LocalDate fecha;
    private String estado;

    //clase asociativa
    private Actividad seInscribeEn;
    private Estudiante quienSeInscribe;

    public Inscripcion(Estudiante estudiante, Actividad actividadEnCual, LocalDate fecha, String estado){
        this.quienSeInscribe = estudiante;
        this.seInscribeEn = actividadEnCual;
        this.fecha = fecha;
        this.estado = estado;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Actividad getSeInscribeEn() {
        return seInscribeEn;
    }

    public void setSeInscribeEn(Actividad seInscribeEn) {
        this.seInscribeEn = seInscribeEn;
    }

    public Estudiante getQuienSeInscribe() {
        return quienSeInscribe;
    }

    public void setQuienSeInscribe(Estudiante quienSeInscribe) {
        this.quienSeInscribe = quienSeInscribe;
    }
}
