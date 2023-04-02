package org.p1;

import javax.naming.ldap.Control;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Vista extends JFrame implements ActionListener {

    private Modelo modelo;
    private Controlador controlador;
    private JMenuBar menuBar;
    private JMenu menuArchivo, menuArreglo;
    private JMenuItem itemReset, itemSalir, itemArrAgregar, itemArrEliminar, itemArrAzar, itemArrOrdenar;

    public Vista(Modelo m){
        modelo = m;
        controlador = new Controlador(modelo, this);
        iniciarComponentes();
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
            controlador.arrAgregarElemento();
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
}
