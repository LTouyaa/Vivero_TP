package com.TP.Vivero.Vista.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.TP.Vivero.Controller.Controller;
import com.TP.Vivero.Model.DatabaseHandler;
import com.TP.Vivero.Model.RemoverModel;
import com.TP.Vivero.R;
import com.TP.Vivero.Vista.Activity.MainMenuActivity;

public class RemoverPlantaFragment extends Fragment {


    private Context context;
    private Button boton;

    EditText ubicacionPlanta;

    DatabaseHandler BasedeDatos;

    Controller controller;
    private RemoverModel removerModel;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_remover_planta,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        context = getActivity();

        removerModel = new RemoverModel(controller);

        boton = (Button)getView().findViewById(R.id.boton_remover);

        boton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                removerPlanta();
            }
        });


    }

    public void removerPlanta(){
        MainMenuActivity mainMenuActivity = (MainMenuActivity) context;

        ubicacionPlanta  = getView().findViewById(R.id.edit_ubicacion_plantaremover);

        BasedeDatos = new DatabaseHandler(context);

        if(ubicacionPlanta.getText()!=null){

            int ubic = Integer.parseInt(ubicacionPlanta.getText().toString());

            if(controller.getModelo().existPlantada(ubic)){

                removerModel.removerPlanta(controller.getModelo().getPlantada(ubic));
                clear();

                //Eliminar la planta ingresando la ubicacion en la base de datos

            }else{

                Toast.makeText(context, "La planta no se encuentra plantada", Toast.LENGTH_SHORT).show();

                //Medida a tomar si la ubicacion ingresada no tiene ninguna planta

            }

        }else{

            Toast.makeText(context, "El campo esta vacio", Toast.LENGTH_SHORT).show();

            //Medida a tomar si el campo esta vacio
        }
    }

    public void setController(Controller controller){
        this.controller = controller;
    }

    public void clear(){
        ubicacionPlanta.setText(null);
    }
}
