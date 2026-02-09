package Orientacion_Obj.Boletin1.DatosClima;
import java.time.LocalDate;

public class RegistroDiario {

    //atributos

    Datos datos;
    LocalDate fecha;
    String lugarRecogida;

    //constructor

    public RegistroDiario(Datos datos, LocalDate fecha, String lugarRecogida) {
        this.datos = datos;
        this.fecha = fecha;
        this.lugarRecogida = lugarRecogida;
    }

    //métodos

    public double calcularTemperaturaMediaDia() {
        return datos.calculo_temp_media();
    }

    @Override
    public String toString() {
        return "RegistroDiario{" +
                "datos=" + datos +
                ", fecha=" + fecha +
                ", lugarRecogida='" + lugarRecogida + '\'' +
                '}';
    }
}

