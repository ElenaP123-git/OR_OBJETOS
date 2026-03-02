package Orientacion_Obj.BoletinFinal.Boletin9.Interfc2;

import java.time.LocalDate;

public interface Alimento {
    void setCaducidad(LocalDate fecha);
    LocalDate getCaducidad();
    int getCalorias();
}


