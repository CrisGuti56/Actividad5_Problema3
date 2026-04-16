package Observatorio;

public class Observacion implements Comparable<Observacion> {

    private String periodo;
    private double distancia;
    private String unidadDistancia;
    private Ubicacion ubicacion;

    public Observacion(String periodo, double distancia, String unidadDistancia, Ubicacion ubicacion) {
        this.periodo = periodo;
        this.distancia = distancia;
        this.unidadDistancia = unidadDistancia;
        this.ubicacion = ubicacion;
    }

    public String getPeriodo() {
        return periodo;
    }

    public double getDistancia() {
        return distancia;
    }

    public String getUnidadDistancia() {
        return unidadDistancia;
    }

    public Ubicacion getUbicacion() {
        return ubicacion;
    }

    public Desplazamiento obtenerDesplazamiento(Observacion observacionComparada) {

        if (observacionComparada == null) {
            throw new IllegalArgumentException("La observación comparada no puede ser null");
        }

        double lat1 = this.ubicacion.getHemisferioLatitudinal().equalsIgnoreCase("S")
                ? -this.ubicacion.getLatitud()
                : this.ubicacion.getLatitud();

        double lat2 = observacionComparada.getUbicacion().getHemisferioLatitudinal().equalsIgnoreCase("S")
                ? -observacionComparada.getUbicacion().getLatitud()
                : observacionComparada.getUbicacion().getLatitud();

        double lon1 = this.ubicacion.getHemisferioLongitudinal().equalsIgnoreCase("O")
                ? -this.ubicacion.getLongitud()
                : this.ubicacion.getLongitud();

        double lon2 = observacionComparada.getUbicacion().getHemisferioLongitudinal().equalsIgnoreCase("O")
                ? -observacionComparada.getUbicacion().getLongitud()
                : observacionComparada.getUbicacion().getLongitud();

        double deltaLatitud = lat1 - lat2;
        double deltaLongitud = lon1 - lon2;
        double deltaDistancia = this.distancia - observacionComparada.getDistancia();

        return new Desplazamiento(deltaLatitud, deltaLongitud, deltaDistancia);
    }

    @Override
    public int compareTo(Observacion o) {
        return Double.compare(this.distancia, o.distancia);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Observacion o = (Observacion) obj;

        return Double.compare(distancia, o.distancia) == 0 &&
                periodo.equalsIgnoreCase(o.periodo) &&
                unidadDistancia.equalsIgnoreCase(o.unidadDistancia) &&
                ubicacion.equals(o.ubicacion);
    }

    @Override
    public int hashCode() {
        int result = periodo.toLowerCase().hashCode();
        result = 31 * result + Double.hashCode(distancia);
        result = 31 * result + unidadDistancia.toLowerCase().hashCode();
        result = 31 * result + ubicacion.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Observatorio.Observacion:\n" +
                "  Periodo: " + periodo + "\n" +
                "  Distancia: " + distancia + " " + unidadDistancia + "\n" +
                ubicacion;
    }
}
