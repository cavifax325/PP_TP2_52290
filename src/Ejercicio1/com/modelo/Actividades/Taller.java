package Ejercicio1.com.modelo.Actividades;

public class Taller extends Actividad{
    private boolean requiereNotebook;

    public Taller(int id, String titulo, int cupoMaximo, boolean requiereNotebook){
        super(id,titulo,cupoMaximo);
        this.requiereNotebook = requiereNotebook;
    }

    public void setRequiereNotebook(boolean requiereNotebook){
        this.requiereNotebook = requiereNotebook;
    }

    public boolean getRequiereNotebook(){
        return requiereNotebook;
    }

    @Override
    public double calcularCostoMateriales(){
        if(requiereNotebook)
            return 5000.0;
        else
            return 2000.0;
    }
}
