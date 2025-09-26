package Practica4;
import java.util.ArrayList;

public class Practica4 {
    public static void main(String[] args) {
        ArrayList<Integer> l = new ArrayList<Integer>();
        for(String valores:args){
            l.add(Integer.parseInt(valores));
        }
        Punto punto1 = new Punto(l.get(0),l.get(1));
        Punto punto2 = new Punto(l.get(2),l.get(3));
        Double distancia = Math.sqrt(Math.pow(l.get(2)-l.get(0), 2)+Math.pow(l.get(3)-l.get(1), 2));
        Mensajes controlador = new Mensajes();

        Ventana ventana = new Ventana(controlador,punto1,punto2,distancia);
        ventana.setVisible(true);
    }
}