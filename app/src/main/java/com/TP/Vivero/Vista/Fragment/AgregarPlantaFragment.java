package com.TP.Vivero.Vista.Fragment;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.TP.Vivero.Model.DatabaseHandler;
import com.TP.Vivero.Object.Planta;
import com.TP.Vivero.R;

public class AgregarPlantaFragment extends Fragment {

    private Context context;
    private Button boton;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_agregar_planta,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        context = getActivity();

        boton = (Button)getView().findViewById(R.id.boton_crear);

        boton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                crearPlanta();
            }
        });


    }

    public void crearPlanta(){

        EditText nombrePlanta = (EditText)getView().findViewById(R.id.edit_nombre_planta);
        EditText ubicacionPlanta = (EditText)getView().findViewById(R.id.edit_ubicacion_planta);

        DatabaseHandler BasedeDatos = new DatabaseHandler(context);
        
        Planta P;


        if(nombrePlanta.getText()!=null && ubicacionPlanta.getText()!=null){

            if(BasedeDatos.existPlanta(nombrePlanta.getText().toString())){

                Integer integer =  Integer.getInteger(ubicacionPlanta.getText().toString());
                if(BasedeDatos.existPlantada(integer )){

                    P = BasedeDatos.getPlantaByNomb(nombrePlanta.getText().toString());
                    assert(P!=null);
                    assert(P.getNombre()!=null);

                    //Seguro falta algo de hacer

                    BasedeDatos.savePlantadas(P);

                    Toast.makeText(context,"La planta se agregó correctamente", Toast.LENGTH_SHORT).show();



                } else{


                    Toast.makeText(context,"La ubicacion esta ocupada",Toast.LENGTH_SHORT).show();
                    //Medida a tomar si la ubicacion ya esta ocupada

                }


            } else{

            Toast.makeText(context,"El nombre ingresado no es valido",Toast.LENGTH_SHORT).show();
                //Medida a tomar si el nombre de la planta ingresado no se corresponde con alguno de la base de datos


            }


        } else{

            //Medida a tomar si no se ingresan textos en los EditText
            Toast.makeText(context,"Datos vacios",Toast.LENGTH_SHORT).show();

        }


    }

}
