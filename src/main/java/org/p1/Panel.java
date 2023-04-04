package org.p1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel{
    private static Logger logger = LogManager.getLogger();
    private int[] datos;
    private Modelo modelo;

    public int[] getArreglo(){
        return datos;
    }

    public Panel(int[] arr){
        modelo = new Modelo();
        datos = arr;
        setPreferredSize(new Dimension(600, 200));
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        // ancho de cada barra
        Dimension dimensionDisponible = obtenerDimensiones();
        int anchoDisponible = dimensionDisponible.width;
        int alturaDisponible = dimensionDisponible.height;

        // Dibujar cada barra
        for (int i = 0; i < datos.length; i++) {
            int altura = (datos[i] * alturaDisponible) / datos.length; // altura de la barra
            int x = (i * getWidth()) / datos.length; // posición x de la barra
            int y = alturaDisponible - altura; // posición y de la barra
            g.setColor(new Color(128, 0, 128)); // color de la barra
            g.fillRect(x, y, anchoDisponible, altura); // dibujar la barra
        }
        this.repaint();
    }
    public Dimension obtenerDimensiones(){
        int anchoDisponible = getWidth() / datos.length - 1;
        int alturaDisponible = getHeight();
        return new Dimension(anchoDisponible, alturaDisponible);
    }
    public void actualizarPanel(){
        this.revalidate();
        this.repaint();
    }
}
