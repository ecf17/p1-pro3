package org.p1;

public class Modelo {

    int[] arreglo = new int [100];

    //Metodos para modificar arreglo
    public int[] getArreglo() {
        return arreglo;
    }

    public int getElemento(int posicion){
        return arreglo[posicion];
    }

    public void setArreglo(int[] arreglo) {
        this.arreglo = arreglo;
    }

    public void setElemento(int posicion, int valor){
        arreglo[posicion] = valor;
    }


}
