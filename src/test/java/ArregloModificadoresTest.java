import org.junit.jupiter.api.Test;
import org.p1.Modelo;

import static org.junit.jupiter.api.Assertions.*;

public class ArregloModificadoresTest {

    @Test
    void GetterDebeDevolverArreglo(){
        Modelo modelo = new Modelo();
        int[] arreglo = new int[]{1,2,3,4};
        modelo.setArreglo(arreglo);

        int[] resultado = modelo.getArreglo();

        assertArrayEquals(arreglo, resultado);
    }

    @Test
    void ModificarElementoArreglo(){
        Modelo modelo = new Modelo();
        modelo.setElemento(1, 10);
        modelo.setElemento(3, 16);

        int resultado = modelo.getElemento(1);
        int segundoResultado = modelo.getElemento(3);
        assertEquals(10, resultado);
        assertEquals(16, segundoResultado);
    }


}
