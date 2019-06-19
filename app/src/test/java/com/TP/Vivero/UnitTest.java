package com.TP.Vivero;

import com.TP.Vivero.Object.Planta;

import org.junit.Test;
import static org.junit.Assert.*;

public class UnitTest {

    @Test
    public void test_Planta_param_isNull(){

        Planta plantIdisNull = new Planta(null);

        assertNull(plantIdisNull.getID());

        /**
         * Deberia comprobar qué pasa si alguno de los parametros que se le pasa al constructor de Planta es null.
         * Salta un error?
         */
    }

    @Test
    public void test_Etapa_param_isNull(){

        /**
         * Lo mismo que arriba pero con la clase Etapa
         */
    }
}
