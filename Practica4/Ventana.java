package Practica4;
import javax.swing.*;

import java.awt.event.*;

public class Ventana extends JFrame {
    JButton boton;
    Mensajes controlador;
    Punto primero;
    Punto segundo;
    Double distancia;
    
    public Ventana(Mensajes controlador,Punto primero,Punto segundo,Double distancia) {
        this.controlador = controlador;
        this.primero = primero;
        this.segundo = segundo;
        this.distancia = distancia;

        setTitle("Ejemplo");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        boton = new JButton("Haz clic aqui");
        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, controlador.mensajePuntoA() + primero.toString() + "\n" + controlador.mensajePuntoB() + segundo.toString() + "\n" + controlador.mensajeDistancia() + distancia);
            }
        });

        add(boton);
    }
}