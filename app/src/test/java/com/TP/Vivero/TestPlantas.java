package com.TP.Vivero;

import com.TP.Vivero.Object.Etapa;
import com.TP.Vivero.Object.FabricaPlantas;
import com.TP.Vivero.Object.Planta;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class TestPlantas {

    @Test
    public void PobarFabricaPlantas(){

        FabricaPlantas fabrica = new FabricaPlantas();

        Planta planta = fabrica.crearPlanta("Pino");
        assertTrue(planta.toString().equals("Peren"));

        Planta planta2 = fabrica.crearPlanta("Soja");
        assertTrue(planta2.toString().equals("Anual"));

        Planta planta3 = fabrica.crearPlanta("Cebolla");
        assertTrue(planta3.toString().equals("Bianual"));



    }


    @Test
    public void ProbarPlantaPerenne(){

        FabricaPlantas fabrica = new FabricaPlantas();

        Planta planta = fabrica.crearPlanta("Pino");

        planta.setNombre("Pino");

        Etapa etapa1 = new Etapa();
        Etapa etapa2 = new Etapa();
        Etapa etapa3 = new Etapa();

        etapa1.setNombre("Pino");
        etapa2.setNombre("Pino");
        etapa3.setNombre("Pino");
        etapa1.setNumetapa(1);
        etapa2.setNumetapa(2);
        etapa3.setNumetapa(3);
        etapa1.setDuracion(3);
        etapa2.setDuracion(3);
        etapa3.setDuracion(2);
        etapa1.setProgreso_duracion(0);
        etapa2.setProgreso_duracion(0);
        etapa3.setProgreso_duracion(0);
        etapa1.setHumMin(9);
        etapa2.setHumMin(18);
        etapa3.setHumMin(5);

        ArrayList<Etapa> etapas = new ArrayList<Etapa>();
        etapas.add(etapa1);
        etapas.add(etapa2);
        etapas.add(etapa3);

        planta.setEtapas(etapas);

        assertTrue(planta.toString().equals("Perenne"));

        planta.siguiente();
        planta.siguiente();
        planta.siguiente();

        assertTrue(planta.getEtapaActual().getNumetapa()==1);

        planta.siguiente();

        assertTrue(planta.getEtapaActual().getNumetapa()==2);

        planta.siguiente();
        planta.siguiente();
        planta.siguiente();
        planta.siguiente();

        assertTrue(planta.getEtapaActual().getNumetapa()==3);

        planta.siguiente();
        planta.siguiente();
        assertTrue(planta.getEtapaActual().getNumetapa()==3);

        planta.siguiente();
        assertTrue(planta.getEtapaActual().getNumetapa()==2);
        assertTrue(planta.getEtapaActual().getProgreso_duracion()==0);

        planta.siguiente();
        assertTrue(planta.getEtapaActual().getProgreso_duracion()==1);
    }


    @Test
    public void ProbarPlantaBianual(){


        FabricaPlantas fabrica = new FabricaPlantas();

        Planta planta = fabrica.crearPlanta("Zanahoria");

        planta.setNombre("Zanahoria");

        Etapa etapa1 = new Etapa();
        Etapa etapa2 = new Etapa();
        Etapa etapa3 = new Etapa();

        etapa1.setNombre("Zanahoria");
        etapa2.setNombre("Zanahoria");
        etapa3.setNombre("Zanahoria");
        etapa1.setNumetapa(1);
        etapa2.setNumetapa(2);
        etapa3.setNumetapa(3);
        etapa1.setDuracion(3);
        etapa2.setDuracion(3);
        etapa3.setDuracion(2);
        etapa1.setProgreso_duracion(0);
        etapa2.setProgreso_duracion(0);
        etapa3.setProgreso_duracion(0);
        etapa1.setHumMin(9);
        etapa2.setHumMin(18);
        etapa3.setHumMin(5);

        ArrayList<Etapa> etapas = new ArrayList<Etapa>();
        etapas.add(etapa1);
        etapas.add(etapa2);
        etapas.add(etapa3);

        planta.setEtapas(etapas);

        assertTrue(planta.toString().equals("Bianual"));

        planta.siguiente();
        planta.siguiente();
        planta.siguiente();

        assertTrue(planta.getEtapaActual().getNumetapa()==1);

        planta.siguiente();

        assertTrue(planta.getEtapaActual().getNumetapa()==2);

        planta.siguiente();
        planta.siguiente();
        planta.siguiente();
        planta.siguiente();

        assertTrue(planta.getEtapaActual().getNumetapa()==3);

        planta.siguiente();
        planta.siguiente();
        assertTrue(planta.getEtapaActual().getNumetapa()==3);

        planta.siguiente();
        assertTrue(planta.getEtapaActual().getNumetapa()==2);
        assertTrue(planta.getEtapaActual().getProgreso_duracion()==0);

        planta.siguiente();
        assertTrue(planta.getEtapaActual().getProgreso_duracion()==1);

        planta.siguiente();
        assertTrue(planta.getEtapaActual().getNumetapa()==2);

        planta.siguiente();
        assertTrue(planta.getEtapaActual().getNumetapa()==2);

        planta.siguiente();
        assertTrue(planta.getEtapaActual().getNumetapa()==3);

        assertFalse(planta.siguiente());
        assertFalse(planta.siguiente());
        assertTrue(planta.siguiente());
    }

    @Test
    public void ProbarPlantaAnual(){

        FabricaPlantas fabrica = new FabricaPlantas();

        Planta planta = fabrica.crearPlanta("Maiz");

        planta.setNombre("Maiz");

        Etapa etapa1 = new Etapa();
        Etapa etapa2 = new Etapa();
        Etapa etapa3 = new Etapa();

        etapa1.setNombre("Maiz");
        etapa2.setNombre("Maiz");
        etapa3.setNombre("Maiz");
        etapa1.setNumetapa(1);
        etapa2.setNumetapa(2);
        etapa3.setNumetapa(3);
        etapa1.setDuracion(3);
        etapa2.setDuracion(3);
        etapa3.setDuracion(2);
        etapa1.setProgreso_duracion(0);
        etapa2.setProgreso_duracion(0);
        etapa3.setProgreso_duracion(0);
        etapa1.setHumMin(9);
        etapa2.setHumMin(18);
        etapa3.setHumMin(5);

        ArrayList<Etapa> etapas = new ArrayList<Etapa>();
        etapas.add(etapa1);
        etapas.add(etapa2);
        etapas.add(etapa3);

        planta.setEtapas(etapas);

        assertTrue(planta.toString().equals("Anual"));

        planta.siguiente();
        planta.siguiente();
        planta.siguiente();

        assertTrue(planta.getEtapaActual().getNumetapa()==1);

        planta.siguiente();

        assertTrue(planta.getEtapaActual().getNumetapa()==2);

        planta.siguiente();
        planta.siguiente();
        planta.siguiente();
        planta.siguiente();

        assertTrue(planta.getEtapaActual().getNumetapa()==3);

        planta.siguiente();
        assertFalse(planta.siguiente());
        assertTrue(planta.siguiente());

    }

}