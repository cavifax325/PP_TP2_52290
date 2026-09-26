package Ejercicio3.com.modelo;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import Ejercicio3.com.modelo.Actividades.Actividad;
import Ejercicio3.com.modelo.Actividades.*;

public class EventoUniversitario implements Serializable {
    private final String id;
    private String titulo;
    private double costoBase;
    private boolean gratuito;
    private static int cantEventos;

    //composicion
    private Sala salaAsignada;
    //agregacion
    private List<Actividad> actividadComponen;

    static{
        cantEventos = 0;
    }

    public EventoUniversitario(String id, String titulo, double costoBase, boolean gratuito)//constructor
    {
        this.id = id;
        this.titulo = titulo;
        this.costoBase = costoBase;
        this.gratuito = gratuito;
        this.actividadComponen = new ArrayList<>();//composicion
        cantEventos++;
    }

    public String getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public double getCostoBase() {
        return costoBase;
    }

    public boolean isGratuito() {
        return gratuito;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setCostoBase(double costoBase) {
        this.costoBase = costoBase;
    }

    public void setGratuito(boolean gratuito) {
        this.gratuito = gratuito;
    }

    public EventoUniversitario(EventoUniversitario otro){
        this.id = otro.id + "-COPIA";
        this.titulo = otro.titulo;
        this.costoBase = otro.costoBase;
        this.gratuito = otro.gratuito;
        this.salaAsignada = otro.salaAsignada;
        this.actividadComponen = new ArrayList<>(otro.actividadComponen);
    }

    public double costoEstimado(){
        double costoFinal = costoBase;
        for(Actividad actividad : actividadComponen) {
            costoFinal = costoFinal + actividad.calcularCostoMateriales();
        }
        return costoFinal * 1.21;
    }

    public void asignarSala(Sala sala){//agregacion
        this.salaAsignada = sala;
    }

    public Sala getSala(){
        return salaAsignada;
    }

    public void crearActividad(int id, String titulo, int cupo,String tipoAct){
        Scanner lector = new Scanner(System.in);
        switch (tipoAct){
         case "charla":{
             System.out.println("ingrese el nombre del disertante");
             String disertante = lector.nextLine();
             Charla charla = new Charla(id, titulo,cupo,disertante);
             actividadComponen.add(charla);
             break;
         }
         case "taller":{
             System.out.println("El taller necesita notebook?");
             String neceNote = lector.nextLine().trim().toLowerCase();
             boolean respNote = (neceNote.equals("s")||neceNote.equals("si")||neceNote.equals("sí")? true : false);
             Taller taller = new Taller(id,titulo,cupo,respNote);
             actividadComponen.add(taller);
             break;
         }
         case "curso":{
             System.out.println("Ingrese el nivel del curso");
             int nivel = lector.nextInt();
             Curso curso = new Curso(nivel,id, titulo,cupo);
             actividadComponen.add(curso);
             break;
         }
         default:
             System.out.println("Tipo de actividad no valida");
             break;
        }
    }

    public List<Actividad> getActividades() {
        return Collections.unmodifiableList(actividadComponen);
    }

    public void mostrarDatos(){
        System.out.println("Codigo del evento: "+id);
        System.out.println("Evento universitario: "+titulo);
        if(gratuito){
            System.out.println("Costo: es gratuito");
        }
        else{
            System.out.println("Costo estimado: "+costoEstimado());
        }

        if (getSala() != null) {
            System.out.println("Sala donde se realizara es: " + getSala().getNombre());
        } else {
            System.out.println("Sala donde se realizara es: Sin asignar");
        }

        System.out.println("Las actividades son: ");
        for(Actividad actividad : actividadComponen){
            System.out.println("- "+actividad.getTitulo()+"(id: "+actividad.getId()+")"+"con un cupo maximo de "+actividad.getCupoMaximo());
            actividad.mostrarInscripciones();
        }
        System.out.println("=====================================");
    }

    public static int getCantEventos() {
        return cantEventos;
    }

    public boolean persistirEvento() throws IOException {//serializar
        String nombreArchivo = "evento_"+this.id + ".txt";
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nombreArchivo))){
            oos.writeObject(this);
            return true;
        }
    }

    public EventoUniversitario recuperarEvento(String id) throws IOException, ClassNotFoundException{
        String nombreArchivo = "evento_"+this.id+".txt";
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nombreArchivo))){
            return (EventoUniversitario) ois.readObject();
        }
    }

    public <T extends Actividad> List<T> filtrarActividadesPorTipo(Class<T> tipo){
        List<T> resultado = new ArrayList<>();

        for (Actividad actividad : actividadComponen) {
            if (tipo.isInstance(actividad)) {
                resultado.add(tipo.cast(actividad));
            }
        }

        return resultado;
    }

    public double calcularCostoMateriales(List<? extends Actividad> actividades) {
        double total = 0.0;

        for (Actividad actividad : actividades) {
            total += actividad.calcularCostoMateriales();
        }

        return total;
    }


}