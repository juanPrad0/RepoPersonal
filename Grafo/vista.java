import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.net.URL;
import javax.imageio.ImageIO;
import java.io.IOException;

public class vista {
    public static void mostrar(String estadoCliente, String servidorUsado, double distancia, String urlImagen) {
        JFrame ventana = new JFrame("Resultado de Solicitud CDN");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLayout(new BorderLayout(10, 10));



        JPanel panelInfo = new JPanel();
        panelInfo.setLayout(new GridLayout(3, 1, 5, 5));
        panelInfo.setBorder(BorderFactory.createEmptyBorder(15, 15, 5, 15));

        JLabel lblCliente = new JLabel("<html><b style='font-size:14px'>Cliente:</b> " + estadoCliente + "</html>");
        JLabel lblServidor = new JLabel("<html><b style='font-size:14px'>Servidor:</b> " + servidorUsado + "</html>");
        String distanciaFormateada = String.format("%.2f km", distancia);
        JLabel lblDistancia = new JLabel("<html><b style='font-size:14px'>Distancia:</b> " + distanciaFormateada + "</html>");

        panelInfo.add(lblCliente);
        panelInfo.add(lblServidor);
        panelInfo.add(lblDistancia);



        JLabel etiquetaImagen = new JLabel();
        try {
            URL url = new URL(urlImagen);
            BufferedImage imagen = ImageIO.read(url);
            etiquetaImagen.setIcon(new ImageIcon(imagen));
            etiquetaImagen.setHorizontalAlignment(SwingConstants.CENTER);

        } catch (IOException e) {

            etiquetaImagen.setText("Error al cargar la imagen (verifique conexión a internet).");
            etiquetaImagen.setHorizontalAlignment(SwingConstants.CENTER);
            etiquetaImagen.setForeground(Color.RED);
            System.out.println("Error: " + e.getMessage());
        }
        etiquetaImagen.setBorder(BorderFactory.createEmptyBorder(0, 0, 15, 0));

        ventana.add(panelInfo, BorderLayout.NORTH);
        ventana.add(etiquetaImagen, BorderLayout.CENTER);


        ventana.pack();
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
    }
}