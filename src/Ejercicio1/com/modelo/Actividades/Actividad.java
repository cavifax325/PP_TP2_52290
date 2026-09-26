package Ejercicio1.com.modelo.Actividades;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import Ejercicio1.com.modelo.Inscripcion;
import Ejercicio1.com.excepciones.CupoExcedidoException;
import Ejercicio1.com.modelo.*;

public abstract class Actividad {
    protected int id;
    protected String titulo;
    protected int cupoMaximo;
    protected final static int cupoMinimo;
    protected List<Inscripcion> inscripciones = new ArrayList<>();


    static {
        cupoMinimo = 1;
    }

    public Actividad(int id, String titulo, int cupoMaximo) {
        this.id = id;
        this.titulo = titulo;
        this.cupoMaximo = cupoMaximo;
    }
    public Inscripcion inscribir(Estudiante estudiante) throws CupoExcedidoException {

        if(inscripciones.size() >= cupoMaximo){
            throw new CupoExcedidoException("No se pudo inscribir al estudiante "+estudiante.getNombre()+" debido a que no hay cupo");
        }

        Inscripcion inscripcion = new Inscripcion(estudiante, this, LocalDate.now(), "REGISTRADO");
        inscripciones.add(inscripcion);
        return inscripcion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getCupoMaximo() {
        return cupoMaximo;
    }

    public void setCupoMaximo(int cupoMaximo) {
        this.cupoMaximo = cupoMaximo;
    }

    public abstract double calcularCostoMateriales();

    public void mostrarInscripciones() {
        if (inscripciones.isEmpty()) {
            System.out.println("  Sin inscripciones registradas.");
            return;
        }
        System.out.println("   Inscripciones registradas:");
        for (Inscripcion inscripcion : inscripciones) {
            System.out.println("   " + inscripcion.getFecha()
                    +" - "+  inscripcion.getEstado()
                    + " - " + inscripcion.getQuienSeInscribe().getNombre()
                    + " (Legajo: " + inscripcion.getQuienSeInscribe().getLegajo() + ")");
        }
    }
}
