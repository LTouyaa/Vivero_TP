package com.TP.Vivero.Controller;

import android.content.Context;
import android.widget.Toast;

import com.TP.Vivero.MainActivity;
import com.TP.Vivero.Model.AgregarModel;
import com.TP.Vivero.Model.DatabaseHandler;
import com.TP.Vivero.Model.Modelo;
import com.TP.Vivero.Model.PasoTiempoModel;
import com.TP.Vivero.Model.RemoverModel;
import com.TP.Vivero.Model.SimuladorAleatorios;
import com.TP.Vivero.Model.TimeModel;
import com.TP.Vivero.Object.FabricaPlantas;
import com.TP.Vivero.Object.Planta;
import com.TP.Vivero.Vista.Activity.MainMenuActivity;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class Controller implements Observer {

    private Context context;
    private DatabaseHandler db;
    private SimuladorAleatorios simuladorAleatorios;
    private Modelo modelo;

    public Controller(Context context){

        this.context = context;
        db = new DatabaseHandler(context);
        simuladorAleatorios = new SimuladorAleatorios();
        this.modelo= new Modelo();
    }

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    @Override
    public void update(Observable o, Object arg) {

        if(o.getClass().equals(PasoTiempoModel.class)) {

            //Toast.makeText(context, "Un Paso", Toast.LENGTH_SHORT).show();

            ArrayList<Planta> plantas = (ArrayList<Planta>) modelo.getAllPlantadas().clone();

            FabricaPlantas fabricaPlantas = new FabricaPlantas();

            if(!plantas.isEmpty()) {

                for (Planta planta : plantas) {

                    if (planta.siguiente()) {
                        plantas.remove(planta);
                    }

                }

                modelo.agregarPlanta(plantas);
            }

        }

        if(o.getClass().equals(TimeModel.class)) {

            actualizarParametros();

            //Toast.makeText(context, "Time", Toast.LENGTH_SHORT).show();
        }

        if(o.getClass().equals(AgregarModel.class)){

            Planta planta = (Planta) arg;

            modelo.agregarPlanta(planta);


            Toast.makeText(context, "Agregado", Toast.LENGTH_SHORT).show();
        }

        if(o.getClass().equals(RemoverModel.class)){

            Planta planta = (Planta) arg;
            modelo.removerPlanta(planta.getUbicacion());



            //Toast.makeText(context, "Remove", Toast.LENGTH_SHORT).show();
        }
    }

    public Boolean actualizarParametros()
    {
        MainMenuActivity activity =(MainMenuActivity) context;

        ArrayList<Planta> plantas;
        plantas = (ArrayList<Planta>) modelo.getAllPlantadas().clone();

        if(plantas!=null) {

            if (activity.getAgFragment().getAdapter() == null) {
                return false;
            } else {
                for (Planta planta : plantas) {

                    int temp = simuladorAleatorios.getTempSimulada();
                    int hum = simuladorAleatorios.getPorcentajeSimulado();
                    int luz = simuladorAleatorios.getLuzSimulado();

                    planta.actualizarParametros(temp, hum, luz);
                }


                //modelo.clearPlantadas();



                activity.getAgFragment().getAdapter().addPlantas(plantas);
            }
        }
        return true;
    }
}
