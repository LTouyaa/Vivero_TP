package com.example.nuevaprueba.ui.activity;

import android.arch.lifecycle.ViewModelProviders;
import android.arch.lifecycle.ViewModelStoreOwner;
import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.nuevaprueba.MainActivity;
import com.example.nuevaprueba.R;
import com.example.nuevaprueba.controller.Controller;
import com.example.nuevaprueba.model.ViewModel;

public class AgregarPlantaActivity extends AppCompatActivity {

    private EditText ed_nomb_plant;

    private Button btm_add_plant;

//    ViewModel model;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_planta);

        context = this;

        ed_nomb_plant = findViewById(R.id.edit_nom_plant);
        btm_add_plant = findViewById(R.id.btm_add_plant);

        btm_add_plant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });

    }
}
