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

import com.TP.Vivero.Controller.Controller;
import com.TP.Vivero.Model.DatabaseHandler;
import com.TP.Vivero.R;

public class RemoverPlantaFragment extends Fragment {


    private Context context;
    private Button boton;

    Controller controller;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_remover_planta,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        context = getActivity();

        boton = (Button)getView().findViewById(R.id.boton_remover);

        boton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                removerPlanta();
            }
        });


    }

    public void removerPlanta(){

        EditText ubicacionPlanta = (EditText)getView().findViewById(R.id.edit_ubicacion_plantaremover);

        DatabaseHandler BasedeDatos = new DatabaseHandler(context);

        if(ubicacionPlanta.getText()!=null){

            if(BasedeDatos.existPlantada(Integer.parseInt(ubicacionPlanta.getText().toString()))){

                //Eliminar la planta ingresando la ubicacion en la base de datos

            }else{

                //Medida a tomar si la ubicacion ingresada no tiene ninguna planta

            }

        }else{

            //Medida a tomar si el campo esta vacio
        }
    }

    public void setController(Controller controller){
        this.controller = controller;
    }

}
