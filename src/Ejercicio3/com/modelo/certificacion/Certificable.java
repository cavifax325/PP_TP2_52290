package Ejercicio3.com.modelo.certificacion;
import Ejercicio3.com.modelo.*;

public interface Certificable {
    final String ENTIDAD_EMISORA = "UTN - FRM";

    String generarCertificado(Estudiante estudiante);
}
