package Colecciones.Boletin2.Ej2;

import java.time.LocalDateTime;
import java.util.Objects;

public class PaginaWeb {
    // ATRIBUTOS

    private String url;
    private LocalDateTime fecha;

    // CONSTRUCTOR
    public PaginaWeb(String url, LocalDateTime fecha) {
        this.url = url;
        this.fecha = fecha;
    }

    // GETTERS
    public String getUrl() {
        return url;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    // EQUALS & HASHCODE
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof PaginaWeb p)) return false;
        return url.equalsIgnoreCase(p.url) && fecha.equals(p.fecha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(url.toLowerCase(), fecha);
    }

    // TOSTRING
    @Override
    public String toString() {
        return fecha + " - " + url;
    }
}



