package org.p1;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
        int[] arregloVacio = new int[100];
        modelo.setContador(0);
        modelo.setArreglo(arregloVacio);
    }
    public void salir(){
        System.exit(0);
    }
    public void arrAgregarElemento(){
        modelo.agregarElemento(10);
        modelo.agregarElemento(102);
        modelo.agregarElemento(1123);
        modelo.agregarElemento(123);
        modelo.agregarElemento(12);
        modelo.agregarElemento(13);
        modelo.agregarElemento(14);
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
