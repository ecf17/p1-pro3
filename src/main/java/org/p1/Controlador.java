package org.p1;


public class Controlador {
    private Modelo modelo;
    private Vista vista;
    public Controlador(Modelo m, Vista v){
        modelo = m;
        vista = v;
    }

    //Metodos para controlar menus
    public void salir(){
        System.exit(0);
    }
    public void arrAgregarElemento(){
        modelo.agregarElemento(10);
    }
    public void arrEliminarElemento(){
        modelo.setElemento(-1, 0);
        System.out.println("Se ha eliminado");
    }

    public void iniciar(){
        Vista vista = new Vista(modelo);
        vista.setVisible(true);
    }
}
