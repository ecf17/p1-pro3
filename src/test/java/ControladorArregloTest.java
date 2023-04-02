import org.junit.jupiter.api.Test;
import org.p1.Controlador;
import org.p1.Modelo;
import org.p1.Vista;
import static org.junit.jupiter.api.Assertions.*;

public class ControladorArreglo {

    @Test
    void resetDeberiaDarArregloDeCeros(){
        int[] arrayVacio = new int[100];
        Modelo modelo = new Modelo();
        Vista vista = new Vista(modelo);
        modelo.agregarElemento(1);
        modelo.agregarElemento(2);
        System.out.println(modelo.getElemento(0));
        System.out.println(modelo.getElemento(1));
        Controlador controlador = new Controlador(modelo, vista);
        controlador.reset();
        int[] resultado = modelo.getArreglo();

        assertArrayEquals(arrayVacio, resultado);
    }

    @Test
    void arregloDeberiaEstarLleno(){
        Modelo modelo = new Modelo();
        Vista vista = new Vista(modelo);
        Controlador controlador = new Controlador(modelo, vista);
        controlador.arrAzar();
        int[] arreglo = modelo.getArreglo();
        for (int i = 0; i < arreglo.length; i++) {
            assertTrue(arreglo[i] <= 100 && arreglo[i] > 0);
        }
    }

    @Test
    void deberiaEliminarElUltimo(){
        Modelo modelo = new Modelo();
        Vista vista = new Vista(modelo);
        Controlador controlador = new Controlador(modelo, vista);
        modelo.arregloAzar();
        int[] arreglo = modelo.getArreglo();
        controlador.arrEliminarElemento();
        assertEquals(0, modelo.getElemento(arreglo.length-1));
    }

    @Test
    void deberiaOrdenarArreglo(){
        Modelo modelo = new Modelo();
        Vista vista = new Vista(modelo);
        Controlador controlador = new Controlador(modelo, vista);
        modelo.agregarElemento(111);
        modelo.agregarElemento(200);
        modelo.agregarElemento(99);

        controlador.arrOrdenar();
        int resultado = modelo.getElemento(0);
        int resultadoDos = modelo.getElemento(1);
        int resultadoTres = modelo.getElemento(2);

        assertEquals(99,resultado);
        assertEquals(111,resultadoDos);
        assertEquals(200,resultadoTres);
    }


}
