import java.util.*;

public class grafoPais {
    private Map<nodoEstado, Map<nodoEstado, Double>> adyacencia;

    public grafoPais() {
        this.adyacencia = new HashMap<>();
    }

    public void agregarCiudad(nodoEstado ciudad) {
        adyacencia.putIfAbsent(ciudad, new HashMap<>());
    }

    public void agregarArista(nodoEstado origen, nodoEstado destino, double distanciaKm) {
        agregarCiudad(origen);
        agregarCiudad(destino);
        adyacencia.get(origen).put(destino, distanciaKm);
        adyacencia.get(destino).put(origen, distanciaKm);
    }

    public nodoEstado buscarCiudad(String nombre) {
        for (nodoEstado ciudad : adyacencia.keySet()) {
            if (ciudad.nombre.equalsIgnoreCase(nombre)) {
                return ciudad;
            }
        }
        return null;
    }

    public Set<nodoEstado> getPaises() {
        return adyacencia.keySet();
    }

    public double rutaMasCortaDijkstra(String nombreOrigen, String nombreDestino) {
        nodoEstado origen = buscarCiudad(nombreOrigen);
        nodoEstado destino = buscarCiudad(nombreDestino);

        if (origen == null || destino == null) {
            System.out.println("Alguna de las ciudades no existe.");
            return -1;
        }

        Map<nodoEstado, Double> distancias = new HashMap<>();
        Map<nodoEstado, nodoEstado> padres = new HashMap<>();
        PriorityQueue<nodoEstado> colaPrioridad = new PriorityQueue<>(Comparator.comparingDouble(distancias::get));
        Set<nodoEstado> visitados = new HashSet<>();

        for (nodoEstado nodo : adyacencia.keySet()) {
            distancias.put(nodo, Double.MAX_VALUE);
        }
        distancias.put(origen, 0.0);
        colaPrioridad.add(origen);

        while (!colaPrioridad.isEmpty()) {
            nodoEstado actual = colaPrioridad.poll();

            if (visitados.contains(actual)) continue;
            visitados.add(actual);

            if (actual.equals(destino)) break;

            for (Map.Entry<nodoEstado, Double> vecinoEntry : adyacencia.get(actual).entrySet()) {
                nodoEstado vecino = vecinoEntry.getKey();
                double pesoArista = vecinoEntry.getValue();

                if (!visitados.contains(vecino)) {
                    double nuevaDistancia = distancias.get(actual) + pesoArista;
                    
                    if (nuevaDistancia < distancias.get(vecino)) {
                        distancias.put(vecino, nuevaDistancia);
                        padres.put(vecino, actual);
                        colaPrioridad.remove(vecino); 
                        colaPrioridad.add(vecino);
                    }
                }
            }
        }

        if (distancias.get(destino) == Double.MAX_VALUE) {
            System.out.println("No hay camino entre " + nombreOrigen + " y " + nombreDestino);
            return -1;
        }

        List<nodoEstado> ruta = new ArrayList<>();
        nodoEstado paso = destino;
        while (paso != null) {
            ruta.add(paso);
            paso = padres.get(paso);
        }
        Collections.reverse(ruta);

        System.out.println("--- Ruta Optima (Dijkstra) ---");
        System.out.println("Origen: " + nombreOrigen + " -> Destino: " + nombreDestino);
        for (int i = 0; i < ruta.size(); i++) {
            System.out.print(ruta.get(i).nombre);
            if (i < ruta.size() - 1) System.out.print(" -> ");
        }
        System.out.println("\nDistancia Total: " + distancias.get(destino) + " km");

        return distancias.get(destino);
    }
}