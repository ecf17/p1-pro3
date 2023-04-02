import org.junit.jupiter.api.Test;
import org.p1.Controlador;
import org.p1.Modelo;
import org.p1.Vista;
import static org.junit.jupiter.api.Assertions.*;

public class ControladorArreglo {

    @Test
    void ResetDeberiaDarArregloDeCeros(){
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
}
