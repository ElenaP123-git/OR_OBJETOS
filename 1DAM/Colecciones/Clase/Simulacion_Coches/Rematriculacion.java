package Colecciones.Clase.Simulacion_Coches;

import java.time.LocalDate;

public class Rematriculacion {

    //atributos
    private String vin;
    private String matriculaInicial;
    private String matriculaFinal;
    private LocalDate fechaRematriculacion;

    //constructor
    public Rematriculacion(String vin, String matriculaInicial, String matriculaFinal, LocalDate fechaRematriculacion) {
        this.vin = vin;
        this.matriculaInicial = matriculaInicial;
        this.matriculaFinal = matriculaFinal;
        this.fechaRematriculacion = fechaRematriculacion;
    }

    //getters y setters
    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getMatriculaInicial() {
        return matriculaInicial;
    }
    public void setMatriculaInicial(String matriculaInicial) {
        this.matriculaInicial = matriculaInicial;
    }

    public String getMatriculaFinal() {
        return matriculaFinal;
    }
    public void setMatriculaFinal(String matriculaFinal) {
        this.matriculaFinal = matriculaFinal;
    }

    public LocalDate getFechaRematriculacion() {
        return fechaRematriculacion;
    }
    public void setFechaRematriculacion(LocalDate fechaRematriculacion) {
        this.fechaRematriculacion = fechaRematriculacion;
    }

    //toString
    @Override
    public String toString() {
        return "Rematriculacion{" +
                "vin='" + vin + '\'' +
                ", matriculaInicial='" + matriculaInicial + '\'' +
                ", matriculaFinal='" + matriculaFinal + '\'' +
                ", fechaRematriculacion=" + fechaRematriculacion +
                '}';
    }
}

