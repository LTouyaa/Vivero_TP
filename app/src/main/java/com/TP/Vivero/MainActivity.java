package com.TP.Vivero;

import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.TP.Vivero.Object.Planta;
import com.TP.Vivero.Object.PlantaAnual;
import com.TP.Vivero.Object.PlantaPerenne;
import com.TP.Vivero.R;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText nombre;
    private EditText apellido;

    private Button login;
    private Button ver;

    ViewModel model;

    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;

        nombre = findViewById(R.id.edt_1);
        apellido = findViewById(R.id.ed_2);
        login = findViewById(R.id.btm_1);
        ver = findViewById(R.id.btm_view_model);

       Planta planta = new PlantaAnual("Hola");
       Planta planta2 = new PlantaPerenne("Adios");

       ((PlantaAnual) planta).siguiente();

       ((PlantaPerenne) planta2).siguiente();

       Planta plantaAnual = new PlantaAnual("adada");






    }

    @Override
    public void onClick(View v) {

    }


}
