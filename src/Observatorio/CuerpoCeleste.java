package Observatorio;

import java.util.ArrayList;
import java.util.List;

public class CuerpoCeleste implements Comparable<CuerpoCeleste> {

    private String nombre;
    private String composicion;
    private List<Observacion> observaciones;

    public CuerpoCeleste(String nombre, String composicion) {
        this.nombre = nombre;
        this.composicion = composicion;
        this.observaciones = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getComposicion() {
        return composicion;
    }

    public List<Observacion> getObservaciones() {
        return observaciones;
    }

    public void agregarObservacion(Observacion observacion) {
        if (observacion == null) {
            throw new IllegalArgumentException("La observación no puede ser null");
        }
        observaciones.add(observacion);
    }

    @Override
    public int compareTo(CuerpoCeleste o) {
        return this.nombre.compareToIgnoreCase(o.nombre);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        CuerpoCeleste c = (CuerpoCeleste) obj;
        return nombre.equalsIgnoreCase(c.nombre);
    }

    @Override
    public int hashCode() {
        return nombre.toLowerCase().hashCode();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Cuerpo Celeste:\n");
        sb.append("  Nombre: ").append(nombre).append("\n");
        sb.append("  Composición: ").append(composicion).append("\n");
        sb.append("  Observaciones:\n");

        for (Observacion o : observaciones) {
            sb.append("  -------------------\n");
            sb.append(o).append("\n");
        }

        return sb.toString();
    }
}