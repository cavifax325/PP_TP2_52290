package Ejercicio2.com.modelo.Actividades;
import Ejercicio2.com.modelo.Estudiante;
import Ejercicio2.com.modelo.certificacion.Certificable;

public class Curso extends Actividad implements Certificable {
    private int nivel;

    public Curso(int nivel, int id, String titulo, int cupoMaximo){
        super(id,titulo,cupoMaximo);
        this.nivel = nivel;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    @Override
    public double calcularCostoMateriales(){
        return 0.0;
    }

    @Override
    public String generarCertificado(Estudiante estudiante){
        String mensaje = "La entidad "+ENTIDAD_EMISORA+" certifica que el alumno "+estudiante.getNombre()+" realizo del curso "+getTitulo()+" que tiene un nivel "+getNivel();
        return mensaje;
    }

    @Override
    public String getTipo() {
        return this.getClass().getName();
    }

}
