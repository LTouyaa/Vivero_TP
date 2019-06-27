package com.TP.Vivero.Controller;

import android.content.Context;
import android.widget.Toast;

import com.TP.Vivero.MainActivity;
import com.TP.Vivero.Model.AgregarModel;
import com.TP.Vivero.Model.DatabaseHandler;
import com.TP.Vivero.Model.PasoTiempoModel;
import com.TP.Vivero.Model.RemoverModel;
import com.TP.Vivero.Model.TimeModel;
import com.TP.Vivero.Object.Planta;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class Controller implements Observer {

    private Context context;
    private DatabaseHandler db;

    public Controller(Context context){

        this.context = context;
        db = new DatabaseHandler(context);
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
}
