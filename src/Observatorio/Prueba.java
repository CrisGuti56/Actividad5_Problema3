package Observatorio;

import java.util.Collections;

public class Prueba {

    public static void main(String[] args) {

        Ubicacion ubicacion1 = new Ubicacion(10, "N", 20, "E");
        Ubicacion ubicacion2 = new Ubicacion(15, "N", 25, "E");

        Observacion obs1 = new Observacion("Enero", 4.5, "años luz", ubicacion1);
        Observacion obs2 = new Observacion("Febrero", 4.8, "años luz", ubicacion2);

        CuerpoCeleste estrella = new CuerpoCeleste("Alpha-1", "Gas");

        estrella.agregarObservacion(obs1);
        estrella.agregarObservacion(obs2);

        // Orden usando Comparable (por distancia)
        Collections.sort(estrella.getObservaciones());

        // Orden usando Comparator (por periodo)
        Collections.sort(estrella.getObservaciones(), new ComparadorPorPeriodo());

        Desplazamiento d = obs1.obtenerDesplazamiento(obs2);

        System.out.println(estrella);
        System.out.println(d);

        System.out.println("==== PRUEBAS ====");

        // equals y hashCode
        Ubicacion u1 = new Ubicacion(10, "N", 20, "E");
        Ubicacion u2 = new Ubicacion(10, "N", 20, "E");

        System.out.println("Ubicaciones iguales: " + u1.equals(u2));
        System.out.println("HashCodes iguales: " + (u1.hashCode() == u2.hashCode()));

        // Comparable (orden por distancia)
        Collections.sort(estrella.getObservaciones());
        System.out.println("\nOrden por distancia:");
        for (Observacion o : estrella.getObservaciones()) {
            System.out.println(o.getPeriodo() + " - " + o.getDistancia());
        }

        // Comparator (orden por periodo)
        Collections.sort(estrella.getObservaciones(), new ComparadorPorPeriodo());
        System.out.println("\nOrden por periodo:");
        for (Observacion o : estrella.getObservaciones()) {
            System.out.println(o.getPeriodo());
        }

    }
}