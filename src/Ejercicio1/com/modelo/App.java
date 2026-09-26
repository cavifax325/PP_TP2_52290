package Ejercicio1.com.modelo;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.excepciones.CupoExcedidoException;
import com.modelo.Actividades.*;

public class App {
    public static void main(String[] args) {
        boolean gratuito;
        double costoBase;
        String respSeguir;
        int cont = 1;
        int idSala = 1;
        Scanner lector = new Scanner(System.in);

        /* Se crean estudiantes } */
        List<Estudiante> estudiantes = new ArrayList<>();
        System.out.println("Registro de estudiantes");
        System.out.println("Desea agregar un estudiante?");
        String respCrearE = lector.nextLine().trim().toLowerCase();
        if((respCrearE.equals("si"))||(respCrearE.equals("s"))) {
            do {
                System.out.println("Ingrese el legajo del estudiante");
                String legajo = lector.nextLine();
                System.out.println("Ingrese nombre y apellido del estudiante");
                String nombre = lector.nextLine();
                Estudiante nuevoEstu = new Estudiante(legajo, nombre);
                estudiantes.add(nuevoEstu);
                System.out.println("Desea agregar otro estudiante?");
                respSeguir = lector.nextLine().trim().toLowerCase();
            } while ((respSeguir.equals("si")) || (respSeguir.equals("s")));
        }

        System.out.println("Creacion de eventos");
        System.out.println("Desea crear un evento?");
        String respCrear = lector.nextLine().trim().toLowerCase();
        if((respCrear.equals("si"))||(respCrear.equals("s"))) {
            do{
                String id = "EVT-"+cont;
                System.out.println("Ingrese el titulo del evento");
                String titulo = lector.nextLine();
                System.out.println("El evento sera gratuito?");
                String respGratis = lector.nextLine().trim().toLowerCase();
                if((respGratis.equals("si"))||respGratis.equals("s")) {
                    gratuito = true;
                    costoBase = 0.0;
                }
                else{
                    gratuito = false;
                    System.out.println("Ingrese costo base");
                    costoBase = lector.nextDouble();
                    lector.nextLine();//se arregla lo del enter para seguir agregando eventos
                }

                EventoUniversitario evento = new EventoUniversitario(id,titulo,costoBase,gratuito);//se crea evento

                System.out.println("Ingrese el nombre de la sala donde se hara el evento");
                String nombreSala = lector.nextLine();
                Sala salaAsignada = new Sala(idSala, nombreSala);
                idSala++;
                evento.asignarSala(salaAsignada);

                System.out.println("Registro de actividades");
                int idAct = 1;
                boolean seguir = true;
                while(seguir) {
                    System.out.println("Ingrese titulo de la actividad");
                    String tituloAct = lector.nextLine();
                    System.out.println("Ingrese el cupo maximo de estudiante en la actividad");
                    int cupoMax = lector.nextInt();
                    lector.nextLine();
                    System.out.println("Ingrese el tipo de l actividad");
                    String tipoAct = lector.nextLine().trim().toLowerCase();
                    evento.crearActividad(idAct,tituloAct,cupoMax,tipoAct);
                    System.out.println("El id de la actividad "+ tituloAct+" es "+idAct);
                    System.out.println("Desea agregar mas actividades para el evento "+evento.getTitulo()+" ");
                    String respSeguirAct = lector.nextLine().trim().toLowerCase();
                    seguir = (respSeguirAct.equals("s")||respSeguirAct.equals("si")||respSeguirAct.equals("sí"))? true : false;
                    idAct++;
                }

                try {
                    System.out.println("Inscripcion de estudiante en actividad");

                    boolean contIns = true;
                    while (contIns) {
                        System.out.println("Ingrese el legajo del estudiante a insribir: ");
                        String legagoInsc = lector.nextLine();
                        System.out.println("Ingrese el  id de la actividad donde se inscribira: ");
                        int idActIns = lector.nextInt();
                        lector.nextLine();
                        for (Estudiante estudiante : estudiantes) {
                            if (estudiante.getLegajo().equals(legagoInsc)) {
                                evento.getActividades().get(--idActIns).inscribir(estudiante);
                            }
                        }

                        System.out.println("Desea realizar otra inscripcion?");
                        String respSegIns = lector.nextLine();
                        contIns = (respSegIns.equals("si") || respSegIns.equals("s") || respSegIns.equals("sí")) ? true : false;
                    }
                }catch (CupoExcedidoException e){
                    System.out.println("Error al inscribir:" + e.getMessage());
                }

                try{
                    evento.persistirEvento();

                    EventoUniversitario copiaEventoArchivo = evento.recuperarEvento(evento.getId());


                } catch (FileNotFoundException e){
                    System.out.println("Error al buscar el archivo: "+e.getMessage());
                } catch (IOException e){
                    System.out.println("Se produjo un error de entrada/salida: "+e.getMessage());
                } catch (ClassNotFoundException e){
                    System.out.println("No se encontro la clase: "+e.getMessage());
                }

                System.out.println("Datos del evento");
                evento.mostrarDatos();
                EventoUniversitario copiaEvento = new EventoUniversitario(evento);
                copiaEvento.mostrarDatos();
                System.out.println("En total hay "+ EventoUniversitario.getCantEventos()+" eventos creados");
                System.out.println("Desea seguir agregando otro evento?");
                respSeguir = lector.nextLine().trim().toLowerCase();
                cont++;
            }while ((respSeguir.equals("si"))||(respSeguir.equals("s")));



        }
        else{
            System.out.println("Fin del programa");
        }

    }
}
