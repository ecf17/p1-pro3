import org.junit.jupiter.api.Test;
import org.p1.Modelo;

import static org.junit.jupiter.api.Assertions.*;

public class ArregloModificadoresTest {

    @Test
    void getterDebeDevolverArreglo(){
        Modelo modelo = new Modelo();
        int[] arreglo = new int[]{1,2,3,4};
        modelo.setArreglo(arreglo);

        int[] resultado = modelo.getArreglo();

        assertArrayEquals(arreglo, resultado);
    }

    @Test
    void modificarElementoArreglo(){
        Modelo modelo = new Modelo();
        modelo.setElemento(1, 10);
        modelo.setElemento(3, 16);

        int resultado = modelo.getElemento(1);
        int segundoResultado = modelo.getElemento(3);
        assertEquals(10, resultado);
        assertEquals(16, segundoResultado);
    }

    @Test
    void agregarElementoArreglo(){
        Modelo modelo = new Modelo();
        modelo.agregarElemento(10);
        modelo.agregarElemento(11);
        modelo.agregarElemento(12);

        int[] resultado = modelo.getArreglo();

        assertEquals(10, resultado[0]);
        assertEquals(11, resultado[1]);
        assertEquals(12, resultado[2]);
    }

    @Test
    void eliminarUltimoElementoArreglo(){
        Modelo modelo = new Modelo();
        modelo.setElemento(99, 111);
        assertEquals(111, modelo.getElemento(99));
        modelo.eliminarUltimoElemento();
        assertEquals(0, modelo.getElemento(99));
    }


}
