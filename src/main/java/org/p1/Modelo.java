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
    public void agregarElemento(int valor) throws ArrayIndexOutOfBoundsException{
        boolean fueAgregado = false;
        for (int i = 0; i < arreglo.length; i++) {
            if(arreglo[i] == 0){
                arreglo[i] = valor;
                fueAgregado = true;
                break;
            }
        }
        if(!fueAgregado){
            throw new ArrayIndexOutOfBoundsException("El arreglo está lleno");
        }
    }

    public void eliminarUltimoElemento(){
        arreglo[arreglo.length-1] = 0;
    }


}
