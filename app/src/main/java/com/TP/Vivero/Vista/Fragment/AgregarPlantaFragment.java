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
<<<<<<< HEAD
import android.widget.Toast;
=======
>>>>>>> RamaLucas

import com.TP.Vivero.Controller.Controller;
import com.TP.Vivero.Model.DatabaseHandler;
import com.TP.Vivero.Object.Planta;
import com.TP.Vivero.R;

public class AgregarPlantaFragment extends Fragment {

    private Context context;
    private Button boton;

<<<<<<< HEAD
    private Controller controller;
=======
    Controller controller;
>>>>>>> RamaLucas

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
<<<<<<< HEAD
    }

    public void setController(Controller controller){
        this.controller = controller;
=======


>>>>>>> RamaLucas
    }

    public void crearPlanta(){

        EditText nombrePlanta = (EditText)getView().findViewById(R.id.edit_nombre_planta);
        EditText ubicacionPlanta = (EditText)getView().findViewById(R.id.edit_ubicacion_planta);

        DatabaseHandler BasedeDatos = new DatabaseHandler(context);
        
        Planta P;

<<<<<<< HEAD
        if(!nombrePlanta.getText().toString().isEmpty() && !ubicacionPlanta.getText().toString().isEmpty()){

            if(BasedeDatos.existPlanta(nombrePlanta.getText().toString())){


                if(!BasedeDatos.existPlantada(Integer.parseInt(ubicacionPlanta.getText().toString()))){

                    P = BasedeDatos.getPlantaByNomb(nombrePlanta.getText().toString());
                    P.setUbicacion(Integer.parseInt(ubicacionPlanta.getText().toString()));
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
=======
        if(nombrePlanta.getText()!=null && ubicacionPlanta.getText()!=null){    //Compruebo que no esten los campos vacios

            if(BasedeDatos.existPlanta(nombrePlanta.getText().toString())){     //Compruebo que el nombre de la planta sea un dato valido

                if(BasedeDatos.existPlantada(Integer.parseInt(ubicacionPlanta.getText().toString()))){  //Compruebo que la ubicacion no este ocupada

                    P = BasedeDatos.getPlantaByNomb(nombrePlanta.getText().toString()); //Recibo una nueva planta de la base de datos mediante el ingreso del nombre
                    assert(P!=null);
                    assert(P.getNombre()!=null);

                    P.setUbicacion(Integer.parseInt(ubicacionPlanta.getText().toString())); //Seteo su ubicacion

                    BasedeDatos.savePlantadas(P);   //Guardo la nueva planta en la base de datos


                } else{

                    //Medida a tomar si la ubicacion ya esta ocupada

                }


            } else{

                //Medida a tomar si el nombre de la planta ingresado no se corresponde con alguno de la base de datos

            }


        } else{

            //Medida a tomar si no se ingresan textos en los EditText

        }


    }

    public void setController(Controller controller){
        this.controller = controller;
    }

>>>>>>> RamaLucas
}
