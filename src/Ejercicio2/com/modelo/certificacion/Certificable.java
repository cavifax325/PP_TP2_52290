package Ejercicio2.com.modelo.certificacion;
import Ejercicio2.com.modelo.*;

public interface Certificable {
    final String ENTIDAD_EMISORA = "UTN - FRM";

    String generarCertificado(Estudiante estudiante);
}
