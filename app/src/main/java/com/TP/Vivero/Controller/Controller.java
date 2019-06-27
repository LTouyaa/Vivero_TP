package com.TP.Vivero.Controller;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.widget.Toast;

import com.TP.Vivero.MainActivity;
import com.TP.Vivero.Model.DatabaseHandler;

import com.TP.Vivero.Model.SimuladorAleatorios;
import com.TP.Vivero.Model.TimeModel;
import com.TP.Vivero.Object.Planta;
import com.TP.Vivero.Vista.Activity.MainMenuActivity;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class Controller implements Observer {

    private Context context;

    private SimuladorAleatorios simuladorAleatorios;
    private DatabaseHandler bd;


    public Controller(Context context) {
        this.context = context;

        simuladorAleatorios = new SimuladorAleatorios();
        bd = new DatabaseHandler(context);


    }

    @Override
    public void update(Observable o, Object arg) {


        if (o.getClass().equals(TimeModel.class)) {

            Toast.makeText(context, "TimeModel", Toast.LENGTH_SHORT).show();

            actualizarParametros();
        }
    }

    public Boolean actualizarParametros() {

        MainMenuActivity activity = (MainMenuActivity) context;
        ArrayList<Planta> plantas = (ArrayList<Planta>) bd.getAllPlantada();

        if (activity.getAgFragment().getAdapter() == null) {
            return false;
        } else {
//            activity.getAgFragment().getAdapter().resetear();

            for (Planta planta : plantas) {
                int temp = simuladorAleatorios.getTempSimulada();
                int hum = simuladorAleatorios.getPorcentajeSimulado();
                int luz = simuladorAleatorios.getLuzSimulado();
                planta.actualizarParametros(temp, hum, luz);

                bd.savePlantadas(planta);

//                if (!planta.tempCorrecta()) {
//                    activity.getAgFragment().getAdapter().tempFueraDeRango(planta.getUbicacion());
//                }
//
//                if (!planta.humCorrecta()) {
//                    activity.getAgFragment().getAdapter().humFueraDeRango(planta.getUbicacion());
//                }
//                if (!planta.luzCorrecta()) {
//                    activity.getAgFragment().getAdapter().LuzFueraDeRango(planta.getUbicacion());
//                }
//
//                activity.getAgFragment().getAdapter().resetear();

            }

            activity.getAgFragment().getAdapter().addPlantas((ArrayList<Planta>) bd.getAllPlantada());

            return true;
        }
    }
}
