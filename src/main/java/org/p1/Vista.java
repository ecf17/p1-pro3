package org.p1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Arrays;

public class Vista extends JFrame implements ActionListener, PropertyChangeListener {
    private Modelo modelo;
    private Controlador controlador;
    private JMenuBar menuBar;
    private JMenu menuArchivo, menuArreglo;
    private JMenuItem itemReset, itemSalir, itemArrAgregar, itemArrEliminar, itemArrAzar, itemArrOrdenar;
    private Panel panelBarras;
    private PopupAgregar popupAgregar;

    public Vista(Modelo m){
        modelo = m;
        controlador = new Controlador(modelo, this);
        iniciarComponentes();
        modelo.addObserver(this);
        popupAgregar = new PopupAgregar(this, m);
    }

    private void iniciarComponentes(){
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

        itemReset.addActionListener(this);
        itemSalir.addActionListener(this);
        itemArrAgregar.addActionListener(this);
        itemArrEliminar.addActionListener(this);
        itemArrAzar.addActionListener(this);
        itemArrOrdenar.addActionListener(this);

        panelBarras = new Panel(modelo.getArreglo());
        add(panelBarras, BorderLayout.CENTER);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource()==itemReset){
            controlador.reset();

        }
        if(e.getSource()==itemSalir){
            controlador.salir();
        }

        //Metodos de arreglos
        if(e.getSource()==itemArrAgregar){
            popupAgregar.setVisible(true);
        }
        if(e.getSource()==itemArrEliminar){
            controlador.arrEliminarElemento();
        }
        if(e.getSource()==itemArrAzar){
            controlador.arrAzar();
        }
        if(e.getSource()==itemArrOrdenar){
            controlador.arrOrdenar();
        }
    }
    public void actualizarPantallas() {
        this.revalidate();
        this.repaint();

        System.out.println("Arreglo en modelo: " + Arrays.toString(modelo.getArreglo()));
        panelBarras.actualizarPanel();
        System.out.println("Arreglo en panel: " + Arrays.toString(panelBarras.getArreglo()));
    }
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("nuevoArreglo")) {
            panelBarras = new Panel(modelo.getArreglo());
            setContentPane(panelBarras);
            actualizarPantallas();
            System.out.println("Repintando");
        }
        if (evt.getPropertyName().equals("ordenarArreglo") || evt.getPropertyName().equals("agregar")|| evt.getPropertyName().equals("eliminadoElemento")) {
            actualizarPantallas();
        }

    }
}
