package org.p1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PopupAgregar extends JFrame {

    private JSpinner campoDato;
    private JLabel lblCampo;
    private JButton btnAceptar;

    private Vista vista;
    private Modelo modelo;
    private Controlador controlador;

    public PopupAgregar(Vista v, Modelo m){
        vista = v;
        modelo = m;
        controlador = new Controlador(m,v);
        iniciarComponentes();
        btnAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controlador.arrAgregarElemento(obtenerDato());
            }
        });
    }

    public void iniciarComponentes(){
        setSize(250, 110);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setTitle("Agregar número");
        setLayout(new FlowLayout());

        lblCampo = new JLabel("Agregar");
        campoDato = new JSpinner(new SpinnerNumberModel(1, 1, 100, 1));

        btnAceptar = new JButton("Aceptar");

        add(lblCampo);
        add(campoDato);
        add(btnAceptar);
    }

    public int obtenerDato(){
        int dato = 0;
        if(campoDato != null){
            dato = (int) campoDato.getValue();
        }
        return dato;
    }

}
