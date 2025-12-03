import java.util.Objects;

public class nodoEstado {
    String nombre;
    String capital;
    boolean esServidor;
    String tipoServidor;

    public nodoEstado(String nombre, String capital, boolean esServidor, String tipoServidor) {
        this.nombre = nombre;
        this.capital = capital;
        this.esServidor = esServidor;
        this.tipoServidor = tipoServidor;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        nodoEstado that = (nodoEstado) o;
        return Objects.equals(nombre, that.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }
    
    @Override
    public String toString() {
        return nombre; 
    }
}