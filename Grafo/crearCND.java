import java.util.Map;

public class crearCND {
    public static CDN crear(grafoPais pais) {
        Map<nodoEstado, baseDatos> servidoresPrincipales = new java.util.HashMap<>();
        Map<nodoEstado, baseDatos> servidoresSecundarios = new java.util.HashMap<>();

        pokedex generadorPokedex = new pokedex();
        baseDatos bdPokemon = generadorPokedex.makeBaseDatosPokemon();

        for (nodoEstado nodo : pais.getPaises()) {
            if (nodo.esServidor) {
                if (nodo.tipoServidor.equals("Principal")) {
                    servidoresPrincipales.put(nodo, bdPokemon);
                } else if (nodo.tipoServidor.equals("Secundario")) {
                    servidoresSecundarios.put(nodo, new baseDatos());
                }
            }
        }
        return new CDN(servidoresSecundarios, servidoresPrincipales, pais);
    }
}