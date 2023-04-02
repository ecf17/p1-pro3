package org.p1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static Logger logger = LogManager.getRootLogger();

    public static void main(String[] args) {

        Modelo modelo = new Modelo();

        Vista vista = new Vista(modelo);

        Controlador controlador = new Controlador(modelo, vista);
        controlador.iniciar();

    }
}