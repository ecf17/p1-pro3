package org.p1;

import javax.swing.*;

public class Vista extends JFrame {

    private JMenuBar menuBar;
    private JMenu menuArchivo, menuArreglo;
    private JMenuItem itemReset, itemSalir, itemArrAgregar, itemArrEliminar, itemArrAzar, itemArrOrdenar;

    public Vista(){
        //Config frame
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        //Creación barra menu
        menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        //Creación menu archivo arreglo y añadido al menuBar
        menuArchivo = new JMenu("Archivo");
        menuArreglo = new JMenu("Arreglo");
        menuBar.add(menuArchivo);
        menuBar.add(menuArreglo);

        //Crear y añadir items a menu archivo
        itemReset = new JMenuItem("Reset");
        itemSalir = new JMenuItem("Salir");
        menuArchivo.add(itemReset);
        menuArchivo.add(itemSalir);

        //Crear y añadir items a menu arreglo
        itemArrAgregar = new JMenuItem("Agregar");
        itemArrEliminar = new JMenuItem("Eliminar");
        itemArrAzar = new JMenuItem("Azar");
        itemArrOrdenar = new JMenuItem("Ordenar");
        menuArreglo.add(itemArrAgregar);
        menuArreglo.add(itemArrEliminar);
        menuArreglo.add(itemArrAzar);
        menuArreglo.add(itemArrOrdenar);
    }
}
