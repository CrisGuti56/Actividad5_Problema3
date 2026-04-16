package Observatorio;

public class Ubicacion {
    private double latitud;
    private String hemisferioLatitudinal;
    private double longitud;
    private String hemisferioLongitudinal;

    public Ubicacion(double latitud, String hemisferioLatitudinal, double longitud, String hemisferioLongitudinal) {
        this.latitud = latitud;
        this.hemisferioLatitudinal = hemisferioLatitudinal;
        this.longitud = longitud;
        this.hemisferioLongitudinal = hemisferioLongitudinal;
    }

    public double getLatitud() {
        return latitud;
    }

    public String getHemisferioLatitudinal() {
        return hemisferioLatitudinal;
    }

    public double getLongitud() {
        return longitud;
    }

    public String getHemisferioLongitudinal() {
        return hemisferioLongitudinal;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Ubicacion u = (Ubicacion) obj;

        return Double.compare(latitud, u.latitud) == 0 &&
                Double.compare(longitud, u.longitud) == 0 &&
                hemisferioLatitudinal.equalsIgnoreCase(u.hemisferioLatitudinal) &&
                hemisferioLongitudinal.equalsIgnoreCase(u.hemisferioLongitudinal);
    }

    @Override
    public int hashCode() {
        int result = Double.hashCode(latitud);
        result = 31 * result + Double.hashCode(longitud);
        result = 31 * result + hemisferioLatitudinal.toLowerCase().hashCode();
        result = 31 * result + hemisferioLongitudinal.toLowerCase().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Observatorio.Ubicacion:\n" +
                "  Latitud: " + latitud + "° " + hemisferioLatitudinal + "\n" +
                "  Longitud: " + longitud + "° " + hemisferioLongitudinal + "\n";
    }
}
