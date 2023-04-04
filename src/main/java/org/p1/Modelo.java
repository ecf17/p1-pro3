package org.p1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Arrays;

public class Modelo {
    private static Logger logger = LogManager.getLogger();
    private int[] arreglo;
    private int contador;

    private PropertyChangeSupport observado;

    public Modelo(){
        arreglo = new int[100];
        contador = 0;
        observado = new PropertyChangeSupport(this);
    }

    public void addObserver(PropertyChangeListener o) {observado.addPropertyChangeListener(o);}

    //Metodos para modificar arreglo
    public int[] getArreglo() {
        logger.debug("Obteniendo el arreglo: " + Arrays.toString(arreglo));
        return arreglo;
    }

    public int getElemento(int posicion){
        logger.debug("Obteniendo el elemento " + posicion + " con valor "+arreglo[posicion]);
        return arreglo[posicion];
    }
    public void setArreglo(int[] arregloNuevo) {
        logger.debug("Colocando el valor del arreglo a " + Arrays.toString(arregloNuevo));
        this.arreglo = arregloNuevo;
        observado.firePropertyChange("nuevoArreglo",null, arregloNuevo);
    }

    public void setElemento(int posicion, int valor){
        logger.debug("Colocando el elemento " + posicion + " con valor "+ valor);
        arreglo[posicion] = valor;
    }

    public void setContador(int contador) {
        logger.debug("Colocando el valor del contador en: " + contador);
        this.contador = contador;
    }

    public void contadorElementos(int[] arr){
        logger.debug("Contando los valores dentro del array");
        int numeros = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] > 0){
                numeros++;
            }
        }
        setContador(numeros);
    }

    public void agregarElementoAlArreglo(int valor) throws ArrayIndexOutOfBoundsException{
        logger.debug("Agregando el elemento con valor " + valor + " a la ultima posicion del array");
        boolean fueAgregado = false;
        for (int i = 0; i < arreglo.length; i++) {
            if(arreglo[i] == 0){
                arreglo[i] = valor;
                fueAgregado = true;
                observado.firePropertyChange("agregar",true, false);
                break;
            }
        }
        if(!fueAgregado){
            throw new ArrayIndexOutOfBoundsException("El arreglo está lleno");
        }
        contadorElementos(arreglo);
    }
    public void eliminarUltimoElemento() throws ArrayIndexOutOfBoundsException{
        logger.debug("Eliminando el ultimo elemento del array");
        if(contador > 0){
            arreglo[contador-1] = 0;
            contadorElementos(arreglo);
        }else{
            throw new ArrayIndexOutOfBoundsException("El arreglo no tiene menos posiciones");
        }
        observado.firePropertyChange("eliminadoElemento",null, arreglo);
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
            }
            System.out.println(Arrays.toString(arreglo));
        }
        public int numeroRandom(){
            return (int)(Math.random() * 100) + 1;
        }
    public void arregloOrdenar(){
        ordenarInsercion(arreglo);
        observado.firePropertyChange("ordenarArreglo", true, false);
    }
        public void ordenarInsercion(int[] arr) {
            logger.debug("Ordenando el array");
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
        }
}