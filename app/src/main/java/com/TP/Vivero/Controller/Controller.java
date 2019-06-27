package com.TP.Vivero.Controller;

import android.content.Context;
import android.widget.Toast;

import com.TP.Vivero.MainActivity;
import com.TP.Vivero.Model.AgregarModel;
import com.TP.Vivero.Model.DatabaseHandler;
import com.TP.Vivero.Model.PasoTiempoModel;
import com.TP.Vivero.Model.RemoverModel;
import com.TP.Vivero.Model.SimuladorAleatorios;
import com.TP.Vivero.Model.TimeModel;
import com.TP.Vivero.Object.Planta;
import com.TP.Vivero.Vista.Activity.MainMenuActivity;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class Controller implements Observer {

    private Context context;
    private DatabaseHandler db;
    private SimuladorAleatorios simuladorAleatorios;

    public Controller(Context context){

        this.context = context;
        db = new DatabaseHandler(context);
        simuladorAleatorios = new SimuladorAleatorios();
    }

    @Override
    public void update(Observable o, Object arg) {

        if(o.getClass().equals(PasoTiempoModel.class)) {

            //Toast.makeText(context, "Un Paso", Toast.LENGTH_SHORT).show();

            ArrayList<Planta> plantas = (ArrayList)db.getAllPlantada();

            for(Planta planta: plantas){

                if(planta.siguiente()){
                    db.deletePlantadaByUbicacion(planta.getUbicacion());
                }

            }
        }

        if(o.getClass().equals(TimeModel.class)) {

            actualizarParametros();

            //Toast.makeText(context, "Time", Toast.LENGTH_SHORT).show();
        }

        if(o.getClass().equals(AgregarModel.class)){

            Planta planta = (Planta) arg;

            db.savePlantadas(planta);

            Toast.makeText(context, "Agregar", Toast.LENGTH_SHORT).show();
        }

        if(o.getClass().equals(RemoverModel.class)){

            Planta planta = (Planta) arg;

            db.deletePlantadaByUbicacion(planta.getUbicacion());

            //Toast.makeText(context, "Remove", Toast.LENGTH_SHORT).show();
        }
    }

    public Boolean actualizarParametros()
    {
        MainMenuActivity activity =(MainMenuActivity) context;
        ArrayList<Planta> plantas =(ArrayList<Planta>) db.getAllPlantada();

        if(activity.getAgFragment().getAdapter()== null)
        {
            return false;
        }
        else
        {
            for(Planta planta: plantas)
            {
                int temp= simuladorAleatorios.getTempSimulada();
                int hum = simuladorAleatorios.getPorcentajeSimulado();
                int luz = simuladorAleatorios.getLuzSimulado();

                planta.actualizarParametros(temp,hum,luz);
                db.savePlantadas(planta);
            }
            activity.getAgFragment().getAdapter().addPlantas((ArrayList<Planta>)db.getAllPlantada());
        }
        return true;
    }
}
