package Observatorio;

import java.util.ArrayList;
import java.util.List;

public class Prueba {

    public static void main(String[] args) {

        // Creacion de ubicaciones
        Ubicacion ubicacion1 = new Ubicacion(10, "N", 20, "E");
        Ubicacion ubicacion2 = new Ubicacion(15, "N", 25, "E");

        // Creacion de observaciones
        Observacion obs1 = new Observacion("Enero", 4.5, "años luz", ubicacion1);
        Observacion obs2 = new Observacion("Febrero", 4.8, "años luz", ubicacion2);
        Observacion obs3 = new Observacion("Enero", 4.5, "años luz", ubicacion2); // para probar empates

        // Creacion cuerpoCeleste
        CuerpoCeleste estrella = new CuerpoCeleste("Alpha-1", "Gas");

        // Observaciones
        estrella.agregarObservacion(obs1);
        estrella.agregarObservacion(obs2);
        estrella.agregarObservacion(obs3);

        // Mostrar objeto cuerpoceleste
        System.out.println("\n--- CUERPO CELESTE ---");
        System.out.println(estrella);

        // Desplazamiento
        Desplazamiento d = obs1.obtenerDesplazamiento(obs2);
        System.out.println("\n--- DESPLAZAMIENTO ---");
        System.out.println(d);

        // Validacion equals y hashCode
        System.out.println("\n--- PRUEBA equals Y hashCode ---");
        Ubicacion u1 = new Ubicacion(10, "N", 20, "E");
        Ubicacion u2 = new Ubicacion(10, "N", 20, "E");

        System.out.println("Ubicaciones iguales: " + u1.equals(u2));
        System.out.println("HashCodes iguales: " + (u1.hashCode() == u2.hashCode()));

        System.out.println("\n--- VALIDACIÓN DE INTERFACES ---");

        // Comparable (Observacion)
        System.out.println("Comparando obs1 con obs2 (compareTo):");
        int resComparable = obs1.compareTo(obs2);

        if (resComparable < 0) {
            System.out.println("Resultado: obs1 tiene menor prioridad.");
        } else if (resComparable > 0) {
            System.out.println("Resultado: obs2 tiene menor prioridad.");
        } else {
            System.out.println("Resultado: Ambas observaciones son iguales.");
        }

        // Comparator (por periodo)
        ComparadorPorPeriodo comp = new ComparadorPorPeriodo();

        System.out.println("\nComparando obs1 con obs2 (Comparator por periodo):");
        int resComparator = comp.compare(obs1, obs2);

        if (resComparator < 0) {
            System.out.println("Resultado: obs1 ocurre antes.");
        } else if (resComparator > 0) {
            System.out.println("Resultado: obs2 ocurre antes.");
        } else {
            System.out.println("Resultado: Son iguales.");
        }

        // Comparable en CuerpoCeleste
        CuerpoCeleste c2 = new CuerpoCeleste("Beta-2", "Solido");

        System.out.println("\nComparando cuerpos celestes:");
        int resCuerpo = estrella.compareTo(c2);

        if (resCuerpo < 0) {
            System.out.println("Resultado: Alpha-1 va antes.");
        } else if (resCuerpo > 0) {
            System.out.println("Resultado: Beta-2 va antes.");
        } else {
            System.out.println("Resultado: Son iguales.");
        }

        // Ordenamiento
        System.out.println("\n--- ORDENAMIENTO MANUAL (compareTo) ---");

        List<Observacion> lista = estrella.getObservaciones();

        for (int i = 0; i < lista.size() - 1; i++) {
            for (int j = 0; j < lista.size() - i - 1; j++) {

                Observacion o1 = lista.get(j);
                Observacion o2 = lista.get(j + 1);

                if (o1.compareTo(o2) > 0) {
                    lista.set(j, o2);
                    lista.set(j + 1, o1);
                }
            }
        }

        // Mostrar ordenado
        for (Observacion o : lista) {
            System.out.println(o);
        }

        // Ordenamiento por comparator
        System.out.println("\n--- ORDENAMIENTO POR PERIODO (Comparator) ---");

        for (int i = 0; i < lista.size() - 1; i++) {
            for (int j = 0; j < lista.size() - i - 1; j++) {

                Observacion o1 = lista.get(j);
                Observacion o2 = lista.get(j + 1);

                if (comp.compare(o1, o2) > 0) {
                    lista.set(j, o2);
                    lista.set(j + 1, o1);
                }
            }
        }
        for (Observacion o : lista) {
            System.out.println(o);
        }
    }
}