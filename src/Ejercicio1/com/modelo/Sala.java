package Ejercicio1.com.modelo;

public class Sala {
    private int id;
    private String nombre;
    private EventoUniversitario evento;

    public Sala(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void mostrarInscripciones (){

    }
}
