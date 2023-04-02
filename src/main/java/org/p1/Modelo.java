package org.p1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Modelo {
    private static Logger logger = LogManager.getLogger();
    private int[] arreglo;
    private int contador;

    public Modelo(){
        arreglo = new int[100];
        contador = 0;
    }

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

    public void setContador(int contador) {
        this.contador = contador;
    }

    public void contadorElementos(int[] arr){
        int numeros = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] > 0){
                numeros++;
            }
        }
        setContador(numeros);
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
        contadorElementos(arreglo);
    }
    public void eliminarUltimoElemento() throws ArrayIndexOutOfBoundsException{
        if(contador > 0){
            arreglo[contador-1] = 0;
            contadorElementos(arreglo);
        }else{
            throw new ArrayIndexOutOfBoundsException("El arreglo no tiene menos posiciones");
        }
    }
    public void arregloAzar(){
        rellenarArreglo(arreglo);
        contadorElementos(arreglo);
    }
        public void rellenarArreglo(int[] arr){
            logger.debug("Rellenado al azar");
            System.out.println("AZAR================");
            for (int i = 0; i < arr.length; i++) {
                arr[i] = numeroRandom();
                System.out.println(arr[i]);
            }
        }
        public int numeroRandom(){
            return (int)(Math.random() * 100) + 1;
        }
    public void arregloOrdenar(){
        ordenarInsercion(arreglo);
    }
        public void ordenarInsercion(int[] arr) {
            //Empieza desde el segundo elemento porque el primero esta ordenado
            for (int i = 1; i < contador; i++) {
                int valorComparar = arr[i];
                //indice anterior
                int j = i-1;
                //Se mueven los elementos mayores a la derecha de donde se insertará el elemento actual
                while ((j > -1) && (arr[j] > valorComparar)) {
                    arr[j + 1] = arr[j];
                    j--;
                }
                //Inserta el elemento actual en la posicion correcta
                arr[j + 1] = valorComparar;
            }
            System.out.println("============================ORDENADO");
            for (int i = 0; i < arr.length; i++) {
                System.out.println(arr[i]);
            }
        }
}