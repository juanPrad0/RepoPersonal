import java.util.Map;

public class baseDatos {
    private Map<String,String> datos;

    public baseDatos() {
        this.datos = new java.util.HashMap<>();
    }

    public void addDato(String nombre, String dato) {
        datos.put(nombre, dato);
    }
    public Map<String,String> getDatos() {
        return datos;
    }
    public String getDato(String nombre) {
        return datos.get(nombre);
    }
}
