package org.p1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Panel extends JPanel implements PropertyChangeListener {
    private static Logger logger = LogManager.getLogger();
    private int[] datos;

    public Panel(int[] arr){
        datos = arr;
        iniciarComponentes();
    }

    private void iniciarComponentes(){
        setPreferredSize(new Dimension(600, 200));
        Border border = BorderFactory.createLineBorder(Color.BLACK);
        setBorder(border);
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        // ancho de cada barra
        int anchoDisponible = getWidth() / datos.length - 1;
        int alturaDisponible = getHeight();

        // Dibujar cada barra
        for (int i = 0; i < datos.length; i++) {
            int altura = (datos[i] * alturaDisponible) / datos.length; // altura de la barra
            int x = (i * getWidth()) / datos.length; // posición x de la barra
            int y = alturaDisponible - altura; // posición y de la barra
            g.setColor(Color.BLACK); // color de la barra
            g.fillRect(x, y, anchoDisponible, altura); // dibujar la barra
        }
        this.repaint();
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        this.repaint();
        System.out.println("REPINTADO");
        logger.debug("repintar");
    }
}
