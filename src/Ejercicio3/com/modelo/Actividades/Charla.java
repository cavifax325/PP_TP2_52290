package Ejercicio3.com.modelo.Actividades;

public class Charla extends Actividad{
    private String disertante;

    public Charla(int id, String titulo, int cupoMaximo,String disertante){
        super(id, titulo, cupoMaximo);
        this.disertante = disertante;
    }

    public void setDisertante(String disertante){
        this.disertante = disertante;
    }

    public String getDisertante(){
        return disertante;
    }

    @Override
    public double calcularCostoMateriales(){
        return 0.0;
    }

    @Override
    public String getTipo() {
        return this.getClass().getName();
    }
}
