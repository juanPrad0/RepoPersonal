import java.util.*;

public class AlgoritmoServidores {
    public static void main(String[] args) {
        System.out.println("--- Iniciando Red de Servidores CDN México ---");
        grafoPais mexico = crearMexico.crear();
        CDN cdnMexico = crearCND.crear(mexico);
        
        List<nodoEstado> listaEstados = new ArrayList<>(mexico.getPaises());
        listaEstados.sort(Comparator.comparing(n -> n.nombre));

        pokedex referenciaPokedex = new pokedex();
        baseDatos bdTemp = referenciaPokedex.makeBaseDatosPokemon();
        List<String> listaPokemons = new ArrayList<>(bdTemp.getDatos().keySet());
        Collections.sort(listaPokemons);


        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.println("\n================ MENU PRINCIPAL ================");
            System.out.println("1) Buscar Archivo (Simular petición)");
            System.out.println("2) Salir");
            System.out.print("Elige una opción: ");
            
            int opcion;
            try {
                String input = scanner.nextLine();
                opcion = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                opcion = -1;
            }

            switch (opcion) {
                case 1:
                    System.out.println("\n--- Selecciona el Estado (Origen) ---");
                    for (int i = 0; i < listaEstados.size(); i++) {
                        System.out.printf("%2d. %-25s", (i + 1), listaEstados.get(i).nombre);
                        if ((i + 1) % 3 == 0) System.out.println();
                    }
                    System.out.println();

                    int indiceEstado = -1;
                    while (indiceEstado < 1 || indiceEstado > listaEstados.size()) {
                        System.out.print("\nIngresa el número del estado: ");
                        try {
                            indiceEstado = Integer.parseInt(scanner.nextLine());
                        } catch (NumberFormatException e) {
                            System.out.print("¡Número inválido!");
                        }
                    }
                    String nombreEstadoElegido = listaEstados.get(indiceEstado - 1).nombre;

                    System.out.println("\n--- Selecciona el Pokémon a descargar ---");
                    for (int i = 0; i < listaPokemons.size(); i++) {
                        System.out.printf("%2d. %-15s", (i + 1), listaPokemons.get(i));
                        if ((i + 1) % 4 == 0) System.out.println();
                    }
                    System.out.println();

                    int indicePokemon = -1;
                    while (indicePokemon < 1 || indicePokemon > listaPokemons.size()) {
                        System.out.print("\nIngresa el número del Pokémon: ");
                        try {
                            indicePokemon = Integer.parseInt(scanner.nextLine());
                        } catch (NumberFormatException e) {
                            System.out.print("¡Número inválido!");
                        }
                    }
                    String nombrePokemonElegido = listaPokemons.get(indicePokemon - 1);


                    System.out.println("\n>> Iniciando búsqueda de " + nombrePokemonElegido + " desde " + nombreEstadoElegido + "...");
                    cdnMexico.solicitarArchivo(nombreEstadoElegido, nombrePokemonElegido);

                    break;

                case 2:
                    System.out.println("Cerrando sistema...");
                    continuar = false;
                    break;

                default:
                    System.out.println(">> Opción no válida. Intenta de nuevo.");
            }
        }
        
        scanner.close();
    }
}