package Ejercicio3.com.modelo.Actividades;

import Ejercicio3.com.modelo.Estudiante;
import Ejercicio3.com.modelo.certificacion.Certificable;

public class Taller extends Actividad implements Certificable {
    private boolean requiereNotebook;

    public Taller(int id, String titulo, int cupoMaximo, boolean requiereNotebook) {
        super(id, titulo, cupoMaximo);
        this.requiereNotebook = requiereNotebook;
    }

    public void setRequiereNotebook(boolean requiereNotebook) {
        this.requiereNotebook = requiereNotebook;
    }

    public boolean getRequiereNotebook() {
        return requiereNotebook;
    }

    @Override
    public String getTipo() {
        return this.getClass().getName();
    }

    @Override
    public double calcularCostoMateriales() {
        if (requiereNotebook)
            return 5000.0;
        else
            return 2000.0;
    }

    @Override
    public String generarCertificado(Estudiante estudiante) {
        String mensaje = "La entidad " + ENTIDAD_EMISORA + " certifica que el estudiante" + estudiante.getNombre() + " hizo el taller " + getTitulo();
        return mensaje;
    }
}


