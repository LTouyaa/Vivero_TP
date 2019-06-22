package com.TP.Vivero;

import android.provider.ContactsContract;
import android.support.test.runner.AndroidJUnit4;

import com.TP.Vivero.Model.DatabaseHandler;
import com.TP.Vivero.Object.Etapa;
import com.TP.Vivero.Object.Planta;

import static android.support.test.InstrumentationRegistry.getTargetContext;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;

/**
 * RESUMEN DE ASSERT:
 * assertNotNull: Testeo que el obj. que paso por parametro no sea null.
 * assertTrue: Testeo que el objeto sea true
 * assertEqual: Testeo que un objeto sea igual al otro.
 * etc ...
 */

@RunWith(AndroidJUnit4.class)
public class DatabaseInstrumentedTest {

    private DatabaseHandler db;

    /**
     *Antes de comenzar los test, creara la base de datos.
     */
    @Before
    public void startDb(){
        db = new DatabaseHandler(getTargetContext());
    }

    /**
     * Cuando termine la cerrara y la limpiara de los datos del telefono.
     */
    @After
    public void closeDb(){
        db.close();
        getTargetContext().deleteDatabase(db.getDatabaseName());
    }

    /**
     * Test que compruebo el correcto agregamiento de plantas a la base de datos. A demás de
     * algunas funcionalidad más.
     */
    @Test
    public void test_Planta(){

        assertNotNull(db);  //Comrpuebo primero que la bd no sea null y se haya inicializado correctamente.

        //Creo un obj. planta estandard.
        Planta planta = new Planta();
        planta.setId("123");
        planta.setNombre("Rosa");

        db.savePlanta(planta);  //Loa grego a la base de datos.

        assertTrue(db.existPlanta(planta.getId())); //Compruebo que exista en la base de datos y que se haya agregado correctamente.

        assertFalse(db.existPlanta("555")); //Compruebo que este no exista en bd y que por tanto el metodo funcione correctamente.

        assertTrue(db.getAllPlanta().size()>0); //Compruebo que el metodo que me devuelve un List<Planta> sea mayor a 0, porqué hay una planta agregada

        assertEquals(planta.getNombre(), db.getPlantaByIdplanta(planta.getId()).getNombre());   //Compruebo que el nombre de la planta de la bd coincida con el de la planta que cree al prinicpio.

        //Creo una segunda planta con un Id diferente.
        Planta planta2 = new Planta();
        planta2.setId("321");
        planta2.setNombre("Pino");

        db.savePlanta(planta2);

        assertTrue(db.existPlanta(planta2.getId()));

        assertEquals(2, db.getAllPlanta().size());  //Compruebo que el List<Planta> haya aumentado de tamaño.

        assertNotNull(db.getAllPlanta().get(0));    //Compruebo que la lista no me devuelve un obj. null.

}

    @Test
    public void test_Etapa(){

        assertNotNull(db);

        Etapa etapa = new Etapa();
        etapa.setNombre("Rosa");
        etapa.setDuracion(5);
        etapa.setHumMax(2);
        etapa.setHumMin(1);
        etapa.setLuzMax(20);
        etapa.setLuzMin(5);
        etapa.setTempMax(25);
        etapa.setTempMin(10);
        etapa.setHormona(500);
        etapa.setSustrato(45);
        etapa.setEdad(0);

        db.saveEtapa(etapa);

        assertTrue(db.existEtapa(etapa.getNombre(), etapa.getEdad()));
        assertFalse(db.existEtapa(etapa.getNombre(), 6));

        Etapa etapa1 = new Etapa();
        etapa1.setNombre("Rosa");
        etapa1.setDuracion(50);
        etapa1.setHumMax(20);
        etapa1.setHumMin(10);
        etapa1.setLuzMax(200);
        etapa1.setLuzMin(50);
        etapa1.setTempMax(250);
        etapa1.setTempMin(100);
        etapa1.setHormona(5000);
        etapa1.setSustrato(450);
        etapa1.setEdad(1);

        db.saveEtapa(etapa1);

        assertTrue(db.existEtapa(etapa1.getNombre(), etapa1.getEdad()));

        assertEquals(2, db.getAllEtapa().size());

        assertNotSame(db.getEtapaByNombreEdad(etapa.getNombre(), etapa.getEdad()), db.getEtapaByNombreEdad(etapa1.getNombre(), etapa1.getEdad()));

        assertEquals(2, db.getAllEtapaByName("Rosa").size());

        assertNull(db.getAllEtapaByName("Pino"));
    }

    @Test
    public void test_Plantada(){

        assertNotNull(db);

        Planta planta = new Planta();
        planta.setId("123");
        planta.setNombre("Rosa");
        planta.setTempActual(15);
        planta.setHumedadActual(5);
        planta.setLuzActual(50);
        planta.setHormona(10);
        planta.setSustrato(46);

        db.savePlantadas(planta);

        assertTrue(db.existPlantada(planta.getId()));

        assertFalse(db.existPlantada("555"));

        assertTrue(db.getAllPlantada().size()>0);

        assertEquals(planta.getNombre(), db.getPlantadaByIdplanta(planta.getId()).getNombre());

        Planta planta2 = new Planta();
        planta2.setId("321");
        planta2.setNombre("Pino");
        planta.setTempActual(15);
        planta.setHumedadActual(5);
        planta.setLuzActual(50);
        planta.setHormona(10);
        planta.setSustrato(46);

        db.savePlantadas(planta2);

        assertTrue(db.existPlantada(planta2.getId()));

        assertEquals(2, db.getAllPlantada().size());

        assertNotNull(db.getAllPlantada().get(0));
    }

    /**
     * Test para comprobar la correcta relacion entre Planta y Etapa.
     * Así como también el poder obtener las Etapas de una unica planta a partir de su nombre
     */

    @Test
    public void test_Planta_and_Etapa(){

        this.initDb(); //Inicializo 2 plantas diferentes y 2 etapas para una de las plantas.

        assertNotNull(db);

        Planta planta = db.getPlantaByIdplanta("123");  //Agarro la planta con ese Id.

        List<Etapa> etapaList = db.getAllEtapaByName(planta.getNombre());   //Las etapas de esa planta.

        assertNotNull(etapaList);

        planta.setEtapas((ArrayList<Etapa>) etapaList);

        assertNotNull(planta.getEtapas());

        assertEquals(planta.getEtapas().size(), db.getAllEtapaByName(planta.getNombre()).size());

        assertFalse(planta.unPaso());

        assertEquals(1, planta.getEtapas().size());

        assertEquals(200, planta.getEtapas().get(0).getLuzMax());
    }

    public void initDb(){

        Planta planta = new Planta();
        planta.setId("123");
        planta.setNombre("Rosa");
        planta.setTempActual(15);
        planta.setHumedadActual(5);
        planta.setLuzActual(50);
        planta.setHormona(10);
        planta.setSustrato(46);

        Planta planta2 = new Planta();
        planta2.setId("321");
        planta2.setNombre("Pino");
        planta.setTempActual(15);
        planta.setHumedadActual(5);
        planta.setLuzActual(50);
        planta.setHormona(10);
        planta.setSustrato(46);

        db.savePlanta(planta);
        db.savePlanta(planta2);

        Etapa etapa = new Etapa();
        etapa.setNombre("Rosa");
        etapa.setDuracion(2);
        etapa.setHumMax(2);
        etapa.setHumMin(1);
        etapa.setLuzMax(20);
        etapa.setLuzMin(5);
        etapa.setTempMax(25);
        etapa.setTempMin(10);
        etapa.setHormona(500);
        etapa.setSustrato(45);
        etapa.setEdad(0);

        Etapa etapa1 = new Etapa();
        etapa1.setNombre("Rosa");
        etapa1.setDuracion(50);
        etapa1.setHumMax(20);
        etapa1.setHumMin(10);
        etapa1.setLuzMax(200);
        etapa1.setLuzMin(50);
        etapa1.setTempMax(250);
        etapa1.setTempMin(100);
        etapa1.setHormona(5000);
        etapa1.setSustrato(450);
        etapa1.setEdad(1);

        db.saveEtapa(etapa);
        db.saveEtapa(etapa1);
    }

}
