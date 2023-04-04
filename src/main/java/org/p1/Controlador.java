package org.p1;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Controlador {
    private static Logger logger = LogManager.getLogger();
    private Modelo modelo;
    private Vista vista;
    public Controlador(Modelo m, Vista v){
        modelo = m;
        vista = v;
    }

    //Metodos para controlar menus
    public void reset(){
        modelo.setArreglo(new int[100]);
        System.out.println("Reset controlador");
        logger.debug("Reset de controlador");
    }
    public void salir(){
        System.exit(0);
    }
    public void arrAgregarElemento(int v){
        modelo.agregarElementoAlArreglo(v);
    }
    public void arrEliminarElemento(){
        modelo.eliminarUltimoElemento();
    }
    public void arrAzar(){
        modelo.arregloAzar();
    }
    public void arrOrdenar(){
        modelo.arregloOrdenar();
        logger.debug("Numeros ordenados");
    }
    public void iniciar(){
        Vista vista = new Vista(modelo);
        vista.setVisible(true);
    }


 }
